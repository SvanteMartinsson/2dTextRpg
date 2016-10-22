package com.firstengine.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject{

	Main game;
	
	Rectangle bRec;
	
	
	public Ball(int x, int y, int velX, int velY, ID id,  Main game, Rectangle bRec){
		
		setX(x);
		setY(y);
		setVelX(velX);
		setVelY(velY);
		setID(id);
		this.game = game;
		this.bRec = bRec;
		
	}
	
	public void render(Graphics g) {
		
		// Draw ball
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
		
		
	}

	
	public void update() {
		
		x += velX;
		y += velY;
		bRec.setLocation(getX(), getY());
		
		
		
	}

}
