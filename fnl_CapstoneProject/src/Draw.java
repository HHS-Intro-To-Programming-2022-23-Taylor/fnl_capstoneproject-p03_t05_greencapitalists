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
	private Image houseImg = new ImageIcon("House.gif").getImage();
	private Image storeImg = new ImageIcon("Store.gif").getImage();
	private Image factoryImg = new ImageIcon("Factory.gif").getImage();
	private Image solarPanelImg = new ImageIcon("SolarPanel.gif").getImage();
	private Image buildingsImg = new ImageIcon("buildings.gif").getImage();

	ResourceManagement resourceManager = new ResourceManagement();
	private long startTime = System.currentTimeMillis();
	private long timeTillNextResource = 1000;
	private int timePassed = 0;
	
	private int mouseX;
	private int mouseY;
	
	Building house = new House();
	Building store = new Store();
	ResourceBuilding factory = new Factory();
	ResourceBuilding solarPanel = new SolarPanel();
	
	private Font endText = new Font("TimeRoman", 50, 50);
	
	//Integer which keeps game running. If 0, game is running; if 1, game is over (3 minutes up); if two, game is lost (Environment score 0).
	private int gameRunning = 0;

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

		// top 3 boxes
		g.drawRect(250,  50,  150,  30);
		g.drawString("Time Left: " + (180 - timePassed), 300, 70);
		g.drawRect(400, 50, 150, 30);
		g.drawString(resourceManager.getResources() + " resources", 460, 70); 	
		g.drawRect(550, 50, 150, 30);
		g.drawString(resourceManager.getPoints() + " points", 610, 70);

		// build houses box
		g.drawRect(50, 100, 200, 400);
		g.drawString("Build House:", 70, 120);
		g.drawString("Cost: 25 resources", 70, 138);
		g.drawString("Credit: 5 points", 70, 156);
		g.drawString("Environment:  -5%", 70, 174);
		
		//Draw image in the center of the screen
		g.drawImage(buildingsImg, 550, 100, 200, 175, this);

		// build stores box
		g.drawRect(50, 100, 200, 300);
		g.drawString("Build Store:", 70, 220);
		g.drawString("Cost: 100 resources", 70, 238);
		g.drawString("Credit: 25 points", 70, 256);
		g.drawString("Environment: -5%", 70, 274);

		// build factories box
		g.drawRect(50, 100, 200, 200);
		g.drawString("Build Factory:", 70, 320);
		g.drawString("Cost: 80 resources", 70, 338);
		g.drawString("Credit: 2 points", 70, 356);
		g.drawString("Environment: -25%", 70, 374);
		g.drawString("Rate: 5 resource/sec", 70, 392);	

		// build solar panels box
		g.drawRect(50, 100, 200, 100);
		g.drawString("Build Solar Panel:", 70, 420);
		g.drawString("Cost: 120 resources", 70, 438);
		g.drawString("Credit: 5 points", 70, 456);
		g.drawString("Environment: -0%", 70, 474);
		g.drawString("Rate: 3 resource/sec", 70, 492);

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
		g.drawImage(houseImg, 195, 145, 50, 50, this);
		g.fillRect(190, 240, 60, 60);
		g.drawImage(storeImg, 195, 245, 50, 50, this);
		g.fillRect(190, 340, 60, 60);
		g.drawImage(factoryImg, 195, 345, 50, 50, this);
		g.fillRect(190, 440, 60, 60);
		g.drawImage(solarPanelImg, 195, 445, 50, 50, this);
		
		//Writes the game instructions on the screen
		g.setColor(Color.BLACK);
		g.drawString("Instructions: Buy buildings by clicking the green buttons.", 255, 110);
		g.drawString("Try to get as many points as you can, while keeping your", 255, 125);
		g.drawString("environmental score high. Each building's points, ",  255, 140);
		g.drawString("environment score decrease, and cost are shown.", 255, 155);
		g.drawString("Factories and solar panels increase your resources,", 255, 170);
		g.drawString("but give very few points.", 255, 185);
		g.drawString("TIPS: The first building you buy should be a factory,", 255, 225);
		g.drawString("and after that, invest in solar panels, then houses or", 255, 240);
		g.drawString("stores.", 255, 255);
		
		
		//Draws all the building counts
		g.setColor(Color.BLACK);
		g.drawString("Houses: ", 255, 360);
		g.drawRect(255, 375, 600, 0);
		g.drawString("Stores: ", 255, 390);
		g.drawRect(255, 406, 600, 0);
		g.drawString("Factories: ", 255, 420);
		g.drawRect(255, 437, 600, 0);
		g.drawString("Solar Panels: ", 255, 450);
		g.drawRect(255, 470, 600, 0);
		//Draws the building "bar graphs"
		for(int i = 0; i < resourceManager.getHouseCount(); i++)	//Houses
		{
			g.drawImage(houseImg, 330 + i*30, 345, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getStoreCount(); i++)	//Stores
		{
			g.drawImage(storeImg, 330 + i*30, 376, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getFactoryCount(); i++)	//Factories
		{
			g.drawImage(factoryImg, 330 + i*30, 407, 30, 30, this);
		}
		for(int i = 0; i < resourceManager.getSolarCount(); i++)	//Panels
		{
			g.drawImage(solarPanelImg, 330 + i*30, 438, 30, 30, this);
		}
		
		//Checks if the game is over or not, and draws an end message based on that
		switch(gameRunning)
		{
		case 0:
			//Timer - Checks for elapsed time - Only works while gameRunning = 0
			calculateTime();
			break;
		case 1:
			g.setFont(endText);
			g.setColor(Color.DARK_GRAY);
			g.drawString("GAME OVER", 300, 300);
			resourceManager.setResourceRate(0);
			break;
		case 2:
			g.setFont(endText);
			g.setColor(Color.RED);
			g.drawString("YOU LOSE", 300, 300);
			break;
		default: 
			break;
			
		}
		
		calculateGameRunning();
		
		
		//Makes sure values don't drop below 0
		if(timePassed >= 180)
		{
			timePassed = 180;
		}
		
		//Repaints the panel
		repaint();

	}

	//Keeps checking whether the game is over, whether by running out of time or by reaching environment score 0.
	public void calculateGameRunning()
	{
		//Sets the gameRunning Method
				if(timePassed >= 180)
				{
					gameRunning = 1;	//Game over
				}
				if(resourceManager.getEnvironmentScore() <= 0)
				{
					gameRunning = 2;	//Game lost
				}
	}

	//Calculates the amount of time passed from when the game started. Every time one second (100 milliseconds) passes,
	// the amount of resources increases by resourceRate, and the timePassed count goes up by one. 
	public void calculateTime()
	{
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - startTime;
		if(elapsedTime >= timeTillNextResource)
		{
			timeTillNextResource += 1000;
			resourceManager.giveResource();
			timePassed++;
		}
	}
	

	//Checks where and when a mouse is clicked on the JComponent. Used as a button.
	public void mouseClicked(MouseEvent e) {
		if(gameRunning == 0)		//This if statement makes sure you can only buy buildings when the game is running
		{
			mouseX = e.getX();
			mouseY = e.getY();
			
			//Checks if house is bought
			if (mouseX >= 195 && mouseX <= 245 && mouseY >= 145 && mouseY <= 195)
			{
				resourceManager.buyBuilding(house);
			}
			//Checks if store is bought
			if (mouseX >= 195 && mouseX <= 245 && mouseY >= 245 && mouseY <= 295)
			{
				resourceManager.buyBuilding(store);
			}
			//Checks if factory is bought
			if (mouseX >= 195 && mouseX <= 245 && mouseY >= 345 && mouseY <= 395)
			{
				resourceManager.buyResourceBuilding(factory);
				repaint();
			}
			//Checks if solar panel is bought
			if (mouseX >= 195 && mouseX <= 245 && mouseY >= 445 && mouseY <= 495)
			{
				resourceManager.buyResourceBuilding(solarPanel);
				repaint();
			}
		}else
		{
			
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
