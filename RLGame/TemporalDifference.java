package RLGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public class TemporalDifference extends GameObject{

	public TemporalDifference(int x, int y, ID id) {
		super(x, y, id);
		//Initialize V(s) arbitrarily, pi to the policy to be evaluated
		//Repeat(for each episode):
			//Initialize s
			//Repeat (for each step of episode)
				//a<-action given by pi for s
				//Take action a; observe reward, r, and next state, s'
				//V(s)<-V(s)+alpha[r+yV(s')-V(s)]
				//s<-s'
			//Until s is terminal
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
