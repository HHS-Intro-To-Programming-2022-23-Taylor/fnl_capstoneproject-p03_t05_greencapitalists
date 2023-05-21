import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameControl extends JPanel{

	//Fields
	//Declares a resourceManagement and an image of each type of building. 
	ResourceManagement resourceManager = new ResourceManagement();

	
	//Constructor (No-args)
	public GameControl()
	{

	}
	
	//Methods
	public void paint(Graphics g)
	{
		super.paintComponent(g);
 	}
	
	public void repaintScreen()
	{
		repaint();
	}
	
	
}
