package com.bits.squad.c6;

import java.awt.*;

public class PJATKLogo extends Component{
    @Override
    protected void paintComponent(Graphics g) {
        int radius = 100;
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval(radius,radius, radius*2,radius*2);
        g2.fillArc(radius,radius,radius*2,radius*2,0,-180);
    }
}
