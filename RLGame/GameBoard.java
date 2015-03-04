package RLGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class GameBoard extends GameObject {

	public GameBoard(int x, int y, ID id) {
		super(x, y, id);		
		
	}
	public void tick() {
		
		
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
		g.drawString("1", 80, 220);
		g.drawString("2", 80, 153);
		g.drawString("3", 80, 86);
		g.drawString("4", 220, 220);
		g.drawString("5", 220, 86);
		g.drawString("6", 360, 220);
		g.drawString("7", 360, 153);
		g.drawString("8", 360, 86);
		g.drawString("9", 500, 220);
		g.drawString("10", 500, 153);
		g.drawString("11", 500, 86);
		
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
