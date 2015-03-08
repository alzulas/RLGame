package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class HUD {
	Window window;
	
	public static float HEALTH = 2;
	
	public static int trial = 1;
	
	public void tick(){
		
		HEALTH = hclamp(HEALTH,  -2, 2);
		
		if (HEALTH == -2 || HEALTH == 2)
		{
			trial++;
		}
		
		
		
	} 
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.black);
		g.drawString ("Current Points = "+HEALTH, 50, 30);
		g.drawString("Trial for this learner: " + trial, 50, 43);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		
	}
	
	public static float hclamp(float var, float min, float max){
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	/*public void radioButton(Graphics g){
    
	
	      mainFrame.setVisible(true);  
	   }*/
		
	/*JRadioButton RLButton = new JRadioButton("Basic RL");
	RLButton.setMnemonic(KeyEvent.VK_B);
	RLButton.setActionCommand("Basic RL");
	RLButton.setSelected(true);		
	
	JRadioButton DPButton = new JRadioButton("Dynamic Programming");
	DPButton.setMnemonic(KeyEvent.VK_B);
	DPButton.setActionCommand("Dynamic Programming");
	
	JRadioButton MCButton = new JRadioButton("Monte Carlo");
	MCButton.setMnemonic(KeyEvent.VK_B);
	MCButton.setActionCommand("Monte Carlo");
	
	JRadioButton TDButton = new JRadioButton("Temporal Difference");
	TDButton.setMnemonic(KeyEvent.VK_B);
	TDButton.setActionCommand("Temporal Difference");
	
	//Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(RLButton);
    group.add(DPButton);
    group.add(MCButton);
    group.add(TDButton);

  //Register a listener for the radio buttons.
    RLButton.addActionListener((ActionListener) this);
    DPButton.addActionListener((ActionListener) this);
    MCButton.addActionListener((ActionListener) this);
    TDButton.addActionListener((ActionListener) this);*/
		
		

	}
	
	


