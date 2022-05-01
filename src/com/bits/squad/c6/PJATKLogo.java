package com.bits.squad.c6;

import java.awt.*;

public class PJATKLogo extends Component{
    private int angle;
    private int currentAngle = 0;

    public PJATKLogo(int angle) {
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int radius = 100;
//        g.setColor(Color.RED);
//        g.drawOval(radius,radius, radius*2,radius*2);
//        g.fillArc(radius,radius,radius*2,radius*2,0,-180);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval(radius,radius, radius*2,radius*2);
        g2.fillArc(radius,radius,radius*2,radius*2,0,-180);
    }

    @Override
    public void repaint() {
        int radius = 100;
        Graphics2D g2 = (Graphics2D)getGraphics();
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval(radius,radius, radius*2,radius*2);
        g2.fillArc(radius,radius,radius*2,radius*2,currentAngle,-180 + currentAngle);
        currentAngle+=angle;
    }
}
