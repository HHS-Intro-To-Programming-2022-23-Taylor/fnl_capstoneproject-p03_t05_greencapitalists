/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 2
 * Notes  : None
 */


 public abstract class Building {
	//Fields
	 private int enviScoreDecrease = 0;
	 private int points = 0;
	 private int cost = 0;
	 private String buildingType = null;
	 
	 //Constructor
	 public Building() //No-args constructor, for ResourceManagement
	 {
		 
	 }

    public Building(int enviScoreDecreaseParameter, int pointsParameter, int costParameter, String buildingType)
    {
    	enviScoreDecrease = enviScoreDecreaseParameter;
    	points = pointsParameter;
    	cost = costParameter;
    	this.buildingType = buildingType;
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
    
    //Returns the building's cost
    public int getCost()
    {
    	return cost;
    }
    
    //Returns a string that is the building's name.
    public String getType()
    {
    	return buildingType;
    }
 }
