package chap13.chap13;

import chap13.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jtext_Jtextarea implements ActionListener {

    JTextField field;
    JTextArea area;

    public static void main(String[] args) {
        Jtext_Jtextarea gui = new Jtext_Jtextarea();

        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        field = new JTextField(20);
        JButton button = new JButton("Click to send text to JArea");
        button.addActionListener(this);
        area = new JTextArea(10,10);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(field);
        panel.add(button);
        panel.add(area);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        area.append(field.getText()+"\n");
    }
}
