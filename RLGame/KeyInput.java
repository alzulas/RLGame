package RLGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private HUD hud;
	public static int key;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void setkey(int key){
		this.key = key;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//all the key events for player 1
				
				if(key == KeyEvent.VK_UP){ 
					tempObject.setY(tempObject.getY() - 67);
					HUD.HEALTH -= .04;
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setX(tempObject.getX() + 140);
					HUD.HEALTH -= .04;
				}
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setX(tempObject.getX() - 140);
					HUD.HEALTH -= .04;
				}
				if(key == KeyEvent.VK_DOWN){ 
					tempObject.setY(tempObject.getY() + 67);
					HUD.HEALTH -= .04;
				}
				
			}
 		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}

}
