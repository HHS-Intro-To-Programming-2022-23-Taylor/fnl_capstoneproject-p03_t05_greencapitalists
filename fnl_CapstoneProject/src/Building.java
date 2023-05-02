/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 1
 * Notes  : 
 */

import java.awt.Image;

 public abstract class Building {
	//Fields
	private int enviScoreDecrease;
    private int points;
    private Image unsustainable;
    private Image sustainable;
    
	
	//Constructor
	
	//Methods
    
    //Returns the environmental score decrease.
    public int getEnviScore()
    {
    	return enviScoreDecrease;
    }

    //Returns the image for the sustainable building.
    public Image getSustainable()
    {
    	return sustainable;
    }
    
    //Returns the image for the sustainable building. 
    public Image getUnsustainable()
    {
    	return unsustainable;
    }

    //Returns the point value.
    public int getPoints()

    
    {
    	return points;
    }

    public String getType() {
    	return "";
    }

 }
