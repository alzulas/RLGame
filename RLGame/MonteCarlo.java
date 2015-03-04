package RLGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public class MonteCarlo extends GameObject{

	public MonteCarlo(int x, int y, ID id) {
		super(x, y, id);
		//Initialize:
		//pi <- policy to be evaluated
		//V <- an arbitrary state-value function
		//returns(s) <- an empty list, for all s included in S
		//repeat forever:
			//a)generate an episode using pi
			//b)for each state s appearing in the episode
				//R<-return following the first occurance of s
				//Append R to returns(s)
				//V(s) <-average(returns(s))
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
