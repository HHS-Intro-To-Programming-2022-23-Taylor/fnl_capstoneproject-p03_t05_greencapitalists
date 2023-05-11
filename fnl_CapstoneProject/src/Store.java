import java.awt.Image;

public class Store implements Building {
	 private int enviScoreDecrease = 5;
	 private int points = 10;
	 private int cost = 50;

	public int getEnviScore() {
		return enviScoreDecrease;
	}

	public Image getImage1() {
		return null;
	}

	public int getPoints() {
		return points;
	}

	public int getCost() {
		return cost;
	}

}
