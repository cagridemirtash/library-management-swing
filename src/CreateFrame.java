import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFrame extends Frame {
    public JTextField bookName, bookAuthor, bookPageNumber, bookTopic;

    CreateFrame(){
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
                // TODO: Save Operations 
            }
        });
        createPanel.add(saveButtonLabel);
        createPanel.add(saveButton);
        super.add(createPanel);



    }
}
