package com.shooter.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	int dir;
	
	Handler handler;
	
	int hp = 3;
	
	GameObject shooter;
	
	public Bullet(int x, int y, GameObject shooter, int dir, Handler handler, ID id){
		setX(x+16);
		setY(y+16);
		this.shooter = shooter;
		this.dir = dir;
		this.handler = handler;
		setID(id);
	}
	
	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
		
	}

	
	public void update() {
		if(dir == 1){
			y-=10;
		}
		if(dir == 2){
			y+=10;
		}
		if(dir == 3){
			x-=10;
		}
		if(dir == 4){
			x+=10;
		}
	}
	
	public void collision(){
		
	}


	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 10, 10);
	}

	
	
	
	
}
