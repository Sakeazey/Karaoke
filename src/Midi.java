import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
			FileInputStream fis = new FileInputStream("bin/" + nomMusique + ".txt");
			Pattern PATTERN = Pattern.compile("(\\d+):(\\d+)\\.(\\d+) - (.*) - (.*)");
			ArrayList<Lyric> paroles = new ArrayList<Lyric>();
			Timer timer = new Timer();
			
			Scanner sc = new Scanner(fis); 
			
			// ajout des paroles dans le tableau
			while(sc.hasNextLine()){  
				Matcher m = PATTERN.matcher(sc.nextLine());
				if(m.find()) {
					int gr1 = Integer.parseInt(m.group(1));
					int gr2 = Integer.parseInt(m.group(2));
					int gr3 = Integer.parseInt(m.group(3));
					int temps = ((((gr1*60)+gr2)*100+gr3)*10);
					
					paroles.add(new Lyric(temps, m.group(4), m.group(5)));
				}
				
			} 
			// affichage des paroles dans le bon temps
			paroles.forEach(parole -> {
				
				timer.schedule(new TimerTask() { 
				   @Override  
				   public void run() {
				       System.out.println(parole.singer+" - "+parole.lyric);
				   }
				}, parole.time);
			});
				sc.close(); 
			sequencer.setSequence(sequence); // load it into sequencer
			
			//sequencer.setTempoFactor(2f); // change midi speed
            
            
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
			ex.printStackTrace();
		}
	}
}