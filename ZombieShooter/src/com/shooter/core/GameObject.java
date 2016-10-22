package com.shooter.core;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected boolean UP = false;
	protected boolean DOWN = false;
	protected boolean LEFT = false;
	protected boolean RIGHT = false;
	protected ID id;
	protected int dir;
	
	public abstract void render(Graphics g);
	public abstract void update();
	public abstract Rectangle getBounds();
	
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getX(){
		return x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public int getVelX(){
		return velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public void setLEFT(boolean dir){
		LEFT = dir;
	}
	
	public void setRIGHT(boolean dir){
		RIGHT = dir;
	}
	
	public void setUP(boolean dir){
		UP = dir;
	}
	
	public void setDOWN(boolean dir){
		DOWN = dir;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	
}
