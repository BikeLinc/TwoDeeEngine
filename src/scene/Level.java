package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Physics.Movement;
import display.Display;
import input.UserInput;

public class Level {
	
	Movement movement;
	Display display;
	
	int windowSize = 0;
	
	Block player = new Block(Display.getWindowSize().width / 2 - 20, // X
		Display.getWindowSize().height / 2 - 20, // Y
		40, 40, // Width, Height
		new Color(200, 20, 20)); // Color
	ArrayList<Collidable> collidables = new ArrayList<>();
	
	/*
	 * This Method Is Called To Check For User Input
	 */
	public void update(UserInput input) {
		
		movement = new Movement(this, input, player, collidables);
		movement.move(3);
		
	}

	/**
	 * This Method Is Called By Renderer
	 * @return collidable Object
	 */
	public ArrayList<Collidable> getCollidables() {
		return collidables;
	}

	/**
	 * This Method Is Called By Renderer
	 * @return player Object
	 */
	public Block getPlayer() {
		return player;
	}
	
	/*
	 * Method Called To Move All Non-Player Objects
	 */
	public void moveScene(int x, int y) {
		for(Block block: collidables) {  
			block.x += x;
			block.y += y;
		}
	}
	public void createFlappyBirdCollidables() {
		// Initial X Position
		int x = 100;
		// Constant Y Position
		int y = 400;
		// Constant Width
		int w = 50;
		// Initial Height
		int h = 150;
		// Constant Height
		int gap = 200;
		
		for (int index = 0; index < 30; index++) {
			h = getUpperH(h);
			System.out.println(h);
			collidables.add(new Collidable(x, y, w, h));
			collidables.add(new Collidable(x, y + h + gap, w, getLowerH(y,gap,h)));
			x += 200;
			h += h * .153154f;
			if(h < y + 100) {
				h += 100;
			}
		}
	}
	
	public int getUpperH(int h) {
		// Height Generation Setting
				Random rand = new Random();
				int min = 150;
				int max = 190;
		return min + rand.nextInt(max);
	}
	
	public int getLowerH(int y, int gap, int h) {
		int bottomY = y + h + gap;
		while (bottomY + h > 300) {
			h--;
		}
		while (bottomY + h < 300) {
			h++;
		}
		if(h < 1) {
			h = h * -1;
		}
		return h;
	}
	
	public void setup() {
		createFlappyBirdCollidables();
	}

}
