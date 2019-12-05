import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Midi{
	
	public static Sequencer sequencer;
	
	public static void initSequencer(){
	
		try {
			sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
			if (sequencer==null) {
				System.err.println("Sequencer device not supported");
				return;
			} 
			
			sequencer.open(); // Open device
			
			Scanner entree = new Scanner(System.in);
			
			String nomMusique = entree.nextLine();
			
			Sequence sequence = MidiSystem.getSequence(new File("bin/" + nomMusique + ".mid")); // Create sequence, the File must contain MIDI file data.
            
			sequencer.setSequence(sequence); // load it into sequencer
			
			//sequencer.setTempoFactor(2f); // change midi speed
            
            
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
			ex.printStackTrace();
		}
	}
}