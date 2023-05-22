/*
Author: David Dai
Date: 5/2/23
Rev: 01
Notes: Start of ResourceManagement.java
 */

import javax.swing.*;

public class ResourceManagement {

	//fields
	
	//public Building building;
	//resource
		static private int resources = 100; //Resources you start of with. Buy a factory first, please!
		static private int resourcesRate = 0; //The rate at which resources are generated (per second). dr/dt
	//environment score
		static private int environmentScore = 100; //Start of at 100%. Buying buildings will reduce this number. Hits zero, game over.
	//points
		static private int points = 0; //Score for spending resource to build houses, etc.
	
	static private int houseCount = 0, storeCount = 0, factoryCount = 0, solarPanelCount = 0; //How many of each building
	Building house = new House();
	Building store = new Store();
	ResourceBuilding factory = new Factory();
	ResourceBuilding solarPanel = new SolarPanel();
		
	//constructors
	
	
	
	//methods
	
	//This is called when a building is bought. Checks if can be bought first, then increases the points based on the building.
	public void buyStore() {
		if (store.getCost() > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= store.getCost();
		environmentScore -= store.getEnviScore();
		points += store.getPoints();
		storeCount++;
	}
	
	public void buyHouse() {
		if (house.getCost() > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= house.getCost();
		environmentScore -= house.getEnviScore();
		points += house.getPoints();
		houseCount++;
	}
	
	//This is called when a building is bought. Checks if can be bought first, then sets the increase in rate.
	public void buyFactory() {
		if (factory.getCost() > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= factory.getCost();
		environmentScore -= factory.getEnviScore();
		resourcesRate += factory.getResourceRate();
		factoryCount++;
	}
	
	public void buySolarPanel() {
		if (solarPanel.getCost() > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= solarPanel.getCost();
		environmentScore -= solarPanel.getEnviScore();
		resourcesRate += solarPanel.getResourceRate();
		solarPanelCount++;
		
	}
	
	//Buy method for normal buildings (Buildings that don't give resources)
	public void buyBuilding(Building building)
	{
		if(building.getCost() > resources)
		{
			return;
		}
		resources -= building.getCost();
		environmentScore -= building.getEnviScore();
		
	}
	
	//CATEGORY: Resources
	
	//For others classes to use if needed, may delete if unnecessary
	public int getResources() {
		return resources;
	}
	
	//For others classes to use if needed, may delete if unnecessary
	public void setResources(int resources) {
		this.resources = resources;
	}
	
	//For others classes to use if needed, may delete if unnecessary
	public void giveResource() {
		resources += resourcesRate;
	}
	
	//CATEGORY: Points
	
	//For others classes to use if needed, may delete if unnecessary
	public int getPoints() {
		return points;
	}
	
	//For others classes to use if needed, may delete if unnecessary
	public void setPoints(int points) {
		this.points = points;
	}
	
	//CATEGORY: Environment Score
	
	//For draw to know what the environment score is, so it can write it on the screen.
	public int getEnvironmentScore() {
		return environmentScore;
	}
	
	//For others classes to use if needed, may delete if unnecessary
	public void setEnvironmentScore(int environmentScore) {
		this.environmentScore = environmentScore;
	}
	
	//Reduces the environmental score. May delete this due to redundancy (other method has what this method does).
	public void EnvironmentScoreReudction(int environmentReduction) {
		environmentScore -= environmentReduction;
	}
	
	public void setResourceRate(int newResourceRate)
	{
		resourcesRate = newResourceRate;
	}
	

	
//	public void test(Building building, boolean sustainable) {
//		if (building) {
//			
//		}
//	}
	
	
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

