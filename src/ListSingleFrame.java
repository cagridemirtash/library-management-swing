import business.abstracts.Operations;
import business.concretes.FileOperations;
import entities.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListSingleFrame extends Frame{
    int id;
    Book book;
    ListSingleFrame(){
        book=new Book();
        Operations operations=new FileOperations();
        JPanel listSinglePanel = new JPanel();
        listSinglePanel.setLayout(new GridLayout(2,1));
        JTextField searchKey = new JTextField(25);
        JButton searchButton = new JButton("Search");
        JLabel bookNameData = new JLabel("");
        JLabel bookAuthorData = new JLabel("");
        JLabel bookPageNumberData = new JLabel("");
        JLabel bookTopicData = new JLabel("");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id=Integer.parseInt(searchKey.getText());
                    book=operations.getBookById(id);
                    bookNameData.setText(book.getBookName());
                    bookAuthorData.setText(book.getBookAuthor());
                    bookTopicData.setText(book.getBookTopic());
                    bookPageNumberData.setText(String.valueOf(book.getPageNumber()));


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                catch (NumberFormatException ex){

                }
                catch (NullPointerException ex){

                }
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        searchPanel.add(searchKey);
        searchPanel.add(searchButton)
        ;
        JPanel dataPanel = new JPanel();
        JLabel bookName = new JLabel("BookName");
        JLabel bookAuthor = new JLabel("BookAuthor");
        JLabel bookPageNumber = new JLabel("BookPageNumber");
        JLabel bookTopic = new JLabel("BookTopic");



        dataPanel.setLayout(new GridLayout(2,4));
        dataPanel.add(bookName);
        dataPanel.add(bookAuthor);
        dataPanel.add(bookPageNumber);
        dataPanel.add(bookTopic);
        dataPanel.add(bookNameData);
        dataPanel.add(bookAuthorData);
        dataPanel.add(bookPageNumberData);
        dataPanel.add(bookTopicData);

        listSinglePanel.add(searchPanel);
        listSinglePanel.add(dataPanel);
        super.setSize(600,250);
        super.add(listSinglePanel);
    }
}
