/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 1
 * Notes  : 
 */

import java.awt.Image;

import javax.swing.ImageIcon;

 public abstract class Building {
	//Fields
	private int enviScoreDecrease;
    private int points;
    private Image img2;
    private Image img1;

   
	
	//Constructor
	
    
    
    
	//Methods
    
    
    
    //Returns the environmental score decrease.
    public int getEnviScore()
    {
    	return enviScoreDecrease;
    }

    //Returns the image for the sustainable building.
    public Image getImage1()
    {
    	return img1;
    }
    
    //Returns the image for the sustainable building. 
    public Image getImage2()
    {
    	return img2;
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
