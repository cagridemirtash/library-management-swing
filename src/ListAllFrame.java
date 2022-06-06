import Entities.Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListAllFrame extends Frame{
    Book bookOne;
    ListAllFrame(){
        bookOne = new Book();
        bookOne.setId(2);
        bookOne.setBookName("Oğuzun Hayatı");
        bookOne.setBookTopic("Acı ve Korku");
        bookOne.setBookAuthor("Oğuzhan Tarhan");
        bookOne.setPageNumber(0);

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        defaultListModel.addElement(bookOne.getBookAuthor());

        JPanel listAll = new JPanel();

        JList<String> list = new JList<>(defaultListModel);
        listAll.add(list);
        super.add(listAll);
    }
}
