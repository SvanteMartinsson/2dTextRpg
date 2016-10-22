package com.firstengine.core;

import java.awt.Graphics;

public abstract class GameObject {
	
	// This class contains methods and variables that all gameobjects have
	
	protected int x;
	protected int y;
	protected float velX;
	protected float velY;
	private ID id;
	
	public abstract void render(Graphics g);
	public abstract void update();
	
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
	
	public float getVelX(){
		return velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public float getVelY(){
		return velY;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
	
}
