import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Fenetre extends JFrame implements  ActionListener{
    
	private Bouton bouton1 = new Bouton ("LANCER LA MUSIQUE SELECTIONNEE");
	
	private JPanel pan = new JPanel();

	private JLabel label = new JLabel("Le JLabel");
	
	public Fenetre(){       

	    this.setTitle("KARAOKE FUN !"); //Définit un titre
	
	    this.setSize(960,960); //Définit sa taille
	    
	    this.setResizable(false);
	
	    this.setLocationRelativeTo(null); //Centrer la fenetre
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus via la croix rouge

	    this.setContentPane(new Panneau());  
	    
	    this.setLayout(new BorderLayout());
	    
	   	bouton1.addActionListener(this);
	    
	    this.getContentPane().add(bouton1, BorderLayout.SOUTH);

	    this.setVisible(true);
	 }

	public JPanel getPan() {
		return pan;
	}

	public void setPan(JPanel pan) {
		this.pan = pan;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK");
		sequencer.start();
	}
}
