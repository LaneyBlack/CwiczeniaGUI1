package com.bits.squad.c7;

import javax.swing.*;
import java.awt.*;

public class Ex1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()->{
                    JFrame window = new JFrame("GridBagLayout demo");
                    window.setSize(1000, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JButton btn1 = new JButton("Button 1");
                    JButton btn2 = new JButton("Button 2");
                    JButton btn3 = new JButton("Button 3");
                    JButton btn4 = new JButton("Button 4");
                    JButton btn5 = new JButton("Button 5");
                    JButton btn6 = new JButton("Button 6");
                    JButton btn7 = new JButton("Button 7");

                    GridBagLayout gridBagLayout = new GridBagLayout();
                    window.setLayout(gridBagLayout);

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.BOTH;
                    window.add(btn1,gbc);
                    gbc.gridx = 1;
                    window.add(btn2,gbc);
                    gbc.gridx = 2;
                    window.add(btn3,gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    gbc.gridwidth = 3;
                    window.add(btn4,gbc);
                    gbc.gridy = 3;
                    gbc.gridheight = 2;
                    gbc.gridwidth=1;
                    window.add(btn7,gbc);
                    gbc.gridheight=1;
                    gbc.gridwidth=2;
                    gbc.gridx = 1;
                    window.add(btn5,gbc);
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    window.add(btn6,gbc);

                    window.setVisible(true);
                }
        );
    }
}
