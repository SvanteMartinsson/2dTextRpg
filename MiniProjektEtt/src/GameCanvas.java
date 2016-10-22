import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Motorn i spelet
 * Betrakta detta som en svart låda.
 * 
 * @author Henrik Bygren
 * @since 2016-05-10
 * @see GameUpdate
 */
public class GameCanvas extends Canvas implements KeyListener{
	static final long serialVersionUID = 1L;

	private BufferStrategy backBuffer; 	
	private GameUpdate gm;
	
	private Image shipGreen;
	private Image shipGrey;
	private Image bg;
	private Image bullet;
	private Image flame;
	private int winText = 0;
	private int pHeight = 32;
	private int pWidth = 120;
	private int bHeight = 32;
	private int bWidth  = 32;
	private int bulletX,  bulletY;
	private int WIDTH = 1024;
	private int HEIGHT = 720;
	private int shot = 0;
	private int firstTime = 1;
	private boolean turbo = false;

	private Dimension dimension = new Dimension(WIDTH, HEIGHT);
	
	
	
	

	private boolean gameLoop = true;
	
	private HashMap<Integer,Boolean> keyDownMap = new HashMap<Integer, Boolean>();

	public  GameCanvas(){
		this.gm = new GameUpdate();
		createWindow();
		addKeyListener(this);
		this.createBufferStrategy(2);				
		backBuffer = this.getBufferStrategy();
		
		bullet = new ImageIcon(getClass().getResource("/test.png")).getImage();
		shipGreen = new ImageIcon(getClass().getResource("/shipGreen.png")).getImage();
		shipGrey = new ImageIcon(getClass().getResource("/shipGrey.png")).getImage();
		flame = new ImageIcon(getClass().getResource("/flame.png")).getImage();
		bg = new ImageIcon(getClass().getResource("/bg.png")).getImage();
		

		gameLoop();
	}

	public void createWindow(){
		JFrame window = new JFrame("Air Strike"); 

		setPreferredSize(dimension); 

		window.add(this);			
		window.pack();	
		window.setResizable(false);
		window.setVisible(true); 
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.requestFocus();
	}

	public void gameLoop(){
		while(gameLoop){
			
			update();
			render();
			try{ Thread.sleep(20);}catch(Exception e){};
		}

	}
	

	
	public void update(){
		if(keyDownMap.containsKey(KeyEvent.VK_LEFT))
			gm.leftKey();
		if(keyDownMap.containsKey(KeyEvent.VK_RIGHT))
			gm.rightKey();
		if(keyDownMap.containsKey(KeyEvent.VK_UP))
			gm.upKey();
		
		if(keyDownMap.containsKey(KeyEvent.VK_DOWN))
			gm.downKey();
		
		if(keyDownMap.containsKey(KeyEvent.VK_S))
			gm.sKey();
		
		if(keyDownMap.containsKey(KeyEvent.VK_W))
			gm.wKey();
		
		if(keyDownMap.containsKey(KeyEvent.VK_A))
			gm.aKey();

		if(keyDownMap.containsKey(KeyEvent.VK_D))
			gm.dKey();

		if(keyDownMap.containsKey(KeyEvent.VK_SPACE)){
			shot=1;
		}
		
		if(keyDownMap.containsKey(KeyEvent.VK_SPACE)){

		}
		if(keyDownMap.containsKey(KeyEvent.VK_Q)){
			gm.qKey();
			turbo=true;
		}
		
		
		
		if(keyDownMap.containsKey(KeyEvent.VK_ESCAPE)){
			gameLoop = false;
			System.exit(0);
		}
		
		
	}
	
	public void render(){
		
		Graphics2D g = (Graphics2D) backBuffer.getDrawGraphics();		
		
		g.drawImage(bg, 0, 0,dimension.width,dimension.height, null);
		
		Rectangle b = new Rectangle(bulletX, bulletY, bWidth, bHeight);
		Rectangle p = new Rectangle(gm.greenX, gm.greenY, pWidth, pHeight);
		
		
		
		if(b.intersects(p)){
			winText = 1;
			
		}
		
		
		// Collision detection with window
		if(gm.greyY>HEIGHT-50){
			gm.greyY-=10;
		}else if(gm.greyY<0){
			gm.greyY+=10;
		}else if(gm.greyX>WIDTH-100){
			gm.greyX-=10;
		}else if(gm.greyX<0){
			gm.greyX+=10;
		}
		
		
		// Bullet for grey player
		if(shot==1){
			
			if(firstTime==1){
				bulletY = gm.greyY;
				bulletX = gm.greyX+125;
				firstTime=0;
			}
			
			g.drawImage(bullet, bulletX, bulletY, null);
			bulletX+=50;
			if(bulletX>WIDTH){
				firstTime = 1;
				shot=0;
			}
			
		}
		
		if(turbo==true){
			g.drawImage(flame, gm.greyX-70, gm.greyY, null);
		}
		
		
		if(winText==1){
			g.setColor(Color.white);
			g.drawString("Grey wins", 100, 100);
		}
		g.drawImage(shipGrey, gm.greyX, gm.greyY, null);
		g.drawImage(shipGreen, gm.greenX, gm.greenY, null);
		

		g.dispose();
		backBuffer.show();
	}

	public void keyPressed(KeyEvent e) {
		keyDownMap.put(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		keyDownMap.remove(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args){
		new GameCanvas();
	}
}
