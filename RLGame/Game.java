package RLGame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;




public class Game extends Canvas implements Runnable{


	private static final long serialVersionUID = 2263332236676598213L;

	public static final int WIDTH = 640, HEIGHT = WIDTH /12 * 9;
	private Thread thread; //make a thread
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Reinforcement Learning Game!", this);
		
		hud = new HUD();
		r = new Random();
		
		handler.addObject(new GameBoard(30, 70, ID.GameBoard));
		//handler.addObject(new Player(80, 220, ID.Player, handler));
		handler.addObject(new BasicRL(80, 220, ID.BasicRL, handler));		
		handler.addObject(new Enemy(456, 136, ID.Enemy));
		handler.addObject(new Goal(456, 70, ID.Goal));
		handler.addObject(new Block(172, 136, ID.Block));
		
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start(); //start the thread made
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false; //turn off thread
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){ //popular game loop
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 1.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
		hud.tick();

		
	}
	private void render(){ 
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3); //creates 3 buffers
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		
		g.dispose();
		bs.show();
		
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}
