
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	
	public Fenetre(){       

		// Cr�ation des boutons
		Bouton bouton1 = new Bouton ("LANCER LA MUSIQUE SELECTIONNEE");
		JPanel panb1 = new JPanel();
		panb1.setLayout(new BorderLayout());
		Bouton bouton2 = new Bouton ("              ARRETER LA MUSIQUE");
		JPanel panb2 = new JPanel();
		panb2.setLayout(new BorderLayout());
		
		// Cr�ation de la liste des musiques disponibles
		JPanel songList = new JPanel();
		songList.setLayout(new BorderLayout());
		songList.setOpaque(false);
		JLabel songNames = new JLabel("<html><body>La liste des musiques disponibles est :<br />- Viva_La_Vida<br />- Creep<br />- Lovely</body></html>");
		songNames.setForeground(Color.red);
		songNames.setHorizontalAlignment(JLabel.CENTER);
		songNames.setVerticalAlignment(JLabel.CENTER);
		Font songFont = new Font("Arial", Font.ITALIC + Font.BOLD, 26);
		songNames.setFont(songFont);
		
		JPanel lay = new JPanel();
		lay.setLayout(new BoxLayout(lay, BoxLayout.Y_AXIS));		
		
	    this.setTitle("KARAOKE FUN !"); // D�finit un titre
	    this.setSize(960,960); // D�finit la taille de la fen�tre
	    this.setResizable(false); // Emp�che de modifier la taille
	    this.setLocationRelativeTo(null); // Pour centrer la fenetre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termine le processus via la croix rouge
	    this.setContentPane(new Panneau());  
	    this.setLayout(new BorderLayout());
	    
	    // Action li�e au bouton 1
	   	bouton1.addActionListener(actionEvent -> {
			Midi.initSequencer();
		    Midi.sequencer.start();  // start the playback
		    Midi.musique = true;
		    System.out.println("La musique s'est lanc�e !");
	   	});
	   	
	    // Action li�e au bouton 2
	   	bouton2.addActionListener(actionEvent -> {
		    Midi.sequencer.stop();  // stop the playback
		    Midi.musique = false;
		    System.out.println("La musique s'est arr�t�e !");
	   	});
	   	
	   	// Ajout des panneaux et des boutons
	   	panb1.add(bouton1);
	   	panb2.add(bouton2);
	    lay.add(panb1);
	    lay.add(panb2);
	    songList.add(songNames);
	    
	    // Ajout � la fen�tre
	    this.add(songList, BorderLayout.CENTER);
	    this.add(lay, BorderLayout.SOUTH);

	    // Affichage
	    this.setVisible(true);
	 }

}
