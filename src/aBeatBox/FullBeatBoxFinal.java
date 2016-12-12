package aBeatBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTMLDocument.Iterator;

import aBeatBox.FullBeatBox.MySendListener;

public class FullBeatBoxFinal {

	JFrame frame;
	JPanel mainPanel;
	JList incomingList;
	JTextField userMessage;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	Vector<String> listVector = new Vector<>();
	String userName;
	ObjectOutputStream outputStream;
	ObjectInputStream inputStream;
	HashMap<String, boolean[]> otherSequencesMap = new HashMap<>();

	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;

	String[] instrumentNames = { "BassDrum", "Closed Hi-Hat", "Open Hi-Hat",
			"Acoustic Snare", "Crach Cymblal", "Hand Clap", "High Tom",
			"Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell",
			"Vibraslap", "Low-mid Tom", " High Agogo", " Open Hi Conga" };
	int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58,
			47, 67, 63 };

	public static void main(String[] args) {
		// fake command line args array
		args = new String[1];
		// fake command line arg
		args[0] = "Player";
		new FullBeatBoxFinal().go(args[0]);
	}

	public void go(String name) {
		userName = name;
		try {
			Socket socket = new Socket("127.0.0.1", 4242);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
			Thread remote = new Thread(new RemoteReader());
			remote.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setUpMidi();
		buildGui();
	}

	public void buildGui() {
		frame = new JFrame("Cyber beatBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		checkboxList = new ArrayList<>();

		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartButtonListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopButtonListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("UpTempo");
		upTempo.addActionListener(new MyUpTempoButtonListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("DownTempo");
		downTempo.addActionListener(new MyDownTempoButtonListener());
		buttonBox.add(downTempo);

		JButton serButton = new JButton("Serialize");
		serButton.addActionListener(new MySaveListener());
		buttonBox.add(serButton);

		JButton restoreButton = new JButton("Restore");
		restoreButton.addActionListener(new MyReadListener());
		buttonBox.add(restoreButton);

		JButton sendIt = new JButton("Send");
		sendIt.addActionListener(new MySendButtonListener());
		buttonBox.add(sendIt);

		userMessage = new JTextField();
		buttonBox.add(userMessage);

		incomingList = new JList();
		incomingList.addListSelectionListener(new MyListSelectionListener());
		incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane theList = new JScrollPane(incomingList);
		buttonBox.add(incomingList);
		incomingList.setListData(listVector);

		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		frame.getContentPane().add(background);
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		frame.setBounds(50, 50, 50, 50);
		frame.pack();
		frame.setVisible(true);
	}

	public void setUpMidi() {
		try {
			// instantiate sequencer(player, synthesizer)
			sequencer = MidiSystem.getSequencer();
			// one sequencer
			sequencer.open();
			// instantiate new sequence
			sequence = new Sequence(Sequence.PPQ, 4);
			// create new track from sequence
			track = sequence.createTrack();
			// set tempo 120 bits per minute to sequence
			sequencer.setTempoInBPM(120);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		ArrayList<Integer> trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();

		for (int i = 0; i < 16; i++) {
			trackList = new ArrayList<>();

			for (int j = 0; j < 16; j++) {
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16 * i));
				if (jc.isSelected()) {
					int key = instruments[i];
					trackList.add(new Integer(key));
				} else {
					trackList.add(null);
				}
			}
			makeTracks(trackList);
		}
		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void changeSequence(boolean[] checkboxState) {
		for (int i = 0; i < 256; i++) {
			JCheckBox check = (JCheckBox) checkboxList.get(i);
			if (checkboxState[i]) {
				check.setSelected(true);
			} else {
				check.setSelected(false);
			}
		}
	}

	public void makeTracks(ArrayList list) {
		java.util.Iterator it = list.iterator();
		for (int i = 0; i < 16; i++) {
			Integer num = (Integer) it.next();
			if (num != null) {
				int numKey = num.intValue();
				// add to the track event which starts the note
				track.add(makeEvent(144, 9, numKey, 100, i));
				// add to the track event which ends the note
				track.add(makeEvent(128, 9, numKey, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
		// create midi event
		MidiEvent event = null;
		try {
			// create note
			// message tells what to do
			// midievent tells what to do

			// create message and instantiate
			ShortMessage a = new ShortMessage();

			// put instruction into the message
			// cmd - type of the message(144 - start playing note, 128 - stop)
			// chan - channel number (means instrument (0 - 15))
			// one - the note (0 - 127)
			// two - speed and power of keystroke(nazatiya klavishi)
			a.setMessage(cmd, chan, one, two);
			// before event u can change instrument like this
			// a.setMessage(192,1,102,0) - 192 mean change instrument,
			// 1- instrument before changed, and 102 - instrument after change
			// create new event with message

			// instantiate new event with message
			event = new MidiEvent(a, tick);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// return event
		return event;
	}

	public class MyStartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			buildTrackAndStart();
		}
	}

	public class MyStopButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sequencer.stop();
		}
	}

	public class MyUpTempoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoInBPM((float) (tempoFactor * 1.03));
		}
	}

	public class MyDownTempoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = sequencer.getTempoInBPM();
			sequencer.setTempoInBPM((float) (tempoFactor * 0.97));
		}
	}

	public class MySaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// create and instantiate array of checkboxes states
			boolean[] checkboxState = new boolean[256];

			// cycle trought checkboxList to get states from list to
			// copy checkboxList state to our array
			for (int i = 0; i < 256; i++) {
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if (check.isSelected()) {
					checkboxState[i] = true;
				}
			}
			// save file window
			// all work with choosing file anf navigation
			// JFileChooser will do for you
			JFileChooser fileSave = new JFileChooser();
			// send save file window to frame
			fileSave.showSaveDialog(frame);

			try {
				// fileOutputStream connects to file given by JChooser
				FileOutputStream fos = new FileOutputStream(
						fileSave.getSelectedFile());
				// objectOutputStream can write to file
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// objectOutputStream writes serialized array to file
				oos.writeObject(checkboxState);
				// and close objectOutputStream
				oos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class MyReadListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean[] checkboxState = null;

			// open file window
			// all work with choosing file and navigation
			// JFileChooser will do for you
			JFileChooser fileOpen = new JFileChooser();
			// send open file window to frame
			fileOpen.showOpenDialog(frame);

			try {
				// FileInputStream knows how to connect to file
				FileInputStream fis = new FileInputStream(
						fileOpen.getSelectedFile());
				// ObjectInputStream knows how to read file
				ObjectInputStream ois = new ObjectInputStream(fis);
				// reads file
				checkboxState = (boolean[]) ois.readObject();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// cycle trough received array
			// and changing checkbox states according to it
			for (int i = 0; i < 256; i++) {
				JCheckBox check = checkboxList.get(i);
				if (checkboxState[i]) {
					check.setSelected(true);
				} else {
					check.setSelected(false);
				}
			}
			// stop sequencer
			sequencer.stop();
			// run sequencer with new data
			buildTrackAndStart();
		}
	}

	public class MySendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// create array to hold checkboxes states
			boolean[] checkboxState = new boolean[256];
			for (int i = 0; i < 256; i++) {
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if (check.isSelected()) {
					checkboxState[i] = true;
				}
			}
			String messageToSend = null;
			try {
				outputStream.writeObject(
						userName + nextNum++ + ": " + userMessage.getText());
				outputStream.writeObject(checkboxState);
			} catch (Exception ex) {
				System.out.println("Could not send it to the server");
				ex.printStackTrace();
			}
			userMessage.setText("");
		}

	}

	public class MyListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				String selected = (String) incomingList.getSelectedValue();
				if (selected != null) {
					boolean[] selectedState = (boolean[]) otherSequencesMap
							.get(selected);
					changeSequence(selectedState);
					sequencer.stop();
					buildTrackAndStart();
				}
			}
		}
	}

	public class RemoteReader implements Runnable {

		boolean[] checkboxState = null;
		String nameToShow = null;
		Object obj = null;

		@Override
		public void run() {
			try {
				while ((obj = inputStream.readObject()) != null) {
					System.out.println("got an object from server");
					System.out.println(obj.getClass());
					nameToShow = (String) obj;
					checkboxState = (boolean[]) inputStream.readObject();
					otherSequencesMap.put(nameToShow, checkboxState);
					listVector.add(nameToShow);
					incomingList.setListData(listVector);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public class MyPlayMineListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (mySequence != null) {
				sequence = mySequence;
			}
		}
	}
}
