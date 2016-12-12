package music1;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer1 {

	public static void main(String[] args) {
		try {
			// get and open sequencer - sintezator
			Sequencer sequencer = MidiSystem.getSequencer();
			// open sequencer
			sequencer.open();

			// create new sequence - posledovatelnost'
			Sequence seq = new Sequence(Sequence.PPQ, 4);

			// get new track from sequence
			Track track = seq.createTrack();

			// add events to the track
			//144 - start of playing note
			//128 end of that note
//			for (int i = 5; i < 61; i++) {
//				track.add(makeEvent(144, 1, i, 100, i));
//				track.add(makeEvent(128, 1, i, 100, i+2));
//			}
			for (int i = 5; i < 61; i+=4) {
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(128, 1, i, 100, i+2));
			}

			//load sequence to the sequencer
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			//start the sequencer
			sequencer.start();
			//melody
			
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	public static MidiEvent makeEvent(int cmd, int chan, int one, int two,
			int tick) {
		MidiEvent event = null;

		try {
			// create note
			// beginning of the note
			// message tells what to do
			// midievent tell when to do

			// create message and instantiate
			ShortMessage a = new ShortMessage();
			// put message into instruction
			// cmd - type of the message
			// chan - use channel number (means instrument (0 - 127))
			// one - the note (0 - 127)
			// two - speed and power of keystroke(nazatiya klavishi)
			a.setMessage(cmd, chan, one, two);
			// instantiate new event with message
			event = new MidiEvent(a, tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}

		return event;

	}
}
