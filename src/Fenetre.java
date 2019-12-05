
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class Fenetre extends JFrame{
	
	
	public Fenetre(){       

		Bouton bouton1 = new Bouton ("LANCER LA MUSIQUE SELECTIONNEE");
		JPanel panb1 = new JPanel();
		panb1.setLayout(new BorderLayout());
		Bouton bouton2 = new Bouton ("ARRETER LA MUSIQUE");
		JPanel panb2 = new JPanel();
		panb2.setLayout(new BorderLayout());

		
		JPanel pan = new JPanel();
		
		JPanel lay = new JPanel();
		lay.setLayout(new BoxLayout(lay, BoxLayout.Y_AXIS));

		JLabel label = new JLabel("Le JLabel");
		
		
	    this.setTitle("KARAOKE FUN !"); //Définit un titre
	
	    this.setSize(960,960); //Définit sa taille
	    
	    this.setResizable(false);
	
	    this.setLocationRelativeTo(null); //Centrer la fenetre
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus via la croix rouge

	    this.setContentPane(new Panneau());  
	    
	    this.setLayout(new BorderLayout());
	    
	   	bouton1.addActionListener(actionEvent -> {
			Midi.initSequencer();
		    Midi.sequencer.start();  // start the playback
		    System.out.println("La musique s'est lancée !");
	   	});
	    
	   	bouton2.addActionListener(actionEvent -> {
		    Midi.sequencer.stop();  // stop the playback
		    System.out.println("La musique s'est arrêtée !");
	   	});
	   	
	   	panb1.add(bouton1);
	   	panb2.add(bouton2);
	    lay.add(panb1);
	    lay.add(panb2);

	    
	    this.add(lay, BorderLayout.SOUTH);

	    this.setVisible(true);
	 }

}
