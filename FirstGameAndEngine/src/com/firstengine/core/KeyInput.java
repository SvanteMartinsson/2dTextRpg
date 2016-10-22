package com.firstengine.core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	GameObject object;
	Main main;
	HUD hud;
	Ball ball;
	
	public KeyInput(GameObject object, Main main, HUD hud, Ball ball){
		this.object = object;
		this.main = main;
		this.hud = hud;
		this.ball = ball;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		// Input for player1
		if(object.getID() == ID.Player1){
			
			if(key == KeyEvent.VK_W){
			    object.setVelY(-5);
			}
			
			if(key == KeyEvent.VK_S){
				object.setVelY(5);
			}
			
		}
		
		// Input for player2
		if(object.getID() == ID.Player2){
			
			if(key == KeyEvent.VK_UP){
			object.setVelY(-5);
			}
			
			if(key == KeyEvent.VK_DOWN){
				object.setVelY(5);
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			main.isRunning = false; System.exit(0);
		}
		
		if(key == KeyEvent.VK_R){
			hud.setScore1(0);
			hud.setScore2(0);
			ball.setX(200);
			ball.setY(200);
			ball.setVelX(5);
			ball.setVelY(5);
		}
		
	}
	
   public void keyReleased(KeyEvent e){
	   int key = e.getKeyCode();
		
		if(object.getID() == ID.Player1){
			
			if(key == KeyEvent.VK_W){
			object.setVelY(0);
			}
			
			if(key == KeyEvent.VK_S){
				object.setVelY(0);
			}
			
		}
		
		if(object.getID() == ID.Player2){
			
			if(key == KeyEvent.VK_UP){
			object.setVelY(0);
			}
			
			if(key == KeyEvent.VK_DOWN){
				object.setVelY(0);
			}
			
		}
	}

}
