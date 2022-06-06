import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateFrame extends Frame {

    // TODO: Değişkenler File dosyasından çekilecek.

    private String bookName = "", bookAuthor = "", bookTopic = " ", bookPageNumber = "";

    UpdateFrame() {
        JPanel updatePanel = new JPanel();
        Border updateSearch = BorderFactory.createTitledBorder("Enter a key for Search");
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
        JTextField bookNameField = new JTextField(bookName, 25);
        JLabel author = new JLabel("Author Name : ");
        JTextField authorNameField = new JTextField(bookAuthor, 25);
        JLabel pageNumber = new JLabel("Page Number : ");
        JTextField pageNumberField = new JTextField(bookPageNumber, 4);
        JLabel topic = new JLabel("Topic : ");
        JTextField topicField = new JTextField(bookTopic, 25);

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
                // TODO: Save business.abstracts.Operations
            }
        });
        updatePanel.add(updateButtonLabel);
        updatePanel.add(updateButton);

        super.add(updatePanel);
    }
}
