package org.blaec.HeadFirstJava.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static utils.SwingUtils.addButton;
import static utils.SwingUtils.addScrollPane;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    public void go() {
        // make gui and register a listener with the send button
        // call the setUpNetworking() method
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = addScrollPane(incoming);

        outgoing = new JTextField(20);

        addButton("Send", mainPanel, new SendButtonListener());
//        JButton sendButton = new JButton("Send");
//        sendButton.addActionListener(new SendButtonListener());
//        mainPanel.add(sendButton);
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        // make a Socket, then make a PrintWriter
        // assign the PrintWriter to wth writer instance variable
        try {
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // get the text from the text field and
            // send it to the server using the writer (a PrintWriter)
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    private class IncomingReader implements Runnable {
        public void run() {
            String message;

            try {

                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
