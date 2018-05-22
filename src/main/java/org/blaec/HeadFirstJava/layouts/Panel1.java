package org.blaec.HeadFirstJava.layouts;

import javax.swing.*;
import java.awt.*;

public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.goA();
        gui.goB();
        gui.goC();
    }

    private void goA() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        JButton button1 = new JButton("click me");

        panel.add(button1);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
    private void goB() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        JButton button1 = new JButton("click me");
        JButton button2 = new JButton("and me");
        JButton button3 = new JButton("me also");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    private void goC() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("click me");
        JButton button2 = new JButton("and me");
        JButton button3 = new JButton("me also");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
