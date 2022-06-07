import entities.Book;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListAllFrame extends Frame{
    Book bookOne;
    ListAllFrame(){
        JList<String> list = new JList<String>();
        JPanel listAllPanel = new JPanel();
        listAllPanel.setLayout(new GridLayout(2,1));

        JLabel sumAllBooks = new JLabel("Buraya listelicez");
        listAllPanel.add(sumAllBooks);
        listAllPanel.add(list);
        super.add(listAllPanel);
        super.setSize(600,600);
    }
}
