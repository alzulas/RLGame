package RLGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH = 100;
	
	public void tick(){
		
		HEALTH = Game.clamp(HEALTH,  0, 100);
	}
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.black);
		g.drawString ("Current Points = "+HEALTH, 50, 30);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	}
}
