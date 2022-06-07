import business.abstracts.Operations;
import business.concretes.FileOperations;
import entities.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateFrame extends Frame {
    public JTextField bookName, bookAuthor, bookPageNumber, bookTopic;
    private Book book;
    CreateFrame(){
        FileOperations operations=new FileOperations();
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(5,2));
        //Book Name Start
        JLabel name = new JLabel("Book Name : ");
        bookName = new JTextField(25);
        //Book Name End
        JLabel author = new JLabel("Author Name : ");
        bookAuthor = new JTextField(25);
        JLabel pageNumber = new JLabel("Page Number : ");
        bookPageNumber = new JTextField(4);
        JLabel topic = new JLabel("Topic : ");
        bookTopic = new JTextField(25);

        createPanel.add(name);
        createPanel.add(bookName);
        createPanel.add(author);
        createPanel.add(bookAuthor);
        createPanel.add(pageNumber);
        createPanel.add(bookPageNumber);
        createPanel.add(topic);
        createPanel.add(bookTopic);

        JLabel saveButtonLabel = new JLabel("Click Button for save -->");
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book=new Book();

                try {
                    book.setId(operations.lastIndex());
                    book.setBookName(bookName.getText());
                    book.setBookAuthor(bookAuthor.getText());
                    book.setPageNumber(Integer.parseInt(bookPageNumber.getText()));
                    book.setBookTopic(bookTopic.getText());

                    operations.addBook(book);
                } catch (IOException ex) {
                    System.out.println("IO exception");
                }

            }
        });
        createPanel.add(saveButtonLabel);
        createPanel.add(saveButton);
        super.add(createPanel);



    }
}
