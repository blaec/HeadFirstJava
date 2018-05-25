package utils;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SwingUtils {

    public static JScrollPane addScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    public static void addButton(String name, Box box, ActionListener listener) {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        box.add(button);
    }

    public static void addButton(String name, JPanel panel, ActionListener listener) {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        panel.add(button);
    }

    public static String getDelimiter() {
        return "/";
    }
}
