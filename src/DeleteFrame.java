import business.abstracts.Operations;
import business.concretes.FileOperations;
import entities.Book;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteFrame extends Frame {
    Book book;
    int id;

    DeleteFrame(){
        Operations operations=new FileOperations();
        book=new Book();
        JPanel deletePanel = new JPanel();
        Border updateSearch = BorderFactory.createTitledBorder("Enter a id for delete");
        deletePanel.setBorder(updateSearch);
        deletePanel.setLayout(new GridLayout(6, 2));
        JLabel name = new JLabel("Book Name : ");
        JLabel bookNameField = new JLabel("");
        JLabel author = new JLabel("Author Name : ");
        JLabel authorNameField = new JLabel("");
        JLabel pageNumber = new JLabel("Page Number : ");
        JLabel pageNumberField = new JLabel("");
        JLabel topic = new JLabel("Topic : ");
        JLabel topicField = new JLabel("");

        JTextField searchKey = new JTextField(25);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id=Integer.parseInt(searchKey.getText());
                    book=operations.getBookById(id);
                    bookNameField.setText(book.getBookName());
                    authorNameField.setText(book.getBookAuthor());
                    topicField.setText(book.getBookTopic());
                    pageNumberField.setText(String.valueOf(book.getPageNumber()));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(deletePanel,"File Error","Error",JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(deletePanel,"Book not found","Error",JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(deletePanel,"Invalid Id try again","Error",JOptionPane.ERROR_MESSAGE);
                    searchKey.setText("");
                }
            }
        });
        deletePanel.add(searchKey);
        deletePanel.add(searchButton);



        deletePanel.add(name);
        deletePanel.add(bookNameField);
        deletePanel.add(author);
        deletePanel.add(authorNameField);
        deletePanel.add(pageNumber);
        deletePanel.add(pageNumberField);
        deletePanel.add(topic);
        deletePanel.add(topicField);

        JLabel deleteButtonLabel = new JLabel("Click Button for delete -->");
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operations.deleteBook(id);
                    JOptionPane.showMessageDialog(deletePanel,"%s deleted from file.".formatted(book.getBookName()));
                }catch (IOException ex) {
                    JOptionPane.showMessageDialog(deletePanel,"File Error","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deletePanel.add(deleteButtonLabel);
        deletePanel.add(deleteButton);

        super.add(deletePanel);
    }
}
