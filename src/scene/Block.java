package scene;

import java.awt.Color;
import java.awt.Rectangle;

public class Block extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	Color color;
	
	public Block(int x, int y, int width, int height, Color color) {
		this.x      = x;
		this.y      = y;
		this.width  = width;
		this.height = height;
		this.color  = color;
	}
	
	public Color getColor() {
		return color;
	}
	
}
