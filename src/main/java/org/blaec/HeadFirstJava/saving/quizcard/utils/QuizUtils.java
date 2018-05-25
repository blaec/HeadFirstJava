package org.blaec.HeadFirstJava.saving.quizcard.utils;

import javax.swing.*;

public class QuizUtils {

    public static JScrollPane addScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    public static String getDilimiter() {
        return "/";
    }
}
