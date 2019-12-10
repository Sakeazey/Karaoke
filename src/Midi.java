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
	public static boolean musique;
	
	public static void initSequencer(){
	
		try {
			sequencer = MidiSystem.getSequencer(); // S�quencer par d�faut
			if (sequencer==null) {
				System.err.println("Sequencer device not supported");
				return;
			} 
			sequencer.open(); // Open device
			@SuppressWarnings("resource")
			Scanner entree = new Scanner(System.in); // Entr�e clavier
			String nomMusique = entree.nextLine(); // Choix de la musique apr�s l'entr�e clavier
			Sequence sequence = MidiSystem.getSequence(new File("bin/" + nomMusique + ".mid")); // Cr�� une s�quence avec un fichier MIDI
			FileInputStream fis = new FileInputStream("bin/" + nomMusique + ".txt"); // S�lectionne le fichier contenant les paroles
			Pattern PATTERN = Pattern.compile("(\\d+):(\\d+)\\.(\\d+) - (.*) - (.*)"); // Choix du pattern du fichier des paroles
			Timer timer = new Timer(); // Cr�ation du timer
			ArrayList<Lyric> paroles = new ArrayList<Lyric>(); // Cr�ation du tableau du fichier des paroles
			Scanner sc = new Scanner(fis); // Lis le fichier des paroles
			
			// Ajout des paroles dans le tableau
			while(sc.hasNextLine()){  
				Matcher m = PATTERN.matcher(sc.nextLine()); // V�rification du pattern
				if(m.find()) {
					int gr1 = Integer.parseInt(m.group(1)); // Converti les minutes
					int gr2 = Integer.parseInt(m.group(2)); // Converti les secondes
					int gr3 = Integer.parseInt(m.group(3)); // Converti les millisecondes
					int temps = ((((gr1*60)+gr2)*100+gr3)*10); // Calcul du d�lai sous le format Timer et TimerTask
					paroles.add(new Lyric(temps, m.group(4), m.group(5))); // Ajout du d�lai, des chanteurs et des paroles au tableau
				}
			} 
			
			// affichage des paroles dans le bon temps
			paroles.forEach(parole -> {
					timer.schedule(new TimerTask() { 
						@Override  
						public void run() {
							if(musique) {
								System.out.println(parole.singer+" - "+parole.lyric); // Affichage des paroles
							}else{
								timer.cancel(); // Annule le timer
								timer.purge(); // Vide le planificateur
								}
						}
					}, parole.time); // Lie le d�lai � chaque t�che
			});		
			sc.close(); // Ferme le scanner
			sequencer.setSequence(sequence); // Charge la s�quence dans le s�quencer			
			// sequencer.setTempoFactor(2f); // Change la vitesse de lecture du MIDI (f le multiplicateur)
            
            
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
			ex.printStackTrace();
		}
	}
}