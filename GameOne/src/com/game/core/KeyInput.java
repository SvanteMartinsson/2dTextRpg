package com.game.core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public void KeyInput(KeyEvent e){
		for(int i = 0; i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			int key = e.getKeyCode();
			
			if(tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					tempObject.setVelY(5);
				}
			}
			
		}
	}

}
