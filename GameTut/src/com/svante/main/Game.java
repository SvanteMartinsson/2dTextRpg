package com.svante.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 720;
	public static final int HEIGHT= WIDTH/12*9;

	private Thread thread;
	private boolean isRunning = false;

	private Random r;

	private Handler handler;
	private HUD hud;

	public Game(){
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		Window window = new Window(WIDTH, HEIGHT, "Game", this);
		
		hud = new HUD();

		Random r = new Random();
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
		
		
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		
		
		
	}

	public static void main(String args[]){
		new Game();
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}

	public synchronized void stop(){
		try{
			thread.join();
			isRunning = false;
		}catch(Exception e){e.printStackTrace();}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >=1){
				tick();
				delta--;
			}
			
			if(isRunning)
				render();
			
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}
			
			try {
				thread.sleep(10);
			} catch (InterruptedException e) {	
				e.printStackTrace();
				}
		}
		stop();
	}

	private void tick(){
		handler.tick();
		hud.tick();
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return var = max;
		}else if(var<=min){
			return var = min;
		}else{
			return var;
		}
		
	}

	private void render(){
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		buffer.show();
	}




}
