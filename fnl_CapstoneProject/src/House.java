import java.awt.Image;

import javax.swing.ImageIcon;

public class House implements Building{

	//Fields
	private int enviScoreDecrease = 5;
	private int points = 3;
	private Image image  = new ImageIcon("house.gif").getImage();
	private int cost;
	
	
	
	//Constructor
	public House()
	{
		
	}
	
	
	//Methods 
	
	//Returns environmental score
	public int getEnviScore() {
		return enviScoreDecrease;
	}

	//Returns the gif
	public Image getImage1() {
		return image;
	}

	//Returns the points
	public int getPoints() {
		return points;
	}

	//Returns the type of the building...?
	public String getType() {
		return "house";
	}

	//Returns the cost
	public int getCost() {
		return cost;
	}


}