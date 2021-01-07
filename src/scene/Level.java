package scene;

import java.awt.Color;
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

	Collidable[] collidables = { 
		new Collidable(0, 400 + 0, 500, 60),
	};
	/*
	 * This Method Is Called To Check For User Input
	 */
	public void update(UserInput input) {
		
		movement = new Movement(this, input, player, collidables);
		movement.move();
		
	}

	/**
	 * This Method Is Called By Renderer
	 * @return collidable Object
	 */
	public Collidable[] getCollidables() {
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

}
