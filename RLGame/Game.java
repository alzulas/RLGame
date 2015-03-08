package RLGame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, ActionListener{


	private static final long serialVersionUID = 2263332236676598213L;

	public static final int WIDTH = 640, HEIGHT = WIDTH /12 * 9;
	private volatile Thread thread=null; //make a thread
	private boolean running = false;
	private volatile GameObject playerHandler = null;
	
	private Handler handler;
	private HUD hud;
	
	
	public Game(){
		new Window(WIDTH, HEIGHT, "Reinforcement Learning Game!", this);
		hud = new HUD();
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		handler.addObject(new GameBoard(30, 70, ID.GameBoard));
		
		//handler.addObject(new TemporalDifference(80, 220, ID.TemporalDifference));
		playerHandler=new Player(80, 220, ID.Player, handler);
		handler.addObject(playerHandler);
		handler.addObject(new Enemy(456, 136, ID.Enemy));
		handler.addObject(new Goal(456, 70, ID.Goal));
		handler.addObject(new Block(172, 136, ID.Block));
				
	}
	
	void addPlayer(int choice)
	{
		if (choice == 0){
			playerHandler=new Player(80, 220, ID.Player, handler);
		}
		if (choice == 1){
			playerHandler=new BasicRL(80, 220, ID.BasicRL, handler);
		}
		if (choice == 2){	
			playerHandler=new DynamicProgramming(80, 220, ID.DynamicProgramming);
		}
		if (choice == 3){
			playerHandler=new MonteCarlo(80, 220, ID.MonteCarlo);
		}
		handler.addObject(playerHandler);
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		running=true;
		thread.start(); //start the thread made
		//running = true;
	}
	
	public synchronized void stop(){
		try{
			running=false;
			System.out.println("interrupting thread");
			thread.interrupt();
			System.out.println("after interrupting thread");
			//running = false; //turn off thread
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){ //popular game loop
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 5.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(!Thread.currentThread().isInterrupted())
		{
			synchronized (this) { if (!running) { return; } }
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				synchronized (this) { if (!running) { return; } }
				tick();
				delta--;
			}
			//if(running)
			//System.out.println(".");
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		System.out.println("!!!!!!!!!!!Exiting game loop!!!!!!!!!!!!!\n\n\n");
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
		
		//this.playerHandler.render(g);
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
		Game g=new Game();
		g.start();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("GOT ACTION=|"+e.getActionCommand()+"|");
		handler.removeObject(playerHandler);
		if (e.getActionCommand().equalsIgnoreCase("Player")){
			addPlayer(0);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Basic RL")){
			addPlayer(1);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Dynamic Programming")){
			addPlayer(2);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Monte Carlo")){
			addPlayer(3);
		}
//		//new Game();
//		System.out.println("before stop");
//		//this.stop();
//		System.out.println("after stop");
//		this.start();
//		System.out.println("after start");
	}
	
}
