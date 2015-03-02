package RLGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//all the key events for player 1
				
				if(key == KeyEvent.VK_UP) tempObject.setY(tempObject.getY() - 67);
				if(key == KeyEvent.VK_RIGHT) tempObject.setX(tempObject.getX() + 140);
				if(key == KeyEvent.VK_LEFT) tempObject.setX(tempObject.getX() - 140);
				if(key == KeyEvent.VK_DOWN) tempObject.setY(tempObject.getY() + 67);
				
			}
 		}
		
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
	}

}
