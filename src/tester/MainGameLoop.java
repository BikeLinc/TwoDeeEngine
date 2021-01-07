package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import display.Display;
import input.UserInput;
import scene.Level;

public class MainGameLoop {

	Level level            = new Level();
	UserInput input        = new UserInput();
	Display display = new Display(level);

	private final static int FPS_CAP = 1000 / 60;

	/*
	 * This Method Is Called To Do All Setup Before Game Loop
	 */
	public void start() {
		display.createWindow();
		display.addKeyListener(input);
		loop.start();
	}

	/*
	 * Main Game Loop
	 */
	Timer loop = new Timer(FPS_CAP, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			level.update(input);
			display.update();
		}
	});
}
