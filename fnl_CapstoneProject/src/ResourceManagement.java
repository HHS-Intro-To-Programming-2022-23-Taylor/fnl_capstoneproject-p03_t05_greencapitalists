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
		private int resources = 100; //Resources you start of with. Buy a factory first, please!
		private int resourcesRate = 0; //The rate at which resources are generated (per second). dr/dt
	//environment score
		private int environmentScore = 100; //Start of at 100%. Buying buildings will reduce this number. Hits zero, game over.
	//points
		private int points = 0; //Score for spending resource to build houses, etc.
	//our beloved timer :)
		private int time = 180; //You will start with 180 seconds. Timer hits zero, game over. Do as much as you can by then.
	
	private int houseCount = 0, storeCount = 0, factoryCount = 0, solarPanelCount = 0; //How many of each building
		
	//constructors
	
	
	
	//methods
	
	//This is called when a building is bought. Checks if can be bought first, then increases the points based on the building.
	public void calculateBasicBuilding(int resourceCost, int pointsGained, int environmentDecrease) {
		if (resourceCost > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= resourceCost;
		environmentScore -= environmentDecrease;
		points += pointsGained;
	}
	
	//This is called when a building is bought. Checks if can be bought first, then sets the increase in rate.
	public void calculateResourceBuilding(int resourceCost, int rateIncrease, int environmentDecrease) {
		if (resourceCost > resources) {
			return; //Cancels the whole method (Item cannot be bought!)
		}
		resources -= resourceCost;
		environmentScore -= environmentDecrease;
		resourcesRate += rateIncrease;
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
	public int giveResource(int resourceRate) {
		return resources += resourceRate;
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
	
	//For others classes to use if needed, may delete if unnecessary
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
	
	//ENDGAME: Ends game. Not sure what to do in it. Will be called when timer hits zero, or if any of my methods
	//realize that the environmental score is zero (or below).
	public void endGame() {
		
	}
	
//	public void test(Building building, boolean sustainable) {
//		if (building) {
//			
//		}
//	}
}
