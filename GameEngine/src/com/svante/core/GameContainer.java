package com.svante.core;

public class GameContainer implements Runnable{
	
	private Thread thread;
	private AbstractGame game;
	
	private double frameCap = 1.0/60;
	
	private boolean isRunning = false;
	
	
	public GameContainer(AbstractGame game){
		this.game = game;
	}
	
	public void start(){
		if(isRunning){
			return;
		}
			
			//initialize game components
			
			thread = new Thread(this);
			thread.run();
	}
	
	public void stop(){
		
		if(!isRunning){
			return;
		}
		
		isRunning = false;
		
	}
	
	public void run(){
		isRunning = true;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		while(isRunning){
			
			boolean render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			
			while(unprocessedTime >= frameCap){
				//update game
				unprocessedTime -= frameCap;
				render = true;
			}
			
			if(render){
				//render game
				//update window
				//Clear screen
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		cleanUp();
	}
	
	private void cleanUp(){
		
	}
	
}
