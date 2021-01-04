package scene;

import java.awt.Color;

import display.DisplayManager;
import input.UserInput;

public class Level {
	
	private final static int MOVE_SPEED = 5;

	Block player = new Block(DisplayManager.WINDOW_SIZE.width / 2 - 20, // X
		DisplayManager.WINDOW_SIZE.height / 2 - 20, // Y
		40, 40, // Width, Height
		new Color(200, 20, 20)); // Color

	Collidable[] collidables = { 
		new Collidable(0, 400 + 0, 1000, 60),
	};
	/*
	 * This Method Is Called To Check For User Input
	 */
	public void update(UserInput input) {
		
		for (Collidable collidable : collidables) {
			// down
			if (collidable.y -1 < player.y + player.height && player.y < collidable.y) {
				if (player.x < collidable.x + collidable.width) {
					if (player.x + player.width > collidable.x) {
						input.sPressed = false;
					}
				}
			}
			// up 
			if (collidable.y + collidable.height + 1 > player.y && player.y + player.height > collidable.y + collidable.height) {
				if (player.x < collidable.x + collidable.width) {
					if (player.x + player.width > collidable.x) {
						input.wPressed = false;
					}
				}
			}
			// left
			if (collidable.x -1 < player.x + player.width && player.x + player.width < collidable.x + collidable.width) {
				if (player.y + player.height > collidable.y) {
					if (player.y < collidable.y + collidable.height) {
						input.dPressed = false;
					}
				}
			}
			//right
			if (collidable.x + collidable.width +1 > player.x && player.x > collidable.x) {
				if (player.y + player.height > collidable.y) {
					if (player.y < collidable.y + collidable.height) {
						input.aPressed = false;
					}
				}
			}
		}
			
		if(input.wPressed) {
			moveScene(0, MOVE_SPEED);
		}
		if(input.sPressed) {
			moveScene(0, -MOVE_SPEED);
		}
		if(input.aPressed) {
			moveScene(MOVE_SPEED, 0);
		}
		if(input.dPressed) {
			moveScene(-MOVE_SPEED, 0);
		}
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
	 * Method Called Internally To Move All Non-Player Objects
	 */
	private void moveScene(int x, int y) {
		for(Block block: collidables) {
			block.x += x;
			block.y += y;
		}
	}

}
