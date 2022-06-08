import business.abstracts.Operations;
import business.concretes.FileOperations;
import entities.Book;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateFrame extends Frame {
    private Book book;
    UpdateFrame() {
        book=new Book();
        Operations operations=new FileOperations();
        JPanel updatePanel = new JPanel();
        Border updateSearch = BorderFactory.createTitledBorder("Enter id for Search");
        updatePanel.setBorder(updateSearch);
        updatePanel.setLayout(new GridLayout(6, 2));

        JTextField searchKey = new JTextField(25);
        JButton searchButton = new JButton("Search");
        JLabel name = new JLabel("Book Name : ");
        JTextField bookNameField = new JTextField("", 25);
        JLabel author = new JLabel("Author Name : ");
        JTextField authorNameField = new JTextField("", 25);
        JLabel pageNumber = new JLabel("Page Number : ");
        JTextField pageNumberField = new JTextField("", 4);
        JLabel topic = new JLabel("Topic : ");
        JTextField topicField = new JTextField("", 25);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    book=operations.getBookById(Integer.parseInt(searchKey.getText()));
                    bookNameField.setText(book.getBookName());
                    authorNameField.setText(book.getBookAuthor());
                    pageNumberField.setText(String.valueOf(book.getPageNumber()));
                    topicField.setText(book.getBookTopic());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(updatePanel,"File Error","Error",JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(updatePanel,"Book not found","Error",JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(updatePanel,"Invalid Id try again","Error",JOptionPane.ERROR_MESSAGE);
                    searchKey.setText("");
                }
            }
        });
        updatePanel.add(searchKey);
        updatePanel.add(searchButton);



        updatePanel.add(name);
        updatePanel.add(bookNameField);
        updatePanel.add(author);
        updatePanel.add(authorNameField);
        updatePanel.add(pageNumber);
        updatePanel.add(pageNumberField);
        updatePanel.add(topic);
        updatePanel.add(topicField);

        JLabel updateButtonLabel = new JLabel("Click Button for update -->");
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    book.setBookName(bookNameField.getText());
                    book.setBookAuthor(authorNameField.getText());
                    book.setPageNumber(Integer.parseInt(pageNumberField.getText()));
                    book.setBookTopic(topicField.getText());
                    operations.updateBook(book);
                    JOptionPane.showMessageDialog(updatePanel,"Book updated.");
                }catch (IOException ex) {
                JOptionPane.showMessageDialog(updatePanel,"File Error","Error",JOptionPane.ERROR_MESSAGE);
            }
                catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(updatePanel,"Invalid page number try again","Error",JOptionPane.ERROR_MESSAGE);
                pageNumberField.setText("");
            }
            }
        });
        updatePanel.add(updateButtonLabel);
        updatePanel.add(updateButton);

        super.add(updatePanel);
    }
}
