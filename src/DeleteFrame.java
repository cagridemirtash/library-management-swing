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
        JPanel updatePanel = new JPanel();
        Border updateSearch = BorderFactory.createTitledBorder("Enter a id for delete");
        updatePanel.setBorder(updateSearch);
        updatePanel.setLayout(new GridLayout(6, 2));
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

        JLabel deleteButtonLabel = new JLabel("Click Button for delete -->");
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operations.deleteBook(id);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        updatePanel.add(deleteButtonLabel);
        updatePanel.add(deleteButton);

        super.add(updatePanel);
    }
}
