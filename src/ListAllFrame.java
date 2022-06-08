import business.abstracts.Operations;
import business.concretes.FileOperations;
import entities.Book;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAllFrame extends Frame{
    Book bookOne;
    ListAllFrame(){
        String labelString;
        Operations operations= new FileOperations();
        List<Book> allBooklist=new ArrayList<>();
        JPanel listAllPanel = new JPanel();
        try {
            allBooklist=operations.getAllBook();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(listAllPanel,"File Error","Error",JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(listAllPanel,"Book not found","Error",JOptionPane.ERROR_MESSAGE);
        }
        DefaultListModel<Book> defaultListModel = new DefaultListModel<>();
        for (Book book :
                allBooklist) {
            defaultListModel.addElement(book);

        }
        JList<Book> list = new JList<>(defaultListModel);
        list.setCellRenderer(new BookRenderer());
        listAllPanel.setLayout(new GridLayout(2,1));
        labelString=String.format("Book count:%d AvgPageNumber:%.2f Total PageNumber:%d",
                operations.bookCount(allBooklist),operations.avgFileNumber(allBooklist),
                operations.sumPageNumber(allBooklist));
        JLabel sumAllBooks = new JLabel(labelString);
        listAllPanel.add(list);
        listAllPanel.add(sumAllBooks);
        super.add(listAllPanel);
        super.setSize(600,600);
    }
}
