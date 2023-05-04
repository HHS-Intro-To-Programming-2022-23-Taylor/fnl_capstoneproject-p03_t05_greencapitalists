import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create a window frame
	    JFrame mainScreen = new JFrame ("Main Screen");
	    mainScreen.setBounds(300, 300, 800, 600);   //establish initial size in pixels
	    mainScreen.getContentPane().setBackground(Color.WHITE); // set background color

	    mainScreen.setResizable(false); // the window can be resized
	    mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this happens with window is closed
	    mainScreen.setVisible(true);
		
		
	}

}
