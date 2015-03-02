package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Goal extends GameObject {

	public Goal(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}


	public void tick() {
		x += velX;
		y += velY;
	}


	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(x, y, 142, 66);
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 142, 66);
	}

}
