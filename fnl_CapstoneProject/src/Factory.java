/*
 * Author : Dhruv Jain
 * Date   : 5/6/23
 * Rev    : 01
 * Notes  : None
 */




public class Factory implements Building, ResourceBuilding
{
	 private int enviScoreDecrease = 10;
	 private int points = 15;
	 private int cost = 50;
	 int delay = 2000; //(Milliseconds)
	// Timer timer = new Timer(delay, giveResource());



	public int getEnviScore() {
		return enviScoreDecrease;
	}

	public int getPoints() {
		return points;
	}

	public String getType() {
		return null;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public int returnResourceRate() {
		// TODO Auto-generated method stub
		return 0;
	} 

//	ActionListener giveResource()
//	{
//		
//	}
}
