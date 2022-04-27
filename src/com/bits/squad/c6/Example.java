package com.bits.squad.c6;

import javax.swing.*;
import java.awt.*;

public class Example {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () ->{
                    JFrame window = new JFrame();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setSize(1920,1080);

                    GridLayout grid = new GridLayout(2,1);
                    window.setLayout(grid);

                    JButton button = new JButton();
                    button.setText("Click");
                    window.add(button);

                    JTextField jtf = new JTextField("Wow!");
                    window.add(jtf);

                    window.setVisible(true);
                }
        ); // makes thread with Java window
    }
}
