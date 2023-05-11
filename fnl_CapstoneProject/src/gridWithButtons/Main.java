package gridWithButtons;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	public static void main(String[] args) {

		JFrame window = new JFrame("Grid responds to JButton Demo");
		window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		window.setLayout(new GridBagLayout());
		
		
	    GridBagConstraints c = new GridBagConstraints();
//	    if (shouldFill) {
//	    	//natural height, maximum width
	    	c.fill = GridBagConstraints.VERTICAL;
//	    }
		
		JPanel controlPanel = new JPanel();
		Grid grid = new Grid();
		//int gridDimension = Math.max(Grid.CANVAS_WIDTH+8, Grid.CANVAS_HEIGHT+32);
		grid.setSize(Grid.CANVAS_WIDTH+8, Grid.CANVAS_HEIGHT+32);

		
		
		controlPanel.setLayout(new FlowLayout());
		JButton button = new JButton("Change");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.respondToButton();
			}
		});
		controlPanel.add(button);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grid.reset();
			}
		});
		controlPanel.add(resetButton);
		
	    c.gridx = 0;
	    c.gridy = 0;
		window.getContentPane().add(controlPanel);		
		
	    c.ipady = Grid.CANVAS_HEIGHT+8;      //make this component tall
	    c.ipadx = Grid.CANVAS_WIDTH+32;
	    c.gridwidth = GridBagConstraints.REMAINDER;
	    c.gridx = 0;
	    c.gridy = 1;
		window.getContentPane().add(grid,c);
		


		
		// doesn't account for JFrame's frame!
		// Hack - add some pixel to the width and height
		window.setSize(Grid.CANVAS_WIDTH+8, Grid.CANVAS_HEIGHT+132);	
	
		window.setVisible(true);
		window.setResizable(false);
	
	}

}
