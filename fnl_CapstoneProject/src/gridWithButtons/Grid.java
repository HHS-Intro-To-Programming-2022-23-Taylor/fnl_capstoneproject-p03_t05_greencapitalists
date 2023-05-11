package gridWithButtons;


// Author:  Greg Burroughs
// Date:    5/8/2020
// Version: 1.0
// Notes:   Based on FCP Grid with Mouse
//          Features:
//            Add two buttons, "Change" and "Reset"
//            clicking "Change" causes the "next Square in Line" to change colors
//            clicking "Reset" returns all Squares to their original color
//          Code changes:
//          Deletes MouseListener
//          in Main.java
//          .  No longer extends MouseListener
//          .  Add a GridBoxLayout manager to the window JFrame
//          .  Add a JPanel (controlPanel) containing two JButtons
//          .  Add the JPanels controlPanel and grid to the window
//          in Square.Java
//          .  Add a method reset()
//          in Grid.java 
//          .  Add methods respondToButton() and reset()
//
//          To Do: return MouseListener and confirm you can still click squares

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class Grid extends JPanel {

	private Square[][] grid;
	//  Upper left corner
	//  .  Code assumes upper left is (0, 0)
	//  .  Could use this in an enhancement
	private int x = 0, y = 0;
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	public static final int SQUARE_WIDTH = 100;
	public static final int SQUARE_HEIGHT = 100;
	public static final int GRID_LINE_WIDTH = 8;
	public static final int GRID_WIDTH = COLUMNS * SQUARE_WIDTH;
	public static final int GRID_HEIGHT = ROWS * SQUARE_HEIGHT;
	public static final int CANVAS_WIDTH = GRID_WIDTH + GRID_LINE_WIDTH;
	public static final int CANVAS_HEIGHT = GRID_HEIGHT + GRID_LINE_WIDTH;

	private int nextColumn = 0;
	private int nextRow = 0;
	
	public Grid()  {
		grid = new Square [ROWS][COLUMNS];
		
		for (int row = 0; row < ROWS; row++ ) {
			for (int column = 0; column <COLUMNS; column++) {
				grid [column] [row] = new Square (SQUARE_WIDTH *column, SQUARE_WIDTH, SQUARE_HEIGHT * row, SQUARE_HEIGHT);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(180, 180, 180));
		g.fillRect((int)(x), (int)(y), (int)(GRID_WIDTH), (int)(GRID_HEIGHT));

		// Draw the squares
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				grid [i][j].draw(g);
			}
		}
		
		// Outline the squares
		// UGH - need to know too much!
		g.setColor(Color.BLACK);
		for (int row = 0; row <= ROWS; row++) {
			g.fillRect(0, y + SQUARE_HEIGHT * row, CANVAS_WIDTH, GRID_LINE_WIDTH);
		}
		for (int col = 0; col <= COLUMNS; col++) {
			g.fillRect(x + SQUARE_WIDTH * col, 0, GRID_LINE_WIDTH, CANVAS_HEIGHT);
		}
	}

	// Grid upper left at Point p
	// Selection at (x, y)
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		Rectangle2D.Float r = new Rectangle2D.Float(x, y, width, height);
		if (!r.contains(p))
			return null;
		int clickX = (int) ((p.x - x) * grid.length / width);
		int clickY = (int) ((p.y - x) * grid[0].length / height);

		return new Point(clickY, clickX);
	}
	
	// Assumes Grid upper left at (., upperY) and lower left at (., lowerY)
	// Click at (., y) in the  
	public int selectInterval (int x, int leftX, int intervalWidth, int numberOfIntervals) {
		int interval = 0;
		
	
		// translate x from panel coordinates into grid coordinates
		x = x - leftX;
	
		if (0 <= x && x <= intervalWidth * (numberOfIntervals))
			interval = x / intervalWidth;
		
		return interval;
	}
	
	public int xToColumn (int x, int leftX, int columnWidth, int numberOfColumns)
	{
		return (selectInterval (x, leftX, columnWidth, numberOfColumns));
	}
	
	public int yToRow (int y, int upperY, int rowHeight, int numberOfRows)
	{
		return selectInterval (y, upperY, rowHeight, numberOfRows);
	}

	public void respondToButton() {
		grid [nextColumn][nextRow].click();
		nextColumn = (nextColumn + 1) % COLUMNS;
		if (0 == nextColumn)
			nextRow = (nextRow + 1) % ROWS;
		repaint();
	}
	
	public void reset() {
		for (int row = 0; row < ROWS; row++ ) {
			for (int column = 0; column <COLUMNS; column++) {
				grid [column] [row].reset();
			}
		}
		nextColumn = 0;
		nextRow = 0;
		repaint();
	}
	
}
