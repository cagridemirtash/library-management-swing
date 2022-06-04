package com.industry;

import javax.swing.*;

public class App extends JFrame {
    private JPanel panel;
    private JButton Button;

    public App(String title){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
    }
    public static void main(String args[]){
        JFrame frame = new App("My App");
        frame.setSize(500,600);
        frame.setVisible(true);
    }

}
