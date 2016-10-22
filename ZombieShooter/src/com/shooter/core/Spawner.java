package com.shooter.core;

public class Spawner {
	
	Handler handler;
	HUD hud;
	Main game;
	
	boolean firstTime = true;
	
	public Spawner(Handler handler, Main game, HUD hud){
		this.handler = handler;
		this.game = game;
		this.hud = hud;
	}
	
	public void spawnZombie(){
		handler.addObject(new Zombie(game.r.nextInt(1024) + 100, game.r.nextInt(768) + 100, game.player, ID.Enemy, handler, game, hud));
	}
	
	public void spawner(){
		
		
		if(firstTime){
			for(int i = 0; i<game.neededKills; i++){
				spawnZombie();
				game.wave = 0;
			}
			firstTime = false;
		}else{
		if(game.wave>0){
		for(int i = 0; i < game.neededKills; i++){
			spawnZombie();
			game.wave= 0;
			System.out.println("Zombie spawned!");
		}
		}
		}
		
		
		
	}
	
	
}
