package com.firstengine.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class Main extends Canvas {

	/**
	 * Author Svante Martinsson
	 */
	private static final long serialVersionUID = -4297212473188496920L;
	private final int WIDTH = 720;
	private final int HEIGHT = 480;

	boolean isRunning = true;

	private BufferStrategy buffer;

	private KeyEvent e;

	private HUD hud = new HUD();

	CollisionDetection collision = new CollisionDetection();

	// Add gameobjects here
	Player playerOne = new Player(20, 100, ID.Player1, new Rectangle(0, 0, 20, 150));
	Player playerTwo = new Player(680, 100, ID.Player2, new Rectangle(0, 0, 20, 150));
	Ball ball = new Ball(100, 240, 6, 6, ID.Ball, this, new Rectangle(0, 0, 32, 32));

	private LinkedList<GameObject> object = new LinkedList<GameObject>();

	private String title = "Pong";

	public Main(){
		// Create window
		Window window = new Window(WIDTH, HEIGHT, title, this);
		this.createBufferStrategy(2);
		buffer = this.getBufferStrategy();
		// Add all gameobjects to object list here
		object.add(playerOne);
		object.add(playerTwo);
		object.add(ball);
		this.addKeyListener(new KeyInput(playerOne, this, hud, ball));
		this.addKeyListener(new KeyInput(playerTwo, this, hud, ball));
		// Start gameloop
		gameLoop();

	}

	public static void main(String[] args) {
		new Main();

	}

	public void gameLoop(){

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while(delta >=1){
				update();
				delta--;
			}

			if(isRunning){
				render();

			}

			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: "+ frames);
				hud.setFPS(frames);
				frames = 0;
			}
		}

	}

	public void render(){

		// Draw background
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// Cycle trough gameobjects in the objectlist and call their render method
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getID() == ID.Player1){
				playerOne.render(g);
			}

			if(object.get(i).getID() == ID.Player2){
				playerTwo.render(g);
			}

			if(object.get(i).getID() == ID.Ball){
				ball.render(g);
			}
		}
		hud.displayScore(g);
		hud.displayFPS(g);
		g.dispose();
		buffer.show();
	}

	public void update(){

		// Cycle trough gameobjects in the objectlist and call their update method
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getID() == ID.Player1){
				playerOne.update();
			}
			if(object.get(i).getID() == ID.Player2){
				playerTwo.update();
			}
			if(object.get(i).getID() == ID.Ball){
				ball.update();
			}
		}

		collision.collBall(playerOne.pRec, ball.bRec, ball);
		collision.collBall(playerTwo.pRec, ball.bRec, ball);
		collision.collWithWallB(ball);
		hud.setScore1(hud.score1 += collision.score1);
		hud.setScore2(hud.score2 += collision.score2);


	}

}
