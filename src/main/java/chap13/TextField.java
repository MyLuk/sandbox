package chap13;

import javax.swing.*;
import java.awt.*;

public class TextField {
    public static void main(String[] args) {
        TextField gui = new TextField();

        gui.go();
    }

    private static void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextField field = new JTextField(20);
        JTextField field1 = new JTextField("Your name");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(field);
        panel.add(field1);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}
