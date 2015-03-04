package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class TemporalDifference extends GameObject{

	public TemporalDifference(int x, int y, ID id) {
		super(x, y, id);
		
	}

	public void tick() {
		x = Game.clamp(x, 80, 500);
		y = Game.clamp(y, 86, 220);
		
		if (HUD.HEALTH == 0 || HUD.HEALTH == 4)
		{
			x = 80;
			y = 220;
			HUD.HEALTH = 2;
		}
		
		//Initialize V(s) arbitrarily, pi to the policy to be evaluated
				//Repeat(for each episode):
					//Initialize s
					//Repeat (for each step of episode)
						//a<-action given by pi for s
						//Take action a; observe reward, r, and next state, s'
						//V(s)<-V(s)+alpha[r+yV(s')-V(s)]
						//s<-s'
					//Until s is terminal
	

		int loc = location();	
		
		Random rand = new Random();
        int num = Math.abs(rand.nextInt(4));
        
        
        if (num == 0){
        	if (loc == 1 || loc == 2 || loc == 6 || loc == 7 || loc == 9)
        		y = y-67; //up
			HUD.HEALTH -= .04;
        }
        else if (num == 1){
        	if (loc == 1 || loc == 3 || loc == 4 || loc == 5 || loc == 6 || loc == 7 || loc == 8)
        		x = x+140; //right
        	HUD.HEALTH -= .04;
		}
        else if (num == 2){
        	if (loc == 4 || loc == 5 || loc == 6 || loc == 8 || loc == 9)
        		x = x - 140; //left
			HUD.HEALTH -= .04;
        }
        else if (num == 3){
        	if (loc == 2 || loc == 3 || loc == 7 || loc == 8)
        	y = y + 67; //down
        	HUD.HEALTH -= .04;
        }
        else{
        	x = 80;
        	y = 220;
        }
		
        if (loc == 10)
        {
        	HUD.HEALTH = 0;
        }
        if (loc == 11){
        	HUD.HEALTH = 4;
        }
		
	}

		
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public int location(){
		
		if (x == 80 && y == 220){
			return 1;
		}
		else if (x == 80 && y == 153){
			return 2;
		}
		else if (x == 80 && y == 86){
			return 3;
		}
		else if (x == 220 && y == 220){
			return 4;
		}
		else if (x == 220 && y == 86){
			return 5;
		}
		else if (x == 360 && y == 220){
			return 6;
		}
		else if (x == 360 && y == 153){
			return 7;
		}
		else if (x == 360 && y == 86){
			return 8;
		}
		else if (x == 500 && y == 220){
			return 9;
		}
		else if (x == 500 && y == 153){
			return 10;
		}
		else if (x == 500 && y == 86){
			return 11;
		}
		return 0;
	}
}

