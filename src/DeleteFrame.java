import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFrame extends Frame {
    private String bookName = "", bookAuthor = "", bookTopic = " ", bookPageNumber = "";

    DeleteFrame(){
        JPanel updatePanel = new JPanel();
        Border updateSearch = BorderFactory.createTitledBorder("Enter a id for delete");
        updatePanel.setBorder(updateSearch);
        updatePanel.setLayout(new GridLayout(6, 2));

        JTextField searchKey = new JTextField(25);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Search business.abstracts.Operations
            }
        });
        updatePanel.add(searchKey);
        updatePanel.add(searchButton);

        JLabel name = new JLabel("Book Name : ");
        JLabel bookNameField = new JLabel(bookName);
        JLabel author = new JLabel("Author Name : ");
        JLabel authorNameField = new JLabel(bookAuthor);
        JLabel pageNumber = new JLabel("Page Number : ");
        JLabel pageNumberField = new JLabel(bookPageNumber);
        JLabel topic = new JLabel("Topic : ");
        JLabel topicField = new JLabel(bookTopic);

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
                // TODO: Delete business.abstracts.Operations
            }
        });
        updatePanel.add(deleteButtonLabel);
        updatePanel.add(deleteButton);

        super.add(updatePanel);
    }
}
