package gridWithButtons;
/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 1
 * Notes  : 
 */

import java.awt.Image;
import javax.swing.ImageIcon;

 public interface Building {
	//Fields - Just a reference on what fields are needed
//	 private int enviScoreDecrease;
//	 private int points;
//	 private Image img;
//	 private int cost;

    
    
	//Methods
    
    
    
    //Returns the environmental score decrease.
    public int getEnviScore();

    //Returns the point value.
    public int getPoints();
    
    //Returns buildings
    public int getCost();
 }
