package Physics;

import java.util.ArrayList;

import scene.Block;
import scene.Collidable;

public class Collider {
	
	boolean[] direction = {
			true, // up [0]
			true, // down [1]
			true, // left [2]
			true, // right [3]
	};

	public boolean[] checkBounds(Block player, ArrayList<Collidable> collidables) {
		for (Collidable collidable : collidables) {
			// down
			if (collidable.y -1 < player.y + player.height && player.y < collidable.y) {
				if (player.x < collidable.x + collidable.width) {
					if (player.x + player.width > collidable.x) {
						direction[1] = false;
					}
				}
			}
			// up 
			if (collidable.y + collidable.height + 1 > player.y && player.y + player.height > collidable.y + collidable.height) {
				if (player.x < collidable.x + collidable.width) {
					if (player.x + player.width > collidable.x) {
						direction[0] = false;
					}
				}
			}
			// left
			if (collidable.x -1 < player.x + player.width && player.x + player.width < collidable.x + collidable.width) {
				if (player.y + player.height > collidable.y) {
					if (player.y < collidable.y + collidable.height) {
						direction[2] = false;
					}
				}
			}
			//right
			if (collidable.x + collidable.width +1 > player.x && player.x > collidable.x) {
				if (player.y + player.height > collidable.y) {
					if (player.y < collidable.y + collidable.height) {
						direction[3] = false;
					}
				}
			}
		}
		return direction;
	}
	
}
