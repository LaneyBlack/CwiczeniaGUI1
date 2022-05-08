package com.bits.squad.c7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame window = new JFrame("Just a chat.");
                    window.setSize(1000, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    GridBagLayout gridBagLayout = new GridBagLayout();
                    window.setLayout(gridBagLayout);
                    GridBagConstraints gbc = new GridBagConstraints();
                    JTextField textField = new JTextField();
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weighty = 0.2;
                    gbc.gridwidth=4;
                    gbc.weightx = 1;
                    window.add(textField,gbc);
                    JButton btn1 = new JButton("1");
                    gbc.gridy=1;
                    gbc.gridwidth=1;
                    gbc.weightx = 0.25;
                    window.add(btn1, gbc);
                    JButton btn2 = new JButton("2");
                    gbc.gridx = 1;
                    window.add(btn2, gbc);
                    JButton btn3 = new JButton("3");
                    gbc.gridx = 2;
                    window.add(btn3, gbc);
                    JButton btn4 = new JButton("4");
                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    window.add(btn4, gbc);
                    JButton btn5 = new JButton("5");
                    gbc.gridx = 1;
                    window.add(btn5, gbc);
                    JButton btn6 = new JButton("6");
                    gbc.gridx = 2;
                    window.add(btn6, gbc);
                    JButton btn7 = new JButton("7");
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    window.add(btn7, gbc);
                    JButton btn8 = new JButton("8");
                    gbc.gridx = 1;
                    window.add(btn8, gbc);
                    JButton btn9 = new JButton("9");
                    gbc.gridx = 2;
                    window.add(btn9, gbc);
                    JButton btn10 = new JButton("0");
                    gbc.gridx = 0;
                    gbc.gridy = 4;
                    window.add(btn10, gbc);

                    JButton btnC = new JButton("C");
                    gbc.gridx = 1;
                    window.add(btnC, gbc);
                    JButton btnSum = new JButton("=");
                    gbc.gridx = 2;
                    window.add(btnSum, gbc);

                    JButton btnPlus = new JButton("+");
                    gbc.gridx = 3;
                    gbc.gridy = 1;
                    window.add(btnPlus, gbc);
                    JButton btnMinus = new JButton("-");
                    gbc.gridy = 2;
                    window.add(btnMinus, gbc);
                    JButton btnMultiply = new JButton("*");
                    gbc.gridy = 3;
                    window.add(btnMultiply, gbc);
                    JButton btnDivide = new JButton("/");
                    gbc.gridy = 4;
                    window.add(btnDivide, gbc);


                    btn1.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn2.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn3.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn4.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn5.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn6.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn7.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn8.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn9.addActionListener(e -> textField.setText(textField.getText()+"2"));
                    btn10.addActionListener(e -> textField.setText(textField.getText()+"2"));


                    //ToDo Make it in for
                    window.setVisible(true);
                }
        );
    }
}
