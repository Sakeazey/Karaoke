import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import javax.swing.JPanel;

// Création du fond de la fenêtre
@SuppressWarnings("serial")
public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
	  
	    Graphics2D g2d = (Graphics2D)g;
	    GradientPaint gp, gp2, gp3, gp4, gp5, gp6; 
	    gp = new GradientPaint(0, 0, Color.RED, 160, 0, Color.magenta, false);
	    gp2 = new GradientPaint(160, 0, Color.magenta, 320, 0, Color.blue, false);
	    gp3 = new GradientPaint(320, 0, Color.blue, 480, 0, Color.green, false);
	    gp4 = new GradientPaint(480, 0, Color.green, 640, 0, Color.yellow, false);
	    gp5 = new GradientPaint(640, 0, Color.yellow, 800, 0, Color.orange, false);
	    gp6 = new GradientPaint(800, 0, Color.orange, 960, 0, Color.red, false);

	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, 160, this.getHeight());               
	    g2d.setPaint(gp2);
	    g2d.fillRect(160, 0, 320, this.getHeight());
	    g2d.setPaint(gp3);
	    g2d.fillRect(320, 0, 480, this.getHeight());
	    g2d.setPaint(gp4);
	    g2d.fillRect(480, 0, 640, this.getHeight());
	    g2d.setPaint(gp5);
	    g2d.fillRect(640, 0, 800, this.getHeight());
	    g2d.setPaint(gp6);
	    g2d.fillRect(800, 0, 960, this.getHeight());
	  
	    Font font = new Font("Arial", Font.BOLD, 60);
	    g.setFont(font);
	    g.setColor(Color.white);          
	    g.drawString("BIENVENUE A KARAOKE FUN !", 20, 50);   
	    }               
}  


