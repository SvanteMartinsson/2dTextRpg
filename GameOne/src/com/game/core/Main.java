package com.game.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {
	
	private Thread thread;
	
	private boolean isRunning = false;
	
	private static final int WIDTH = 720;
	private static final int HEIGHT = 480;
	
	private Handler handler;
	
	public Main(){
		handler = new Handler();
		
		Window window = new Window(WIDTH, HEIGHT, "Pong", this);
		
		handler.addObject(new Player(10, 10, ID.Player));
		
	}

	public static void main(String[] args) {
		new Main();

	}
	
	public void start(){
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public void stop(){
		try {
			thread.join();
			isRunning = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void render(){
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		buffer.show();
		
	}
	
	public void tick(){
		handler.tick();
	}

}
