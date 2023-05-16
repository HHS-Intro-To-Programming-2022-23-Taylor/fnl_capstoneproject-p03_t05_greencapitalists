/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 1
 * Notes  : 
 */


 public abstract class Building {
	//Fields
	 private int enviScoreDecrease = 0;
	 private int points = 0;
	 private int cost = 0;
	 
	 //Constructor
	 public Building() //No-args constructor, for ResourceManagement
	 {
		 
	 }

    public Building(int enviScoreDecreaseParameter, int pointsParameter, int costParameter)
    {
    	enviScoreDecrease = enviScoreDecreaseParameter;
    	points = pointsParameter;
    	cost = costParameter;
    }
    
	//Methods
    
    //Returns the environmental score decrease.
    public int getEnviScore()
    {
    	return enviScoreDecrease;
    }

    //Returns the point value.
    public int getPoints()
    {
    	return points;
    }
    
    //Returns buildings
    public int getCost()
    {
    	return cost;
    }
 }
