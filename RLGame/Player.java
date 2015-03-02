package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
		
	}


	public void tick() {
		x += velX;
		y += velY;
		
		
		x = Game.clamp(x, 80, 500);
		y = Game.clamp(y, 86, 220);
		

	}


	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}
	

}
