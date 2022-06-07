import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListSingleFrame extends Frame{
    ListSingleFrame(){
        JPanel listSinglePanel = new JPanel();
        listSinglePanel.setLayout(new GridLayout(2,1));
        JTextField searchKey = new JTextField(25);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Search business.abstracts.Operations
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        searchPanel.add(searchKey);
        searchPanel.add(searchButton);

        // Data Component
        JLabel bookName = new JLabel("BookName");
        JLabel bookAuthor = new JLabel("BookAuthor");
        JLabel bookPageNumber = new JLabel("BookPageNumber");
        JLabel bookTopic = new JLabel("BookTopic");

        JLabel bookNameData = new JLabel("BookName");
        JLabel bookAuthorData = new JLabel("BookAuthor");
        JLabel bookPageNumberData = new JLabel("BookPageNumber");
        JLabel bookTopicData = new JLabel("BookTopic");

        JPanel dataPanel = new JPanel();
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
