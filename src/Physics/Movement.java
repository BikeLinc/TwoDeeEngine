package Physics;

import input.UserInput;
import scene.Block;
import scene.Collidable;
import scene.Level;

public class Movement {
	
	Collider collider = new Collider();
	
	Level level;
	UserInput input;
	Block player;
	Collidable[] collidables;
	
	final static int MOVE_SPEED         = 5;
	final static int WEIGHT             = 2;
	final static int INITIAL_JUMP_SPEED = 6;
	
	
	int jumpingSpeed;
	
	boolean[] direction = {
			true, // up    [0]
			true, // down  [1]
			true, // left  [2]
			true, // right [3]
	};
	
	boolean falling = false;
	boolean jumping = false;
	
	public Movement(Level level, UserInput input, Block player, Collidable[] collidables) {
		this.level         = level;
		this.input         = input;
		this.player        = player;
		this.collidables   = collidables;
	}

	public void move() {
		
		direction = collider.checkBounds(player, collidables);
		
		if(direction[1]) {
			falling = true;
		}
		
		// Up
		if(input.isMoveUpClicked() && direction[0]) {
			level.moveScene(0, MOVE_SPEED);
			falling = false;
		}
		if(falling) {
			level.moveScene(0, -MOVE_SPEED);
		}
		// Down
		if(input.isMoveDownClicked() && direction[1]) {
			level.moveScene(0, -MOVE_SPEED);
		}
		// Left
		if(input.isMoveLeftClicked() && direction[3]) {
			level.moveScene(MOVE_SPEED, 0);
		}
		// Right
		if(input.isMoveRightClicked() && direction[2]) {
			level.moveScene(-MOVE_SPEED, 0);
		}
	}
}
