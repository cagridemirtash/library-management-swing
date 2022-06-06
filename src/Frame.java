import javax.swing.*;
import java.awt.*;

abstract class Frame extends JFrame {
    Frame() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false); // Control resized for setSize method

        this.setSize(420, 420);
        this.setVisible(true);// Make frame visible

        ImageIcon image = new ImageIcon("flash.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(100, 100, 0));
    }

}
