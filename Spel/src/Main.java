import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Canvas implements KeyListener {
	
	private int WIDTH = 720;
	private int HEIGHT = 480;
	
	Random ran = new Random();
	
	private BufferStrategy backBuffer;
	
	private int pX = 100;
	private int pY = 100;
	private int pWIDTH = 20;
	private int pHEIGTH = 20;
	private int bX;
	private int bY;
	
	private int lastKey = 1;
	
	private boolean spelText = true;
	
	private boolean replayScreen = false;
	
	private boolean shotOn = false;
	
	private boolean developerMode = false;
	
	private boolean exitGame = false;
	
	private boolean bulletShot = false;
	
	private int eSpeed = 8;
	private int eWIDTH = 20;
	private int eHEIGTH = 20;
	
	private boolean firstTimeEightPoints = true;
	private boolean FTFP = true;
	
	private int eX = 750;
	private int eY = ran.nextInt((450 - 20) + 1);
	
	private int points = 0;
	
	private int hp = 3;
	
	private boolean menu = true;
	
	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	
	private boolean gameRunning = true;
	
	public Main(){
		createWindow();
		init();
		addKeyListener(this);
		while(exitGame == false){
		while(menu == true){
		menuScreen();
		}
		
		gameLoop();
		endingScreen();
		}
	}
	
	public void resetGame(){
		firstTimeEightPoints = true;
		FTFP = true;
		hp = 3;
		points = 0;
		pWIDTH = 20;
		pHEIGTH = 20;
		eSpeed = 8;
		eWIDTH = 20;
		eHEIGTH = 20;
		gameRunning = true;
		pX = 100;
		pY = 100;
		replayScreen = false;
		menu = true;
	}
	
	
	public static void main(String[] args) {
		new Main(); 
	}
	
	public void init(){
		this.createBufferStrategy(2);
		backBuffer = this.getBufferStrategy();
	}
	
	public void menuScreen(){
		Graphics2D g = (Graphics2D) this.getGraphics();
		
		
		if(spelText==true){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString("Spela", 325, 150);
		
		if(spelText==true){
			g.setColor(Color.black);
		}else{
			g.setColor(Color.red);
		}
		g.drawString("Avsluta", 325, 200);
		
	}
	
	public void createWindow(){
		JFrame window = new JFrame();
		window.setTitle("RnB v 0.1");
		window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setSize(new Dimension(WIDTH, HEIGHT));
		window.add(this);
		window.pack();
		window.setResizable(false);
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void endingScreen(){
		Graphics2D g = (Graphics2D) this.getGraphics();
		replayScreen = true;
		
		g.setColor(Color.black);
		g.drawString("Game Over! Press 'R' to play again.", 325, 200);
	}
	
	public void collisionDetection(){
		Rectangle pRec = new Rectangle(pX, pY, pWIDTH, pHEIGTH);
		Rectangle eRec = new Rectangle(eX, eY, eWIDTH, eHEIGTH);
		
		if(pRec.intersects(eRec)){
			eX= 750;
			eY = ran.nextInt((450 - 20) + 1);
			if(points<4){
				eSpeed++;
			}
			
			points++;
		}
		
		if(pX>WIDTH-10){
			pX-=10;
		}
		
	}
	
	public void render(){
		Graphics2D g = (Graphics2D) backBuffer.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		g.drawString("points: " + points, 20, 20);
		
		if(developerMode){
		g.setColor(Color.black);
		g.drawString("speed: " + eSpeed, 300, 20);
		pWIDTH = 20;
		pHEIGTH = 700;
		}
		
		g.setColor(Color.black);
		g.drawString("HP: " + hp, 100, 20);
		
		g.setColor(Color.black);
		g.fillRect(pX, pY, pWIDTH, pHEIGTH);
		
		g.setColor(Color.red);
		g.fillRect(eX, eY, eWIDTH, eHEIGTH);
		
		
		// Fix this
        if(shotOn){
        	bX = pX;
        	bY = pY;
			g.setColor(Color.blue);
			g.fillRect(bX, bY, 10, 10);
			
			if(lastKey == 1){
				bY+=5;	
			}else if(lastKey == 2){
				bY-=5;
			}
			
			if(bY>HEIGHT){
				shotOn = false;
			}
        }
			
			
		
		g.dispose();
		backBuffer.show();
	}
	
	public void update(){
		eX-=eSpeed;
		
		if(moveDown){
			pY+=5;
		}
		if(moveUp){
			pY -= 5;
		}
		
		if(moveLeft){
			pX -= 5;
		}
		if(moveRight){
			pX += 5;
		}
		
		
		
		
		
		
		if(hp<1){
			gameRunning=false;
		}
		
		
		if(eX<0){
			eX= 750;
			eY = ran.nextInt((480 - 0) + 1);
			hp--;
			
		}
		
		if(points==8 && firstTimeEightPoints){
			eWIDTH-=10;
			eHEIGTH-=10;
			firstTimeEightPoints = false;
		}
		
		if(points==14 && FTFP){
			pWIDTH -= 5;
			pHEIGTH -= 5;
			FTFP = false;
		}
	}
	
	public void gameLoop(){
		while(gameRunning){
			
			update();
			render();
			collisionDetection();
			
			
			
			
			
		try{Thread.sleep(20);}catch(Exception e){}
		
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_S){
			moveDown = true;
			lastKey = 2;
			if(menu && spelText){
				spelText=false;
			}
			
		}
		
		if(key == KeyEvent.VK_ENTER){
			if(menu){
				if(spelText==true){
					menu=false;
				}
				if(spelText==false){
					System.exit(0);
				}
			}
		}
		
		if(key == KeyEvent.VK_W){
			moveUp = true;
			lastKey = 1;
			
			if(menu && spelText==false){
				spelText=true;
			}
			
		}
		
		if(key == KeyEvent.VK_A){
			moveLeft = true;
			
		}
		
		if(key == KeyEvent.VK_D){
			moveRight = true;
			
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			gameRunning=false;
			System.exit(0);
		}
		
		if(key == KeyEvent.VK_Q){
			developerMode = true;
		}
		
		if(key == KeyEvent.VK_R){
			if(replayScreen == true){
				resetGame();
			}
		}
		
		if(key == KeyEvent.VK_SPACE){
			shotOn = true;
			bulletShot = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
     int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_S){
			moveDown = false;
			
		}
		if(key == KeyEvent.VK_W){
			moveUp = false;
			
		}
		if(key == KeyEvent.VK_A){
			moveLeft = false;
			
		}
		if(key == KeyEvent.VK_D){
			moveRight = false;
			
		}
		
	}
	
	
}
