import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a window frame
	    JFrame mainScreen = new JFrame ("Main Screen");
	    mainScreen.setBounds(300, 100, 800, 600);   //establish initial size in pixels
	    mainScreen.getContentPane().setBackground(Color.WHITE); // set background color

	    mainScreen.setResizable(false); // the window can be resized
	    mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this happens with window is closed
	    mainScreen.setVisible(true);
		
	    // create components (widgets) to add to the window.  this can be panels, buttons, images, etc.
	    // in this case a new panel     
	    Draw mainPanel = new Draw(); // create a panel to add to window
	    mainPanel.setBackground(Color.WHITE);// set the background color of the panel to white
	      
	    // add the panel to the frame
	    Container windowContainer = mainScreen.getContentPane();// get the window's container
	    windowContainer.add(mainPanel); // add the panel to the window
	      
	    // make the window visible
	    mainScreen.setVisible(true);
	    
	}

}
