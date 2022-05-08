package com.bits.squad.c7;

import javax.swing.*;
import java.awt.*;

public class Example {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame window = new JFrame();
                    window.setSize(1000, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JButton btn1 = new JButton("Button 1");
                    JButton btn2 = new JButton("Button 2");
                    JButton btn3 = new JButton("Button 3");

                    GridBagLayout gridBagLayout = new GridBagLayout();
                    window.setLayout(gridBagLayout);
                    GridBagConstraints gbc = new GridBagConstraints();

                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 2;
                    gbc.gridheight = 1;
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weightx = 0.1;
                    gbc.weighty = 0.1;
                    window.add(btn1, gbc);

                    gbc.gridx = 2;
                    gbc.gridy = 0;
                    gbc.gridwidth = 2;
                    gbc.gridheight = 1;
                    window.add(btn2, gbc);

                    gbc.gridx=1;
                    gbc.gridy=1;
                    gbc.gridwidth=4;
                    gbc.gridheight=1;
                    gbc.weighty = 0.2;
                    window.add(btn3,gbc);
                    btn3.addActionListener(e -> System.out.println("Hello!"));

                    window.setVisible(true);
                }
        );
    }
}
