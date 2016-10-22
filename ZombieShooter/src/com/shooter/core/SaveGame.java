package com.shooter.core;

import java.io.File;
import java.util.Scanner;

public class SaveGame {
	
	Main game;
	HUD hud;
	private Scanner scanner;
	
	String level;
	String kills;
	
	public SaveGame(Main game, HUD hud){
		this.game = game;
		this.hud = hud;
		
		
	}
	
	public void addRecords(){
		game.saveFile.format("%s %s", hud.level, hud.kills);
	}
	
	public void closeFile(){
		game.saveFile.close();
	}
	
	public void openFile(){
		try{
			scanner = new Scanner(new File("save.txt"));
		}catch(Exception e){
			System.out.println("Could not find file!");
		}
	}
	
	public void readFile(){
		while(scanner.hasNext()){
			try{
			kills = scanner.next();
			level = scanner.next();
			}catch(Exception e){
				System.out.println("No saved file");
			}
		}
	}
	
	
}
