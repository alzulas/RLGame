package RLGame;

import java.awt.Graphics;

public abstract class GameObject { //boring class. Lots of setters and getters mostly
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getX(){
		return x;
	}
	public int gety(){
		return y;
	}
	public ID getID(){
		return id;
	}
	public int getvelX(){
		return velX;
	}
	public int getvelY(){
		return velY;
	}
}
