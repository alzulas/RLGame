package RLGame;

import java.awt.Color;
import java.awt.Graphics;


public class HUD {

	public static float HEALTH = 100;
	
	private int trial = 1;
	
	public void tick(){
		
		HEALTH = hclamp(HEALTH,  0, 500);
		
		if (HEALTH == 0 || HEALTH == 500)
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
	
/*	public void radioButton(Graphics g){
		JLabel headerLabel = new JLabel("", JLabel.CENTER); 
		final JLabel statusLabel = new JLabel("",JLabel.CENTER);
		
		headerLabel.setText("Choose a type of learner"); 

		final JRadioButton RLButton = new JRadioButton("Basic RL", true);
	    final JRadioButton DPButton = new JRadioButton("Mango");
	    final JRadioButton MCButton = new JRadioButton("Peer");
	
	      RLButton.setMnemonic(KeyEvent.VK_C);
	      DPButton.setMnemonic(KeyEvent.VK_M);
	      MCButton.setMnemonic(KeyEvent.VK_P);
	
	      RLButton.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {         
	            statusLabel.setText("Apple RadioButton: " 
	            + (e.getStateChange()==1?"checked":"unchecked"));
	         }           
	      });
	
	      DPButton.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {             
	            statusLabel.setText("Mango RadioButton: " 
	            + (e.getStateChange()==1?"checked":"unchecked")); 
	         }           
	      });
	
	      MCButton.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {             
	            statusLabel.setText("Peer RadioButton: " 
	            + (e.getStateChange()==1?"checked":"unchecked"));
	         }           
	      });
	
	      //Group the radio buttons.
	      ButtonGroup group = new ButtonGroup();
	      group.add(RLButton);
	      group.add(DPButton);
	      group.add(MCButton);
	
	      controlPanel.add(RLButton);
	      controlPanel.add(DPButton);
	      controlPanel.add(MCButton);       
	
	      mainFrame.setVisible(true);  
	   }
		*/
		
		
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
	
	


