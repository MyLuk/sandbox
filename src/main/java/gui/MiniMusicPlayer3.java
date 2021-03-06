//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicPlayer3 {
    static JFrame f = new JFrame("My First Music Video");
    static MiniMusicPlayer3.MyDrawPanel ml;

    public MiniMusicPlayer3() {
    }

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        ml = new MiniMusicPlayer3.MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    }

    public void go() {
        this.setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence seq = new Sequence(0.0F, 4);
            Track track = seq.createTrack();
            int r = 0;

            for(int i = 0; i < 60; i += 4) {
                r = (int)(Math.random() * 50.0D + 1.0D);
                track.add(this.makeEvent(144, 1, r, 100, i));
                track.add(this.makeEvent(176, 1, 127, 0, i));
                track.add(this.makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120.0F);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, (long)tick);
        } catch (Exception var8) {
            ;
        }

        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        MyDrawPanel() {
        }

        public void controlChange(ShortMessage event) {
            this.msg = true;
            this.repaint();
        }

        public void paintComponent(Graphics g) {
            if (this.msg) {
                Graphics2D g2 = (Graphics2D)g;
                int r = (int)(Math.random() * 250.0D);
                int gr = (int)(Math.random() * 250.0D);
                int b = (int)(Math.random() * 250.0D);
                g.setColor(new Color(r, gr, b));
                int ht = (int)(Math.random() * 120.0D + 10.0D);
                int width = (int)(Math.random() * 120.0D + 10.0D);
                int x = (int)(Math.random() * 40.0D + 10.0D);
                int y = (int)(Math.random() * 40.0D + 10.0D);
                g.fillRect(x, y, ht, width);
                this.msg = false;
            }

        }
    }
}

