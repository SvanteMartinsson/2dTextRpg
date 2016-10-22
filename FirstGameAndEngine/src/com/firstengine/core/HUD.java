package com.firstengine.core;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	int score1 = 0;
	int score2 = 0;
	int fps;
	Graphics g;
	
	public void displayScore(Graphics g){
		g.setColor(Color.white);
		g.drawString("Score: " + score1, 50, 20);
		g.setColor(Color.white);
		g.drawString("Score: " + score2, 600, 20);
	}
	
	
	public void setFPS(int fps){
		this.fps = fps;
	}
	
	public void displayFPS(Graphics g){
		g.setColor(Color.white);
		g.drawString("FPS: " + fps, 325, 20);
	}
	
	public void setScore1(int score){
		score1 = score;
	}
	
	public int getScore1(){
		return score1;
	}
	
	public void setScore2(int score){
		score2 = score;
	}
	
	public int getScore2(){
		return score2;
	}
	
}
