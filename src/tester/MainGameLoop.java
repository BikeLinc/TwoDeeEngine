package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import display.Window;
import input.UserInput;
import scene.FlappyBirdScene;
import scene.Level;
import scene.Scene;

public class MainGameLoop {

	Level level = new Level();
        Scene scene = new FlappyBirdScene(0);
	UserInput input = new UserInput();
	Window window = new Window(level);

	private final static int FPS_CAP = 1000 / 60;

	/*
	 * This Method Is Called To Do All Setup Before Game Loop
	 */
	public void start() {
		window.createWindow();
		window.addKeyListener(input);
                
                scene.setup();
                //
		level.setup();
		loop.start();
	}
        
	/*
	 * Main Game Loop
	 */
	Timer loop = new Timer(FPS_CAP, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			level.update(input);
			window.update();
		}
	});
}
