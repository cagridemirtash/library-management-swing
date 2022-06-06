import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame{
    StartFrame(){
        JFrame frame = new JFrame("Library Management System");
        // Set frame size for visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Control resized for setSize method
        //frame.pack();// Make frame responsive

        //Buttons Start
        JButton create = new JButton("Create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateFrame();
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateFrame();
            }
        });
        JButton listAll = new JButton("List All Books");
        listAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListAllFrame();
            }
        });
        JButton listSingle = new JButton("List a Book");
        listSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListSingleFrame();
            }
        });
        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteFrame();
            }
        });
        //Buttons End

        // JPanel Start
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(2,0));
        listPanel.add(listAll);
        listPanel.add(listSingle);

        panel.add(create);
        panel.add(update);
        panel.add(listPanel);
        panel.add(delete);

        frame.add(panel);
        // JPanel End
        frame.setSize(420,420);
        frame.setVisible(true);// Make frame visible

        ImageIcon image = new ImageIcon("flash.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0,0,255));
    }
}
