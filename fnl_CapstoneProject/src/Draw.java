// Author: Sanah Bhandari
// Date  : May 2, 2023
// Rev   : 01
// Notes : Notes go here

import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JPanel {

	// JPanel panel;
	// JFrame score;
	// JFrame points;
	// JFrame resources;
	// JButton buyBuilding1;
	
	// JButton buyBuilding2;
	// JButton buyBuilding3;
	// JButton buyBuilding4;
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
	      
		g.setColor(Color.GRAY);
		
		g.drawRect(400, 50, 150, 30);
		g.drawRect(550, 50, 150, 30);
		
		g.drawRect(50, 100, 100, 400);
	      
	}
	
}
