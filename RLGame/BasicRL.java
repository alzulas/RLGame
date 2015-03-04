package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.border.MatteBorder;

public class BasicRL extends GameObject{

	Handler handler;
	
	public BasicRL(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		
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
	
	public void tick() {
		
		
		x = Game.clamp(x, 80, 500);
		y = Game.clamp(y, 86, 220);
		
		if (HUD.HEALTH == 0 || HUD.HEALTH == 100)
		{
			x = 80;
			y = 220;
			HUD.HEALTH = 50;
		}
		
		
		// V(s) <- V(s)+alpha[V(s')-V(s)] 
		//value of a state + step size (value of the next state - value of the state)
		// alpha = .4 for stupid learner
		//while(true){
		
			
		Random rand = new Random();
        int num = Math.abs(rand.nextInt(4));
        
        if (num == 0){
        	y = y-67; //up
			HUD.HEALTH -= .04;
        }
        else if (num == 1){
        	x = x+140; //right
        	HUD.HEALTH -= .04;
		}
        else if (num == 2){
        	x = x - 140; //left
			HUD.HEALTH -= .04;
        }
        else if (num == 3){
        	y = y + 67; //down
        	HUD.HEALTH -= .04;
        }
        else{
        	x = 80;
        	y = 220;
        }
        
      //  collision();
		
		
	}

	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
					
			if(tempObject.getID() == ID.Enemy){
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
				}
			}
			if(tempObject.getID() == ID.Goal){
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH += 2;
				}
			}
			if(tempObject.getID() == ID.Block){
				if(getBounds().intersects(tempObject.getBounds())){
					x = 80;
					y = 153;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
