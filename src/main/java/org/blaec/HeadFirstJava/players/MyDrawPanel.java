package org.blaec.HeadFirstJava.players;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new GradientPaint(70, 70, getRandomColor(), 150, 150, getRandomColor()));
        g.fillOval(70, 70, 100, 100);
    }

    private int getRandomHue() {
        return (int) (Math.random() * 255);
    }

    private Color getRandomColor() {
        int red = getRandomHue();
        int green = getRandomHue();
        int blue = getRandomHue();

        return new Color(red, green, blue);
    }
}
