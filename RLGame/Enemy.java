package RLGame;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject{

	public Enemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}


	public void tick() {
		x += velX;
		y += velY;
	}


	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.drawRect(x, y, 142, 66);
		
		
	}

}
