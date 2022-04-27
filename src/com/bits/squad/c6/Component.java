package com.bits.squad.c6;

import javax.swing.*;
import java.awt.*;

public class Component extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        for (int i = 10; i < 800; i+=10) {
            g.drawLine(i,0,i,600);
            g.drawLine(0,i,800,i);
        }
    }
}
