/*
 * Author : Dhruv Jain
 * Date   : 5/2/23
 * Rev    : 2
 * Notes  : None
 */

public class Factory extends ResourceBuilding
{

	//Constructor
	 public Factory()
	 {
		 /*
		  *Passes an environmental score decrease of 5, 3 points, 80 cost,
		  * 'factory' name, and 5 resourceRate to the ResourceBuilding constructor.
		  */
		 super(25, 3, 80, "factory", 5);
	 }

}
