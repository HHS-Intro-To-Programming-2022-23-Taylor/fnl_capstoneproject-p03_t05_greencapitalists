// Author: Sanah Bhandari
// Date  : May 2, 2023
// Rev   : 01
// Notes : Notes go here

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JPanel implements MouseListener {

	// JPanel panel;
	// JFrame score;
	// JFrame points;
	// JFrame resources;
	// JTextField display = new JTextField("hi");
	private Image house = new ImageIcon("House.gif").getImage();
	private Image store = new ImageIcon("Store.gif").getImage();
	private Image factory = new ImageIcon("Factory.gif").getImage();
	private Image solarPanel = new ImageIcon("SolarPanel.gif").getImage();
	private Image buildings = new ImageIcon("buildings.gif").getImage();

	ResourceManagement resourceManager = new ResourceManagement();
	private long startTime = System.currentTimeMillis();
	long timeTillNextResource = 1000;
	
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
		g.drawString("Credit: 5 points", 70, 160);
		g.drawString("Environment: -1%", 70, 180);
		
		//Draw image in the center of the screen
		g.drawImage(buildings, 550, 100, 200, 175, this);

		// build stores box
		g.drawRect(50, 100, 200, 300);
		g.drawString("Build Store:", 70, 220);
		g.drawString("Cost: 100 resources", 70, 240);
		g.drawString("Credit: 25 points", 70, 260);
		g.drawString("Environment: -1%", 70, 280);

		// build factories box
		g.drawRect(50, 100, 200, 200);
		g.drawString("Build Factory:", 70, 320);
		g.drawString("Cost: 80 resources", 70, 340);
		g.drawString("Rate: 5 resource/sec", 70, 360);
		g.drawString("Environment: -10%", 70, 380);
		

		// build solar panels box
		g.drawRect(50, 100, 200, 100);
		g.drawString("Build Solar Panel:", 70, 420);
		g.drawString("Cost: 150 resources", 70, 440);
		g.drawString("Rate: 2 resource/sec", 70, 460);
		g.drawString("Environment: -0%", 70, 480);

		// print environmental score
		g.drawString("Environmental Score:", 400, 525);
		
		// an environmental score below or equal to 20 means it turns red
		if (resourceManager.getEnvironmentScore() <= 20) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.GREEN);
		}
		g.drawString(resourceManager.getEnvironmentScore() + "%", 515, 525);


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
		
		//Draws all the building counts
		g.setColor(Color.BLACK);
		g.drawString("Houses: ", 255, 360);
		g.drawRect(255, 375, 200, 0);
		g.drawString("Stores: ", 255, 390);
		g.drawRect(255, 406, 200, 0);
		g.drawString("Factories: ", 255, 420);
		g.drawRect(255, 437, 200, 0);
		g.drawString("Solar Panels: ", 255, 450);
		g.drawRect(255, 468, 200, 0);
		//Draws the building "bar graphs"
		for(int i = 0; i < resourceManager.getHouseCount(); i++)	//Houses
		{
			g.drawImage(house, 330 + i*30, 345, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getStoreCount(); i++)	//Stores
		{
			g.drawImage(store, 330 + i*30, 376, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getFactoryCount(); i++)	//Factories
		{
			g.drawImage(factory, 330 + i*30, 407, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getSolarCount(); i++)	//Panels
		{
			g.drawImage(solarPanel, 330 + i*30, 438, 30, 30, this);
		}
		
		//Timer - Checks for elapsed time
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - startTime;
		if(elapsedTime >= timeTillNextResource)
		{
			timeTillNextResource += 1000;
			resourceManager.giveResource();
		}
		
		//Repaints the panel
		repaint();

	}


	//Checks where and when a mouse is clicked on the JComponent. Used as a button.
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		//Checks if house is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 145 && mouseY <= 195)
		{
			resourceManager.buyHouse();
		}
		//Checks if store is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 245 && mouseY <= 295)
		{
			resourceManager.buyStore();
		}
		//Checks if factory is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 345 && mouseY <= 395)
		{
			resourceManager.buyFactory();
			repaint();
		}
		//Checks if solar panel is bought
		if (mouseX >= 195 && mouseX <= 245 && mouseY >= 445 && mouseY <= 495)
		{
			resourceManager.buySolarPanel();
			repaint();
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
