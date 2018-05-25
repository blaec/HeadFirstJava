package org.blaec.HeadFirstJava.players;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

import static utils.MidiUtil.makeEvent;

public class MiniMusicPlayer3 {
    static JFrame f = new JFrame("My First Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    private void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
        }
    }

    private void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    }

    public class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(getRandomColor());

                int ht = getRndVal(120, 10);
                int width = getRndVal(120, 10);

                int x = getRndVal(40, 10);
                int y = getRndVal(40, 10);

                g2.fillRect(x, y, ht, width);
                msg = false;
            }

        }

        private int getRndVal(int size, int shift) {
            return (int) ((Math.random() * size) + shift);
        }

        private Color getRandomColor() {
            int red = getRndVal(255, 0);
            int green = getRndVal(255, 0);
            int blue = getRndVal(255, 0);

            return new Color(red, green, blue);
        }
    }
}
