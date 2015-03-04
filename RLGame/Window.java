package RLGame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;


import javax.swing.JFrame;


public class Window extends Canvas{

	private static final long serialVersionUID = -8429604735882049130L;
	
	public Window(int width, int height, String title, Game game){ //make frame of our window

		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes exit button work, stops the thread
		frame.setResizable(false); //No resizing windows
		frame.setLocationRelativeTo(null); //window starts in middle of screen
		frame.add(game); //puts frame in game		
		frame.setVisible(true); //see the frame
		
	    game.start(); 
	}
}
		
	
	
	