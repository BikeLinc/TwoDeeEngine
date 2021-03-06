package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInput implements KeyListener {
	
	public boolean wPressed = false;
	public boolean sPressed = false;
	public boolean aPressed = false;
	public boolean dPressed = false;
	
	public boolean isMoveLeftClicked() {
		return aPressed;
	}
	
	public boolean isMoveRightClicked() {
		return dPressed;
	}
	
	public boolean isMoveUpClicked() {
		return wPressed;
	}
	
	public boolean isMoveDownClicked() {
		return sPressed;
	}
		
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				wPressed = true;
				break;
			case KeyEvent.VK_S:
				sPressed = true;
				break;
			case KeyEvent.VK_A:
				aPressed = true;
				break;
			case KeyEvent.VK_D:
				dPressed = true;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				wPressed = false;
				break;
			case KeyEvent.VK_S:
				sPressed = false;
				break;
			case KeyEvent.VK_A:
				aPressed = false;
				break;
			case KeyEvent.VK_D:
				dPressed = false;
				break;
			default:
				break;
		}
	}
}
