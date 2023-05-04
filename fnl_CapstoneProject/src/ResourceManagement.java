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
		private int resources = 100;
	//environment score
		private int environmentScore = 100;
	//points
		private int points = 0;
	//our beloved timer :)
		private int time = 0;
	
	private int houseCount = 0, storeCount = 0, factoryCount = 0, solarPanelCount = 0;
		
	//constructors
	
	
	
	//methods
	
	//This method is called by Building.java, and changes all the values such as resources accordingly
	public void calculateBasicBuilding(int resourceCost, int pointsGained, int environmentDecrease) {
		if (resourceCost > resources) {
			return;
		}
		resources -= resourceCost;
		environmentScore -= environmentDecrease;
		points += pointsGained;
	}
	
	public void calculateResourceBuilding(int resourceCost, int rateIncrease, int environmentDecrease) {
		
	}
	
	//CATEGORY: Resources
	
	public int getResources() {
		return resources;
	}
	
	public void setResources(int resources) {
		this.resources = resources;
	}
	
	public int resourceTimer(int resourceRate) {
		return resources += resourceRate;
	}
	
	//CATEGORY: Points
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	//CATEGORY: Environment Score
	
	public int getEnvironmentScore() {
		return environmentScore;
	}
	
	public void setEnvironmentScore(int environmentScore) {
		this.environmentScore = environmentScore;
	}
	
	public void EnvironmentScoreReudction(int environmentReduction) {
		environmentScore -= environmentReduction;
	}
	
	//ENDGAME
	public void endGame() {
		
	}
	
//	public void test(Building building, boolean sustainable) {
//		if (building) {
//			
//		}
//	}
}
