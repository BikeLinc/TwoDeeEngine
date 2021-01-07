package scene;

import java.awt.Color;

public class Player extends Block{

	private static final long serialVersionUID = 1L;
	
	int jetpackBatteries = 0;

	public Player(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void updateJetpack() {
		if(jetpackBatteries < 21) {
			jetpackBatteries++;
		}
	}
	
	public void useJetpack() {
		if(jetpackBatteries > 0) {
			jetpackBatteries--;
		}
	}
	
	public int getJetpack() {
		return jetpackBatteries;
	}

}
