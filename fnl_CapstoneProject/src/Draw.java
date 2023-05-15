// Author: Sanah Bhandari
// Date  : May 2, 2023
// Rev   : 01
// Notes : Notes go here

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JPanel implements ActionListener, MouseListener {

	// JPanel panel;
	// JFrame score;
	// JFrame points;
	// JFrame resources;
	JButton buyHouse, buyStore, buyFactory, buySolarPanel;
	// JTextField display = new JTextField("hi");
	private Image buildings = new ImageIcon("buildings.gif").getImage();
	private Image house = new ImageIcon("House.gif").getImage();
	private Image store = new ImageIcon("Store.gif").getImage();
	private Image factory = new ImageIcon("Factory.gif").getImage();
	private Image solarPanel = new ImageIcon("SolarPanel.gif").getImage();
	ResourceManagement resourceManager = new ResourceManagement();
	
	private int mouseX;
	private int mouseY;

	//Instantiates and draws the main JPanel, JComponent, instantiates all the JFrames, etc.
	public Draw() {
		// Below is what usually goes in the main method. It was moved to draw to make the MouseListener class easier to use.
		JFrame mainScreen = new JFrame ("Main Screen");
		mainScreen.setBounds(300, 100, 800, 600);   //establish initial size in pixels
		mainScreen.getContentPane().setBackground(Color.WHITE); // set background color


		mainScreen.setResizable(false); // the window can be resized
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this happens with window is closed
		mainScreen.setVisible(true);

		// create components (widgets) to add to the window.  this can be panels, buttons, images, etc.
		// in this case a new panel     
		setBackground(Color.WHITE);// set the background color of the panel to white

		// add the panel to the frame
		Container windowContainer = mainScreen.getContentPane();// get the window's container
		windowContainer.add(this); // add the panel to the window

		// make the window visible
		mainScreen.setVisible(true);
		//Above is the end of the usual main method code. Everything below is graphics, and not drawing the overall basic screen (Frame, Panel, Container etc)
		
		windowContainer.addMouseListener(this);
		
	}
	
	//Draws the rest of the graphics. 
	public void paint(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);

		// top 2 boxes
		g.drawRect(400, 50, 150, 30);
		g.drawString(resourceManager.getResources() + " resources", 460, 70);
		g.drawRect(550, 50, 150, 30);
		g.drawString(resourceManager.getPoints() + " points", 610, 70);

		// build houses box
		g.drawRect(50, 100, 200, 400);
		g.drawString("Build House:", 70, 120);
		g.drawString("Cost: 25 resources", 70, 140);
		g.drawString("Credit: 2 points", 70, 160);
		
		//g.drawImage(house, 200, 100, 50, 50, this);

		// build stores box
		g.drawRect(50, 100, 200, 300);
		g.drawString("Build Store:", 70, 220);
		g.drawString("Cost: 50 resources", 70, 240);
		g.drawString("Credit: 10 points", 70, 260);

		// build factories box
		g.drawRect(50, 100, 200, 200);
		g.drawString("Build Factory:", 70, 320);
		g.drawString("Resources", 70, 340);

		// build solar panels box
		g.drawRect(50, 100, 200, 100);
		g.drawString("Build Solar Panel:", 70, 420);
		g.drawString("Resources", 70, 440);

		// print environmental score
		g.drawString("Environmental Score:", 400, 500);
		
		// an environmental score below or equal to 20 means it turns red
		if (resourceManager.getEnvironmentScore() <= 20) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.GREEN);
		}
		g.drawString(resourceManager.getEnvironmentScore() + "%", 515, 500);

		// draws buildings image in screen's center
		g.drawImage(buildings, 300, 100, 400, 350, this);

		//Draws all the images of the buildings, or "buttons"
		g.setColor(Color.GREEN);
		g.fillRect(190, 140, 60, 60);
		g.drawImage(house, 195, 145, 50, 50, this);
		g.fillRect(190, 240, 60, 60);
		g.drawImage(store, 195, 245, 50, 50, this);
		g.fillRect(190, 340, 60, 60);
		g.drawImage(factory, 195, 345, 50, 50, this);
		g.fillRect(190, 440, 60, 60);
		g.drawImage(solarPanel, 195, 445, 50, 50, this);
	}

	//Checks whenever a button, or something else, is clicked.
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		
		if (b == buyHouse)
		{
			resourceManager.buyHouse();
			repaint();
		}
		if (b == buyStore)
		{
			resourceManager.buyStore();
			repaint();
		}
	}

	//Checks where and when a mouse is clicked on the JComponent. Used as a button.
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		//Checks if house is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 145 && mouseY <= 195)
		{
			resourceManager.buyHouse();
			repaint();
		}
		//Checks if store is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 245 && mouseY <= 295)
		{
			resourceManager.buyStore();
			repaint();
		}
		//Checks if factory is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 345 && mouseY <= 395)
		{
//			resourceManager.buyFactory();
//			repaint();
		}
		//Checks if solar panel is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 445 && mouseY <= 495)
		{
//			resourceManager.buySolarPanel();
//			repaint();
		}
	}

	
	//All these methods are useless, they are not used in the program.
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}



}
