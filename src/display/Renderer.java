package display;

import java.util.ArrayList;
import java.util.List;

import scene.Block;
import scene.Collidable;
import scene.Level;

public class Renderer {
	
	List<Block> blocks = new ArrayList<>();

	/**
	 * This Method Gets All Block Objects From Level Object
	 * @param level
	 */
	public void prepare(Level level) {
		ArrayList<Collidable> collidables = level.getCollidables();
		Block player             = level.getPlayer();
		
		blocks.clear();
		for (Collidable collidable : collidables) {
			blocks.add(collidable);
		}
		blocks.add(player);
	}

	/**
	 * This Method Returns Block Objects To Display 
	 * @return
	 */
	public List<Block> getScene() {
		return blocks;
	}

}
