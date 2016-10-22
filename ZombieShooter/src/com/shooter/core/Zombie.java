package com.shooter.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Zombie extends GameObject{
	
	Player target;
	Handler handler;
	
	Random r = new Random();
	
	int speed = r.nextInt(2) + 1;
	
	HUD hud;
	
	Main game;
	
	int hp = 2;
	
	public Zombie(int x, int y, Player target, ID id, Handler handler, Main game, HUD hud){
		this.x = x;
		this.y = y;
		this.target = target;
		setID(id);
		this.handler = handler;
		this.game = game;
		this.hud = hud;
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public void update() {
		
		collision();
		
		if(target.getX()>x){
			x+= speed;
		}
		
		if(target.getX()<x){
			x-= speed;
		}
		
		if(target.getY()>y){
			y+= speed;
		}
		
		if(target.getY()<y){
			y-= speed;
		}
		
		
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(getBounds().intersects(tempObject.getBounds()) && tempObject.getID() == ID.Bullet){
				
				hp--;
				handler.removeObject(tempObject);
				
				if(hp<=0){
					handler.removeObject(this);
					game.kills++;
					hud.kills++;
					
				}
				
			}
			
			if(getBounds().intersects(tempObject.getBounds()) && tempObject.getID() == ID.Enemy){
				if(tempObject.getX() > x){
					x-=speed*2;
				}else if(tempObject.getX() < x){
					x+=speed*2;
				}else if(tempObject.getY() > y){
					y-=speed*2;
				}else if(tempObject.getY() < y){
					y+=speed*2;
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 40, 40);
	}

}
