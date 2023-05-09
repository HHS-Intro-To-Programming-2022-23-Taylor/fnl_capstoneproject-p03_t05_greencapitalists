/*
 * Author : Dhruv Jain
 * Date   : 5/6/23
 * Rev    : 01
 * Notes  : None
 */


import java.awt.Image;
import java.awt.event.ActionListener;
import java.lang.Object;	
import javax.swing.Timer;

public class Factory implements Building, ResourceBuilding
{
	 private int enviScoreDecrease = 10;
	 private int points = 15;
	 private Image img;
	 private int cost = 50;
	 int delay = 2000; //(Milliseconds)
	// Timer timer = new Timer(delay, giveResource());



	public int getEnviScore() {
		return enviScoreDecrease;
	}

	public Image getImage1() {
		return null;
	}

	public int getPoints() {
		return points;
	}

	public String getType() {
		return null;
	}

	public int getCost() {
		return cost;
	} 

//	ActionListener giveResource()
//	{
//		
//	}
}
