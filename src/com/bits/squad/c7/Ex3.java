package com.bits.squad.c7;

import com.bits.squad.c4.ex6.Calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ex3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame window = new JFrame("Calculator");
                    window.setSize(1000, 800);
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    ArrayList<JButton> buttons = new ArrayList<>();
                    GridBagLayout gridBagLayout = new GridBagLayout();
                    window.setLayout(gridBagLayout);
                    GridBagConstraints gbc = new GridBagConstraints();
                    JTextField textField = new JTextField();
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weighty = 0.2;
                    gbc.gridwidth = 4;
                    gbc.weightx = 1;
                    window.add(textField, gbc);
                    JButton btn1 = new JButton("1");
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.weightx = 0.25;
                    window.add(btn1, gbc);
                    buttons.add(btn1);
                    JButton btn2 = new JButton("2");
                    gbc.gridx = 1;
                    window.add(btn2, gbc);
                    buttons.add(btn2);
                    JButton btn3 = new JButton("3");
                    gbc.gridx = 2;
                    window.add(btn3, gbc);
                    buttons.add(btn3);
                    JButton btn4 = new JButton("4");
                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    window.add(btn4, gbc);
                    buttons.add(btn4);
                    JButton btn5 = new JButton("5");
                    gbc.gridx = 1;
                    window.add(btn5, gbc);
                    buttons.add(btn5);
                    JButton btn6 = new JButton("6");
                    gbc.gridx = 2;
                    window.add(btn6, gbc);
                    buttons.add(btn6);
                    JButton btn7 = new JButton("7");
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    window.add(btn7, gbc);
                    buttons.add(btn7);
                    JButton btn8 = new JButton("8");
                    gbc.gridx = 1;
                    window.add(btn8, gbc);
                    buttons.add(btn8);
                    JButton btn9 = new JButton("9");
                    gbc.gridx = 2;
                    window.add(btn9, gbc);
                    buttons.add(btn9);
                    JButton btn10 = new JButton("0");
                    gbc.gridx = 0;
                    gbc.gridy = 4;
                    window.add(btn10, gbc);
                    buttons.add(btn10);

                    JButton btnC = new JButton("C");
                    gbc.gridx = 1;
                    window.add(btnC, gbc);
                    btnC.addActionListener(e -> {textField.setText("");});
                    JButton btnSum = new JButton("=");
                    gbc.gridx = 2;
                    window.add(btnSum, gbc);
                    Calc calc = new Calc();
                    btnSum.addActionListener(e -> {textField.setText(calc.doCalcString(textField.getText()));});

                    JButton btnPlus = new JButton("+");
                    gbc.gridx = 3;
                    gbc.gridy = 1;
                    window.add(btnPlus, gbc);
                    btnPlus.addActionListener(e -> {addToTextField(textField," + ");});
                    JButton btnMinus = new JButton("-");
                    gbc.gridy = 2;
                    window.add(btnMinus, gbc);
                    btnMinus.addActionListener(e -> {addToTextField(textField," - ");});
                    JButton btnMultiply = new JButton("*");
                    gbc.gridy = 3;
                    window.add(btnMultiply, gbc);
                    btnMultiply.addActionListener(e -> {addToTextField(textField," * ");});
                    JButton btnDivide = new JButton("/");
                    gbc.gridy = 4;
                    window.add(btnDivide, gbc);
                    btnDivide.addActionListener(e -> {addToTextField(textField," / ");});


                    for (int i = 0, j = 1; i < 10; i++, j++) {
                        int finalJ = j;
                        buttons.get(i).addActionListener(e -> addToTextField(textField,finalJ));
                        if (finalJ == 10) {
                            buttons.get(i).addActionListener(e -> addToTextField(textField,0));
                        }
                    }
                    window.setVisible(true);
                }
                //ToDo Make it clear and nice in for :)
        );
    }
    public static void addToTextField(JTextField textField, String symbol) {
        textField.setText(textField.getText()+symbol);
    }
    public static void addToTextField(JTextField textField, int symbol) {
        textField.setText(textField.getText()+symbol);
    }
}
