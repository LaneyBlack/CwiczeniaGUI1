package com.bits.squad.c6;

import javax.swing.*;
import java.awt.*;

public class C6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()->{
                    //Ex1
                    JFrame window = new JFrame();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setSize(800,600);
                    window.setTitle("Hello World");
                    /*Ex2
                    JTextArea textArea = new JTextArea("Wooooooooooow");
                    textArea.setBackground(Color.darkGray);
                    Font calibriLight = new Font("Calibri Light",Font.BOLD,74);
                    textArea.setFont(calibriLight);
                    textArea.setForeground(Color.white);
                    window.add(textArea);
                     */

                    /*Ex3
                    Component component = new Component();
                    window.add(component);
                     */
                    //Ex4
//                    BorderLayout layout = new BorderLayout(); //A
//                    FlowLayout layout = new FlowLayout(FlowLayout.LEFT); //B
//                    FlowLayout layout = new FlowLayout(FlowLayout.RIGHT); //C
//                    GridLayout layout = new GridLayout(1,5,10,10); //D
//                    GridLayout layout = new GridLayout(5,1,10,10); //E
//                    GridLayout layout = new GridLayout(2,3,10,10); //F
//                    window.setLayout(layout);
//                    window.add(new JButton("Button1"));
//                    window.add(new JButton("2 Button"));
//                    window.add(new JButton("B3"));
//                    window.add(new JButton("B 4"));
//                    window.add(new JButton("Button number 5"));

                    //Ex5
                    PJATKLogo logo = new PJATKLogo(30);
                    window.add(logo);
                    window.setVisible(true);
                    logo.repaint();
                    logo.repaint();
                    logo.repaint();
                }
        );
    }
}
