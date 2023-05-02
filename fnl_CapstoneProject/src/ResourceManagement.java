/*
Author: David Dai
Date: 5/2/23
Rev: 01
Notes: Start of ResourceManagement.java
 */

public class ResourceManagement {

	//fields
	
	//public Building building;
	//resource
		private int resources;
	//environment score
		private int environmentScore;
	//points
		private int points;
	//our beloved timer :)
		//private Timer timer;
	
	//constructors
	
	//methods
	
	//CATEGORY: Resources
	
	public int getResources() {
		return resources;
	}
	
	public void setResources(int resources) {
		this.resources = resources;
	}
	
	public int resourceTimer() {
		return 0;
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
