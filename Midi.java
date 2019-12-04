import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Midi {
    public static void main(String[] args) {

    	Fenetre fen = new Fenetre();
    	
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer==null) {
                System.err.println("Sequencer device not supported");
                return;
            } 
            sequencer.open(); // Open device

            Sequence sequence = MidiSystem.getSequence(new File("D:\\Documents\\Cours\\Java\\Karaoke\\bin\\Lovely.mid")); // Create sequence, the File must contain MIDI file data.
            
            sequencer.setSequence(sequence); // load it into sequencer
            
            //sequencer.start();  // start the playback
            
            
            //sequencer.setTempoFactor(2f); // change midi speed
            
            //sequencer.stop();
            
            //sequencer.close();
            
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
    }
}