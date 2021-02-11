package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import input.UserInput;
import scene.Block;
import scene.Level;

public class Window {
	
	static final String    WINDOW_TITLE = "Oi!";
	static final Dimension WINDOW_SIZE  = new Dimension(640,480);
	static final Dimension SCREEN_SIZE  = Toolkit.getDefaultToolkit().getScreenSize();
	
	JFrame    frame;
	JPanel    panel;
	Level     level;
	Renderer  renderer;
	
	List<Block> scene = new ArrayList<>();
	
	public Window(Level level) {
		this.level    = level;
		this.renderer = new Renderer();
	}

	/*
	 * This Method Creates a New Window To Draw On
	 * Call This Method In The MainGameLoop Class Prior To The Game Loop
	 */
	public void createWindow() { // Creates New Window Instance	
		this.frame = new JFrame(WINDOW_TITLE);
		this.panel = new Panel();
		frame.setSize(WINDOW_SIZE);
		panel.setSize(WINDOW_SIZE);
		frame.setLocation(SCREEN_SIZE.width/2-WINDOW_SIZE.width/2, SCREEN_SIZE.height/2-WINDOW_SIZE.height/2);
		frame.add(panel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	/*
	 * This Method Facilitates All Update Functions (Called Once Per Frame)
	 * Clears Last Frame's Blocks From Memory
	 * Call Renderer's Prepare Method
	 * Gets Updates Blocks in Scene
	 * Repaints Panel
	 */
	public void update() {
		scene.clear();
		renderer.prepare(level);
		scene = renderer.getScene(); 
		panel.repaint();
	}
	
	public static Dimension getWindowSize() {
		return WINDOW_SIZE;
	}
	
	public void addKeyListener(UserInput input) {
		frame.addKeyListener(input);
	}
	

	private class Panel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			for(Block block : scene) {
				g2.setColor(block.getColor());
				g2.fill(block);
			}
		}
	}
}


















