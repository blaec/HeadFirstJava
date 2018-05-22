package org.blaec.HeadFirstJava.layouts;

import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.goA();
        gui.goB();
        gui.goC();
        gui.goD();
    }

    private void goA() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
    private void goB() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
    private void goC() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
    private void goD() {
        JFrame frame = new JFrame();

        JButton buttonE = new JButton("EAST");
        JButton buttonW = new JButton("WEST");
        JButton buttonN = new JButton("NORTH");
        JButton buttonS = new JButton("SOUTH");
        JButton buttonC = new JButton("CENTER");

        frame.getContentPane().add(BorderLayout.EAST, buttonE);
        frame.getContentPane().add(BorderLayout.WEST, buttonW);
        frame.getContentPane().add(BorderLayout.NORTH, buttonN);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonS);
        frame.getContentPane().add(BorderLayout.CENTER, buttonC);

        frame.setSize(200,200);
        frame.setVisible(true);
    }

}


