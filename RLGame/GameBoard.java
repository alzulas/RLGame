package RLGame;

import java.awt.Color;
import java.awt.Graphics;

public class GameBoard extends GameObject {

	public GameBoard(int x, int y, ID id) {
		super(x, y, id);		
		
	}
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.drawRect(x, y, 568, 198);
		g.drawLine(30, 136, 598, 136);
		g.drawLine(30, 202, 598, 202);
		g.drawLine(172, 70, 172, 268);
		g.drawLine(314, 70, 314, 268);
		g.drawLine(456, 70, 456, 268);
		g.fillRect(172, 136, 142, 66);
		g.setColor(Color.green);
		g.fillRect(456, 70, 142, 66);
		g.setColor(Color.red);
		g.fillRect(456, 136, 142, 66);
		g.setColor(Color.white);
		g.drawString("You Win!", 490, 110);
		g.drawString("You Lose!", 490, 170);
		
	}
	
	

}
