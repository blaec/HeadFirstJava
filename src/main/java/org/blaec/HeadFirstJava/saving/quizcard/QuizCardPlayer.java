package org.blaec.HeadFirstJava.saving.quizcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.blaec.HeadFirstJava.saving.quizcard.utils.QuizUtils.addScrollPane;
import static org.blaec.HeadFirstJava.saving.quizcard.utils.QuizUtils.getDilimiter;

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private List<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go() {
        // boild gui

        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);

        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = addScrollPane(display);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCartListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    private void loadFile(File file) {

        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // now time to start by showing the first card
        showNextCard();
    }

    private void makeCard(String lineToParse) {
        String[] result = lineToParse.split(getDilimiter());
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }

    private class NextCartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (isShowAnswer) {
                // show the answer because they've seen the question
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next card");
                isShowAnswer = false;
            } else {
                // show the next question
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    // there are not more cards!
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    private class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
}
