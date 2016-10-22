package com.shooter.core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class HUD {
	
	
	int width = 200;
	int height = 30;
	
	int level = 1;
	int kills = 0;
	
	String maxLevel;
	String maxKills;
	
	
	public void render(Graphics g){
		
		g.setColor(Color.red);
		g.fillRect(20, 20, 200, 30);
		
		g.setColor(Color.green);
		g.fillRect(20, 20, width, height);
		
		g.setColor(Color.white);
		g.drawString("Level: " + level, 280, 40);
		
		g.setColor(Color.white);
		g.drawString("Kills: " + kills, 280, 60);
		
		g.setColor(Color.white);
		g.drawString("Highscore -  Level: " + maxLevel + " Kills: " + maxKills, 350, 40);
		
		if(width<=0){
			g.setColor(Color.white);
			g.drawString("You died!", 450, 250);
			
		}
	}

}
