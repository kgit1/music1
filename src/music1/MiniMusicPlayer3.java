package music1;

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
	static JFrame f = new JFrame("My first music video");
	static MyDrawPanel panel;

	public static void main(String[] args) {
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}

	public void setUpGui() {
		panel = new MyDrawPanel();
		f.setContentPane(panel);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}

	public void go() {
		setUpGui();

		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(panel, new int[] { 127 });
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int r = 0;
			for (int i = 0; i < 90; i++) {
				r = (int) ((Math.random() * 50) + 1);
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i+4));
			}

			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(cmd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	// create nested class to draw panel with builded in listener of events
	public class MyDrawPanel extends JPanel implements ControllerEventListener {

		// boolean to register events - will be changed to true
		boolean msg = false;

		@Override
		public void controlChange(ShortMessage event) {
			// register event
			msg = true;
			// repaint panel on event registered
			repaint();
		}

		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D g2 = (Graphics2D) g;

				int red = (int) (Math.random() * 250);
				int green = (int) (Math.random() * 250);
				int blue = (int) (Math.random() * 250);

				g.setColor(new Color(red, green, blue));

				int height = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);
				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);
				g.fillRect(x, y, width, height);
				msg = false;
			}
		}

	}
}
