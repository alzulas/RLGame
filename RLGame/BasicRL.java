package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.util.Random;

public class BasicRL extends GameObject{

	public static int pastState = 0;
	public static double pastValue = 0.0;
	public static int pastDirection = 0;
	
	Handler handler;
	
	DirectionStruct[] direction = new DirectionStruct[11];
	{
		for(int i=0; i<direction.length; i++){
	        direction[i] = new DirectionStruct();//this will call constructor.
	    }
	}
    
	
	
	public BasicRL(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		
	}

public int location(){
		
		if (x == 80 && y == 220){
			return 0;
		}
		else if (x == 80 && y == 153){
			return 1;
		}
		else if (x == 80 && y == 86){
			return 2;
		}
		else if (x == 220 && y == 220){
			return 3;
		}
		else if (x == 220 && y == 86){
			return 4;
		}
		else if (x == 360 && y == 220){
			return 5;
		}
		else if (x == 360 && y == 153){
			return 6;
		}
		else if (x == 360 && y == 86){
			return 7;
		}
		else if (x == 500 && y == 220){
			return 8;
		}
		else if (x == 500 && y == 153){
			return 9;
		}
		else if (x == 500 && y == 86){
			return 10;
		}
		return 0;
	}
	
	public void tick() {
		
		
		x = Game.clamp(x, 80, 500);
		y = Game.clamp(y, 86, 220);
		
		if (HUD.HEALTH == -2 || HUD.HEALTH == 2)
		{
			x = 80;
			y = 220;
			HUD.HEALTH = 0;
		}
		
		
		// V(s) <- V(s)+alpha[V(s')-V(s)] 
		//value of a state + step size (value of the next state - value of the state)
		// alpha = .4 for stupid learner
		//while(true){
		
		int loc = location();	
		int num = 0;
		
		if(HUD.trial < 20){		
			Random rand = new Random();
	        num = Math.abs(rand.nextInt(4));
		}
		else{
			if (loc == 0)//if loc 0
			{
				if(direction[1].U>direction[3].U){ //and up state > right state
					num = 0; //go up
				}
				else num = 1;  //else go right
			}
			else if (loc == 1){ //if loc 1
				if(direction[0].U>direction[2].U){ //and down state > up state
					num = 3; //go down
				}
				else num = 0; //else go up
			}
			else if (loc == 2){ //if loc 2
				if(direction[1].U>direction[4].U){ //and down state > right state
					num = 3; //go down
				}
				else num = 1; //else go right
			}
			else if (loc == 3){ //if loc 3
				if(direction[0].U>direction[5].U){ //and left state > right state
					num = 2; //go left
				}
				else num = 1; //else go right
			}
			else if (loc == 4){ //if loc 4
				if(direction[2].U>direction[7].U){ //and left state > right state
					num = 2; //go left
				}
				else num = 1; //else go right
			}
			else if (loc == 5){ //if loc 5
				if(direction[3].U>direction[8].U && direction[3].U > direction[6].U){ //and left state > right state and up state
					num = 2; //go left
				}
				if(direction[6].U>direction[8].U && direction[6].U > direction[3].U){ //and up state > right state and left state
					num = 0; //go up
				}
				else num = 1; //else go right
			}
			else if (loc == 6){ //if loc 6
				if(direction[5].U>direction[7].U && direction[5].U > direction[9].U){ //and down state > right state and up state
					num = 3; //go down
				}
				if(direction[7].U>direction[5].U && direction[7].U > direction[9].U){ //and up state > right state and down state
					num = 0; //go up
				}
				else num = 1; //else go right
			}
			else if (loc == 7){ //if loc 7
				if(direction[4].U>direction[7].U && direction[4].U > direction[10].U){ //and left state > right state and down state
					num = 2; //go left
				}
				if(direction[7].U>direction[4].U && direction[7].U > direction[10].U){ //and down state > right state and left state
					num = 3; //go up
				}
				else num = 1; //else go right
			}
			else if (loc == 8){ //if loc 8
				if(direction[5].U>direction[9].U){ //and left state > up state
					num = 2; //go left
				}
				else num = 0; //else go up
			}
			
		}
        double reward = 0;
		
        
        if (num == 0){
        	if (loc == 0 || loc == 1 || loc == 5 || loc == 6 || loc == 8)
        		y = y-67; //up
			HUD.HEALTH -= .04;
			reward = -.04;
        }
        else if (num == 1){
        	if (loc == 0 || loc == 2 || loc == 3 || loc == 4 || loc == 5 || loc == 6 || loc == 7)
        		x = x+140; //right
        	HUD.HEALTH -= .04;
        	reward = -.04;
		}
        else if (num == 2){
        	if (loc == 3 || loc == 4 || loc == 5 || loc == 7 || loc == 8)
        		x = x - 140; //left
			HUD.HEALTH -= .04;
			reward = .04;
        }
        else if (num == 3){
        	if (loc == 1 || loc == 2 || loc == 6 || loc == 7)
        	y = y + 67; //down
        	HUD.HEALTH -= .04;
        	reward = -.04;
        }
        else{
        	x = 80;
        	y = 220;
        }
		
        if (loc == 9)
        {
        	HUD.HEALTH = -2;
        	reward = -2;
        }
        if (loc == 10){
        	HUD.HEALTH = 2;
        	reward = 2;
        }
		
        direction[pastState].U = direction[pastState].U + .04 * (reward - direction[pastState].U);

        if(reward == 2 || reward == -2)
        {
        	direction[loc].U = reward;
        	pastState = 0;
        	pastDirection = 0;
        	pastValue = 0;
        }
        else
        {
        	pastState = loc;
            pastDirection = num;
            pastValue = reward;
        }
        
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		//state 1
		DecimalFormat df = new DecimalFormat("#.##");
		String printValue = df.format(direction[0].U);	 
		g.drawString("U:"+ printValue, 40, 235);
		printValue = df.format(direction[0].D);
		g.drawString("D:"+ printValue, 40, 250);
		printValue = df.format(direction[0].R);
		g.drawString("R:"+ printValue, 120, 235);
		printValue = df.format(direction[0].L);
		g.drawString("L:"+ printValue, 120, 250);
		//state 2
		printValue = df.format(direction[1].U);
		g.drawString("U:"+ printValue, 40, 175);
		printValue = df.format(direction[1].D);
		g.drawString("D:"+ printValue, 40, 190);
		printValue = df.format(direction[1].R);
		g.drawString("R:"+ printValue, 120, 175);
		printValue = df.format(direction[1].L);
		g.drawString("L:"+ printValue, 120, 190);
		//state 3
		printValue = df.format(direction[2].U);
		g.drawString("U:"+ printValue, 40, 100);
		printValue = df.format(direction[2].D);
		g.drawString("D:"+ printValue, 40, 115);
		printValue = df.format(direction[2].R);
		g.drawString("R:"+ printValue, 120, 100);
		printValue = df.format(direction[2].L);
		g.drawString("L:"+ printValue, 120, 115);
		//state 4
		printValue = df.format(direction[3].U);
		g.drawString("U:"+ printValue, 180, 235);
		printValue = df.format(direction[3].D);
		g.drawString("D:"+ printValue, 180, 250);
		printValue = df.format(direction[3].R);
		g.drawString("R:"+ printValue, 260, 235);
		printValue = df.format(direction[3].L);
		g.drawString("L:"+ printValue, 260, 250);
		//state 5
		printValue = df.format(direction[4].U);
		g.drawString("U:"+ printValue, 180, 100);
		printValue = df.format(direction[4].D);
		g.drawString("D:"+ printValue, 180, 115);
		printValue = df.format(direction[4].R);
		g.drawString("R:"+ printValue, 260, 100);
		printValue = df.format(direction[4].L);
		g.drawString("L:"+ printValue, 260, 115);
		//state 6
		printValue = df.format(direction[5].U);
		g.drawString("U:"+ printValue, 320, 235);
		printValue = df.format(direction[5].D);
		g.drawString("D:"+ printValue, 320, 250);
		printValue = df.format(direction[5].R);
		g.drawString("R:"+ printValue, 400, 235);
		printValue = df.format(direction[5].L);
		g.drawString("L:"+ printValue, 400, 250);
		//state 7
		printValue = df.format(direction[6].U);
		g.drawString("U:"+ printValue, 320, 175);
		printValue = df.format(direction[6].D);
		g.drawString("D:"+ printValue, 320, 190);
		printValue = df.format(direction[6].R);
		g.drawString("R:"+ printValue, 400, 175);
		printValue = df.format(direction[6].L);
		g.drawString("L:"+ printValue, 400, 190);
		//state 8
		printValue = df.format(direction[7].U);
		g.drawString("U:"+ printValue, 320, 100);
		printValue = df.format(direction[7].D);
		g.drawString("D:"+ printValue, 320, 115);
		printValue = df.format(direction[7].R);
		g.drawString("R:"+ printValue, 400, 100);
		printValue = df.format(direction[7].L);
		g.drawString("L:"+ printValue, 400, 115);
		//state 9
		printValue = df.format(direction[8].U);
		g.drawString("U:"+ printValue, 460, 235);
		printValue = df.format(direction[8].D);
		g.drawString("D:"+ printValue, 460, 250);
		printValue = df.format(direction[8].R);
		g.drawString("R:"+ printValue, 540, 235);
		printValue = df.format(direction[8].L);
		g.drawString("L:"+ printValue, 540, 250);
		//state 10
		printValue = df.format(direction[9].U);
		g.drawString("U:"+ printValue, 460, 175);
		printValue = df.format(direction[9].D);
		g.drawString("D:"+ printValue, 460, 190);
		printValue = df.format(direction[9].R);
		g.drawString("R:"+ printValue, 540, 175);
		printValue = df.format(direction[9].L);
		g.drawString("L:"+ printValue, 540, 190);
		//state 11
		printValue = df.format(direction[10].U);
		g.drawString("U:"+ printValue, 460, 100);
		printValue = df.format(direction[10].D);
		g.drawString("D:"+ printValue, 460, 115);
		printValue = df.format(direction[10].R);
		g.drawString("R:"+ printValue, 540, 100);
		printValue = df.format(direction[10].L);
		g.drawString("L:"+ printValue, 540, 115);
		
		g.drawString("Basic RL is simply V(s) <- V(s)+alpha[V(s')-V(s)]", 100, 300);
		g.drawString("Explores randomly for 20 trials, then follows learned policy", 100, 320);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
