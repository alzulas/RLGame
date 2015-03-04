package RLGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DynamicProgramming extends GameObject {

	public DynamicProgramming(int x, int y, ID id) {
		super(x, y, id);
		//input pi, the policy to be evaluated
		//initialize V(s) = 0, for all s included in S+
		//Repeat
			//delta <-0
			//For each s included in S:
				//v <- V(s)
				//V(s)<-sumOfa pi(s,a) sumOfs' Pass'[Rass'+yV(s')]
				//delta<-max(delta,|v-V(s)|)
		//until delta < a small positive number
		//output V =Vpi
		//crap
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
