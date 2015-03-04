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
			if (direction[loc].U > direction[loc].D && direction[loc].U > direction[loc].R && direction[loc].U > direction[loc].L){
				num = 0;
			}
			else if (direction[loc].R > direction[loc].U && direction[loc].R > direction[loc].D && direction[loc].R > direction[loc].L){
				num = 1;
			}
			else if (direction[loc].L > direction[loc].U && direction[loc].L > direction[loc].R && direction[loc].L > direction[loc].D){
				num = 2;
			}
			else if (direction[loc].D > direction[loc].U && direction[loc].D > direction[loc].R && direction[loc].D > direction[loc].L){
				num = 3;
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
        	reward = -2;
        }
		
        if (pastDirection == 0){//up
        	direction[pastState].U = pastValue + 0.4 * (reward - pastValue);
        }
        else if (pastDirection ==1){ //right
        	direction[pastState].R = pastValue + 0.4 * (reward - pastValue);
        }
        else if (pastDirection ==2){ //left
        	direction[pastState].L = pastValue + 0.4 * (reward - pastValue);
        }
        else if(pastDirection == 3){ //down
        	direction[pastState].D = pastValue + 0.4 * (reward - pastValue);
        }
        if(pastValue != 2 || pastValue != -2)
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
		g.drawString("U:"+ direction[2].U, 40, 100);
		g.drawString("D:"+ direction[2].D, 40, 115);
		g.drawString("R:"+ direction[2].R, 120, 100);
		g.drawString("L:"+ direction[2].L, 120, 115);
		//state 4
		g.drawString("U:"+ direction[3].U, 180, 235);
		g.drawString("D:"+ direction[3].D, 180, 250);
		g.drawString("R:"+ direction[3].R, 260, 235);
		g.drawString("L:"+ direction[3].L, 260, 250);
		//state 5
		g.drawString("U:"+ direction[4].U, 180, 100);
		g.drawString("D:"+ direction[4].D, 180, 115);
		g.drawString("R:"+ direction[4].R, 260, 100);
		g.drawString("L:"+ direction[4].L, 260, 115);
		//state 6
		g.drawString("U:"+ direction[5].U, 320, 235);
		g.drawString("D:"+ direction[5].D, 320, 250);
		g.drawString("R:"+ direction[5].R, 400, 235);
		g.drawString("L:"+ direction[5].L, 400, 250);
		//state 7
		g.drawString("U:"+ direction[6].U, 320, 175);
		g.drawString("D:"+ direction[6].D, 320, 190);
		g.drawString("R:"+ direction[6].R, 400, 175);
		g.drawString("L:"+ direction[6].L, 400, 190);
		//state 8
		g.drawString("U:"+ direction[7].U, 320, 100);
		g.drawString("D:"+ direction[7].D, 320, 115);
		g.drawString("R:"+ direction[7].R, 400, 100);
		g.drawString("L:"+ direction[7].L, 400, 115);
		//state 9
		g.drawString("U:"+ direction[8].U, 460, 235);
		g.drawString("D:"+ direction[8].D, 460, 250);
		g.drawString("R:"+ direction[8].R, 540, 235);
		g.drawString("L:"+ direction[8].L, 540, 250);
		//state 10
		g.drawString("U:"+ direction[9].U, 460, 175);
		g.drawString("D:"+ direction[9].D, 460, 190);
		g.drawString("R:"+ direction[9].R, 540, 175);
		g.drawString("L:"+ direction[9].L, 540, 190);
		//state 11
		g.drawString("U:"+ direction[10].U, 460, 100);
		g.drawString("D:"+ direction[10].D, 460, 115);
		g.drawString("R:"+ direction[10].R, 540, 100);
		g.drawString("L:"+ direction[10].L, 540, 115);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
