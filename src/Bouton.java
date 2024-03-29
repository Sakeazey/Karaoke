import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JButton;
  
@SuppressWarnings("serial")
public class Bouton extends JButton {
  private String name;
  public Bouton(String str){
    super(str);
    this.name = str;
  }
 
  // Personnalisation d'un bouton
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp = new GradientPaint(0, 0, Color.white, 0, 20, Color.cyan, true);
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    g2d.setColor(Color.black);
    g2d.drawString(this.name, this.getWidth()/2-(this.getWidth()/8), (this.getHeight()/2)+5);
  }        
}