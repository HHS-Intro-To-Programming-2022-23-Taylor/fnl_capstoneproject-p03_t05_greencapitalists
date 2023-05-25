/*
Author: David Dai
Date: 5/2/23
Rev: 01
Notes: Start of ResourceManagement.java
 */


public class ResourceManagement {

	//Fields
	
	//resources
		private int resources = 100; //Resources you start of with. Buy a factory first, please!
		private int resourcesRate = 0; //The rate at which resources are generated (per second). dr/dt
	//environment score
		private int environmentScore = 100; //Start of at 100%. Buying buildings will reduce this number. Hits zero, game over.
	//points
		private int points = 0; //Score for spending resource to build houses, etc.
	
	//building counts
	private int houseCount = 0, storeCount = 0, factoryCount = 0, solarPanelCount = 0; //How many of each building
	
	//No constructor necessary. 

	
	// Methods
		
	//Buy method for normal buildings (Buildings that don't give resources). The input parameter is the type of building being bought.
	public void buyBuilding(Building building)
	{
		if(building.getCost() > resources) //Checks if there are enough resources to buy the ResourceBuilding.
		{
			return;
		}
		resources -= building.getCost();				//
		environmentScore -= building.getEnviScore();	//These lines all add and subtract resources, points, environment score, etc, based 
		points += building.getPoints();					//on the building's fields.
		if(building.getType() == "house")						//Increases house count if the ResourceBuilding is a house
		{
			houseCount++;
		}
		if(building.getType() == "store") 						////Increases store count if the ResourceBuilding is a store
		{
			storeCount++;
		}
		
	}
	
	//Buys a resource building. Parameter is the type of ResourceBuilding being bought. 
	public void buyResourceBuilding(ResourceBuilding building)
	{
		if(building.getCost() > resources)	//Checks if there are enough resources to buy the ResourceBuilding.
		{
			return;
		}
		resources -= building.getCost();				//
		environmentScore -= building.getEnviScore();	// These lines all add and subtract resources, points, environment score, etc, based 
		points += building.getPoints();					// on the building's fields.
		resourcesRate += building.getResourceRate();	//
		if(building.getType() == "solar panel")					//Increases solar panel count if the ResourceBuilding is a panel
		{
			solarPanelCount++;				
		}
		if(building.getType() == "factory")						//Increases factory count if the ResourceBuilding is a factory.
		{
			factoryCount++;
		}
	}
	
	//					CATEGORY: Resources
	
	//For draw to know how many resources the player has.
	public int getResources() {
		return resources;
	}
	
	
	//Increases the number of resources by resource rate. Called periodically by draw.
	public void giveResource() {
		resources += resourcesRate;
	}
	
	//Changes the resource rate. Only used when draw is setting the rate to 0, when the game ends
	public void setResourceRate(int newResourceRate)
	{
		resourcesRate = newResourceRate;
	}
	
	//					CATEGORY: Points
	
	//For draw to know how many points the player has.
	public int getPoints() {
		return points;
	}
	
	//					CATEGORY: Environment Score
	
	//For draw to know what the environment score is, so it can write it on the screen.
	public int getEnvironmentScore() {
		return environmentScore;
	}
	
	//					CATEGORY: Buildings
	
	//Returns the amount of houses built by the player.
	public int getHouseCount()
	{
		return houseCount;
	}
	
	//Returns the amount of stores built by the player.
	public int getStoreCount()
	{
		return storeCount;
	}
	
	//Returns the amount of factories built by the player.
	public int getFactoryCount()
	{
		return factoryCount;
	}
	
	//Returns the amount of solar panels built by the player.
	public int getSolarCount()
	{
		return solarPanelCount;
	}
	
	
}

