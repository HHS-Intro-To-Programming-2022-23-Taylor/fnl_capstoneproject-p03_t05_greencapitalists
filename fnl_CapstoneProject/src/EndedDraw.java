import java.awt.event.MouseEvent;

public class EndedDraw extends Draw{
	

	@Override	//Overrides the mouseClicked in Draw, so clicking a mouse will do nothing. 
	//This is in place to make sure the player cannot keep buying buildings even after the gae is over
	public void mouseClicked(MouseEvent e) {
		
	}

}
