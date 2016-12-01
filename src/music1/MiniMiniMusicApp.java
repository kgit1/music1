package music1;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusicApp {
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play(){
		try{
		//get and open sequencer - sintezator	
		Sequencer player = MidiSystem.getSequencer();
		player.open();
		
		//create new sequence - posledovatelnost'
		Sequence seq = new Sequence(Sequence.PPQ, 4);
		
		//get new track from sequence
		Track track = seq.createTrack();
		
		//create note
		//beginning of the note
		//message tells what to do
		//midievent tell when to do
		
		//create message
		ShortMessage a = new ShortMessage();
		//put message into instruction 
		//144 -(start playing the note)type of the message
		//1 - use channel number 1 (means instrument (0 - 127))
		//44 - the note (0 - 127)
		//speed and power of keystroke(nazatiya klavishi)
		a.setMessage(144,1,44,100);
		//before event u can change instrument like this
		//a.setMessage(192,1,102,0) - 192 mean change instrument, 
		//1- instrument before changed, and 102 - instrument after change
		//create new event with message
		MidiEvent noteOne = new MidiEvent(a, 1);
		//add event to the track
		track.add(noteOne);
		
		//end of the note
		ShortMessage b = new ShortMessage();
		//128 in message means end of the note
		b.setMessage(128,1,44,100);
		MidiEvent noteOff = new MidiEvent(b,16);
		track.add(noteOff);
		
		//send sequence to sequencer
		player.setSequence(seq);
		
		//start sequencer
		player.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
