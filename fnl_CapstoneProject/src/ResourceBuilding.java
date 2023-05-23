/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 2
 * Notes  : None
 */




public abstract class ResourceBuilding extends Building{

	private int resourceRate = 0;
	
	//Constructor
	public ResourceBuilding(int enviScoreDecreaseParameter, int pointsParameter, int costParameter, String buildingType, int resourceRateParameter)
	{
		super(enviScoreDecreaseParameter, pointsParameter, costParameter, buildingType);
		resourceRate = resourceRateParameter;
	}

	//Returns the number of resources per second this building generates. 
	public int getResourceRate()
	{
		return resourceRate; 
	}
	
	

}
