// Author: Sanah Bhandari
// Date  : May 2, 2023
// Rev   : 01
// Notes : Notes go here

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
	JTextField display = new JTextField("hi");
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
	      
		g.setColor(Color.BLACK);
		
		g.drawRect(400, 50, 150, 30);
		g.drawString("resources", 480, 70);
		g.drawRect(550, 50, 150, 30);
		g.drawString("points", 630, 70);
		
		g.drawRect(50, 100, 200, 400);
		g.drawString("Build House:", 70, 120);
		g.drawString("resources", 70, 140);
		g.drawRect(50, 100, 200, 300);
		g.drawString("Build Store:", 70, 220);
		g.drawString("resources", 70, 240);
		g.drawRect(50, 100, 200, 200);
		g.drawString("Build Factory:", 70, 320);
		g.drawString("resources", 70, 340);
		g.drawRect(50, 100, 200, 100);
		g.drawString("Build Solar Panel:", 70, 420);
		g.drawString("resources", 70, 440);
		g.drawString("Environmental Score:", 400, 500);
		g.setColor(Color.GREEN);
		g.drawString("100%", 515, 500);
	      
	}
	
	public void reload()
	{
		// vendor.setResources(FULL_STOCK);
		// display.setText(" " + vendor.getDeposit() + "  ");
		repaint();
	}
	
}
