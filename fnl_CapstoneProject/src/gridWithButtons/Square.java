package gridWithButtons;


import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int x, width;
	private int y, height;
	private Color c = Color.RED;

	public Square (int x, int width, int y, int height) {
		this.x = x;
		this.width = width;
		this.y = y;
		this.height = height;
	}
	
	public void click() {
		if (Color.RED == c) {
			this.c = Color.YELLOW;
		}
		else {
			this.c = Color.RED;
		}
	}
	
	public void reset() {
		this.c = Color.RED;
	}
	
	public void draw (Graphics g) {
		g.setColor(this.c);
		g.fillRect(x, y, width, height);
	}
}
