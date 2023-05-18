/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 2
 * Notes  : None
 */




public abstract class ResourceBuilding extends Building{

	private int resourceRate = 0;
	
	//Constructor
	public ResourceBuilding()			//No-args Constructor
	{
		
	}
	
	public ResourceBuilding(int enviScoreDecreaseParameter, int pointsParameter, int costParameter, int resourceRateParameter)
	{
		super(enviScoreDecreaseParameter, pointsParameter, costParameter);
		resourceRate = resourceRateParameter;
	}

	public int getResourceRate()
	{
		return resourceRate; 
	}
	
	

}
