package com.bits.squad.c7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame window = new JFrame("Just a chat.");
                    window.setSize(1000, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    GridBagLayout gridBagLayout = new GridBagLayout();
                    window.setLayout(gridBagLayout);
                    GridBagConstraints gbc = new GridBagConstraints();
                    JTextArea textArea = new JTextArea();
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weighty = 0.7;
                    gbc.weightx = 1;
//                    gbc.gridx = 0;
//                    gbc.gridy = 4;
                    gbc.gridheight = 4;
                    gbc.gridwidth = 2;
                    window.add(textArea, gbc);
                    JTextField textField = new JTextField("Your text here");
                    gbc.weighty = 0.3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.gridy = 5;
                    window.add(textField, gbc);
                    JButton button = new JButton("Send");
                    gbc.gridx = 1;
                    window.add(button, gbc);
                    button.addActionListener(e -> textArea.setText(textArea.getText() + "\n" + textField.getText()));

                    window.setVisible(true);
                }
        );
    }
}
