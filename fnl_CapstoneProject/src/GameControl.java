import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameControl extends JPanel{

	//Fields
	//Declares a resourceManagement and an image of each type of building. 
	ResourceManagement resourceManager = new ResourceManagement();
	private Image house = new ImageIcon("House.gif").getImage();
	private Image store = new ImageIcon("Store.gif").getImage();
	private Image factory = new ImageIcon("Factory.gif").getImage();
	private Image solarPanel = new ImageIcon("SolarPanel.gif").getImage();
	private Image buildings = new ImageIcon("buildings.gif").getImage();
	
	//Constructor (No-args)
	public GameControl()
	{

	}
	
	//Methods
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		System.out.println("called");
		// draws buildings image in screen's center
		g.drawImage(buildings, 300, 100, 400, 350, this);
		repaint();
	}
	
	
}
