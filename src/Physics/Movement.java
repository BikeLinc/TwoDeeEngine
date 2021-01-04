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
	
	int relativeSpeed = 5;
	
	boolean[] direction = {
			true, // up [0]
			true, // down [1]
			true, // left [2]
			true, // right [3]
	};
	
	public Movement(Level level, int relativeSpeed, UserInput input, Block player, Collidable[] collidables) {
		this.level = level;
		this.relativeSpeed = relativeSpeed;
		this.input       = input;
		this.player      = player;
		this.collidables = collidables;
	}

	public void move() {
		
		direction = collider.checkBounds(player, collidables);
		
		if(input.isMoveUpClicked() && direction[0]) {
			level.moveScene(0, relativeSpeed);
		}
		if(input.isMoveDownClicked() && direction[1]) {
			level.moveScene(0, -relativeSpeed);
		}
		if(input.isMoveLeftClicked() && direction[3]) {
			level.moveScene(relativeSpeed, 0);
		}
		if(input.isMoveRightClicked() && direction[2]) {
			level.moveScene(-relativeSpeed, 0);
		}
	}
	
}
