
public class SolarPanel implements Building, ResourceBuilding{

	//Fields
	 private int enviScoreDecrease = 15;
	 private int points = 10;
	 private int cost = 150;
	 private int resourcesPerFiveSecond;
	
	public int getEnviScore() {
		return enviScoreDecrease;
	}

	public int getPoints() {
		return points;
	}

	public int getCost() {
		return cost;
	}
	
	public int getResourcesRate()
	{
		return resourcesPerFiveSecond;
	}

}
