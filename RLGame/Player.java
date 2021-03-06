package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
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
		//x += velX;
		//y += velY;
		x = Game.clamp(x, 80, 500);
		y = Game.clamp(y, 86, 220);
		
		if (HUD.HEALTH == -2 || HUD.HEALTH == 2)
		{
			x = 80;
			y = 220;
			HUD.HEALTH = 0;
		}
		
		collision();

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
		
		g.drawString("Each move is -.04, Win is +2 and Lose is -2", 20, 400);
		g.drawString("Here you go where you direct, agents will have a 50% chance of going the wrong way", 20, 420);
		
	}
	

}
