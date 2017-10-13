package gui;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {

    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    private void go() {

        JFrame frame = new JFrame();
        button = new JButton("Click me");

        button.addActionListener(this); // В качестве аргумента объект класса, который реализует ActionListener

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);


    }

//    Метод обработки
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been ckicked!");

    }
}
