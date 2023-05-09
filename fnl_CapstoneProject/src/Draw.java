// Author: Sanah Bhandari
// Date  : May 2, 2023
// Rev   : 01
// Notes : Notes go here

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JPanel implements ActionListener {

	// JPanel panel;
	// JFrame score;
	// JFrame points;
	// JFrame resources;
	JButton buyHouse, buyStore, buyFactory, buySolarPanel;
	// JTextField display = new JTextField("hi");
	private Image buildings = new ImageIcon("buildings.gif").getImage();
	private ImageIcon house = new ImageIcon("House.gif");
	ResourceManagement resourceManager = new ResourceManagement();

	public Draw() {
		
		buyHouse = new JButton(" 25 ", house);
	    buyHouse.addActionListener(this);
	    buyHouse.setSize(20, 21);
		buyStore = new JButton(" 10 ", house);
		buyStore.addActionListener(this);
		buyFactory = new JButton("  5  ", house);
		buyFactory.addActionListener(this);
		buySolarPanel = new JButton("  5 ", house);
		buySolarPanel.addActionListener(this);
		
		JPanel buttons = new JPanel(new GridLayout(4, 1, 100, 0));
		buttons.setBackground(Color.BLUE);
		buttons.add(buyHouse);
		buttons.add(buyStore);
		buttons.add(buyFactory);
		buttons.add(buySolarPanel);
		
		this.add(buttons);
		
	}
	
	public void paint(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);

		// top 2 boxes
		g.drawRect(400, 50, 150, 30);
		g.drawString(resourceManager.getResources() + " resources", 460, 70);
		g.drawRect(550, 50, 150, 30);
		g.drawString(resourceManager.getPoints() + " points", 610, 70);

		// build houses box
		g.drawRect(50, 100, 200, 400);
		g.drawString("Build House:", 70, 120);
		g.drawString("resources", 70, 140);
		//g.drawImage(house, 200, 100, 50, 50, this);

		// build stores box
		g.drawRect(50, 100, 200, 300);
		g.drawString("Build Store:", 70, 220);
		g.drawString("resources", 70, 240);

		// build factories box
		g.drawRect(50, 100, 200, 200);
		g.drawString("Build Factory:", 70, 320);
		g.drawString("resources", 70, 340);

		// build solar panels box
		g.drawRect(50, 100, 200, 100);
		g.drawString("Build Solar Panel:", 70, 420);
		g.drawString("resources", 70, 440);

		// print environmental score
		g.drawString("Environmental Score:", 400, 500);
		
		// an environmental score below or equal to 20 means it turns red
		if (resourceManager.getEnvironmentScore() <= 20) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.GREEN);
		}
		g.drawString(resourceManager.getEnvironmentScore() + "%", 515, 500);

		// draws buildings image in screen's center
		g.drawImage(buildings, 300, 100, 400, 350, this);

		// buttons.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		
		if (b == buyHouse)
		{
			resourceManager.buyHouse();
			repaint();
		}
	}



}
