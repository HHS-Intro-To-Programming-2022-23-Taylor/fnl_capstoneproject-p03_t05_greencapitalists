import java.awt.Image;

public class SolarPanel implements Building, ResourceBuilding{

	//Fields
	 private int enviScoreDecrease;
	 private int points;
	 private Image img;
	 private int cost;
	 private int resourcesPerFiveSecond;
	
	public int getEnviScore() {
		return enviScoreDecrease = 3;
	}

	public int getPoints() {
		return points;
	}

	public int getCost() {
		return cost = 150;
	}
	
	public int getResourcesRate()
	{
		return resourcesPerFiveSecond;
	}

}
