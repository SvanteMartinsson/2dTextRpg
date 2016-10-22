package com.firstengine.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Rectangle pRec;
	
	public Player(int x, int y, ID id, Rectangle pRec){
		setX(x);
		setY(y);
		setID(id);
		this.pRec = pRec;
	}
	
	public void render(Graphics g) {
		
		// Draw the players
		if(getID() == ID.Player1)
		g.setColor(Color.red);
		
		if(getID() == ID.Player2)
			g.setColor(Color.blue);
		
		
		g.fillRect(x, y, 20, 150);
		
	}
	
	public void update() {
		x += velX;
		y += velY;
		pRec.setLocation(getX(), getY());
		
		// Collision that's unique for the player
		if(y>310){
			y = 310;
		}else if(y<0){
			y = 0;
		}
		
	}
	
	
	
}
