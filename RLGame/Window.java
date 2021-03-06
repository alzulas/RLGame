package RLGame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Window extends Canvas{

	private static final long serialVersionUID = -8429604735882049130L;

	public Window(int width, int height, String title, Game game){ //make frame of our window

		JFrame frame = new JFrame(title);
		frame.setLayout(new BorderLayout());

		frame.setSize(new Dimension(width, height+50));
		frame.setPreferredSize(new Dimension(width, height+50));
		frame.setMaximumSize(new Dimension(width, height+50));
		frame.setMinimumSize(new Dimension(width, height+50));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes exit button work, stops the thread
		frame.setResizable(false); //No resizing windows
		frame.setLocationRelativeTo(null); //window starts in middle of screen

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(game,BorderLayout.CENTER);
		//panel1.setBackground(Color.BLACK);
		//panel1.add(new JLabel("Foo",JLabel.CENTER));

		panel1.setSize(new Dimension(width, height));
		panel1.setPreferredSize(new Dimension(width, height));
		panel1.setMaximumSize(new Dimension(width, height));
		panel1.setMinimumSize(new Dimension(width, height));

		frame.add(panel1, BorderLayout.CENTER); //puts frame in game	

		//JLabel headerLabel = new JLabel("", JLabel.CENTER); 
		//final JLabel statusLabel = new JLabel("",JLabel.CENTER);

		//headerLabel.setText("Choose a type of learner"); 

		JRadioButton playerButton = new JRadioButton("Human Player", true);
		JRadioButton rlButton = new JRadioButton("Basic RL");
		JRadioButton dpButton = new JRadioButton("Dynamic Programming");
		JRadioButton mcButton = new JRadioButton("Monte Carlo");

		//Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(playerButton);
		group.add(rlButton);
		group.add(dpButton);
		group.add(mcButton);

		JPanel panel2 = new JPanel();
		panel2.add(playerButton);
		panel2.add(rlButton);
		panel2.add(dpButton);
		panel2.add(mcButton);
		panel2.setSize(new Dimension(width,50));
		panel2.setPreferredSize(new Dimension(width, 50));
		panel2.setMaximumSize(new Dimension(width, 50));
		panel2.setMinimumSize(new Dimension(width, 50));
		
		playerButton.addActionListener(game);
		rlButton.addActionListener(game);
	    dpButton.addActionListener(game);
	    mcButton.addActionListener(game);
	    
	    


		frame.add(panel2,BorderLayout.SOUTH);
		
		frame.setVisible(true); //see the frame

		
	}
}



