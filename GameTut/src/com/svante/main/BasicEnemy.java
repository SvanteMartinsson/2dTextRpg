package com.svante.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5;
		setVelY(5);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		
		
		if(y <= 0 || y >= Game.HEIGHT-32){
			velY *= -1;
		}
		
		if(x <= 0 || x >= Game.WIDTH-32){
			velX *= -1;
		}
		
		handler.addObject(new Trail(x, y, Color.red, 16, 16, 0.02f, handler, ID.Trail));
		
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		
		
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 16, 16);
	}
	
	
	
}
