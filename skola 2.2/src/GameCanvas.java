import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

/**
 * Motorn och grafiken i spelet
 * Betrakta detta som en svart låda.
 * 
 * @author Henrik Bygren
 * @since 2016-05-16
 * @see GameLogic
 */
public class GameCanvas extends Canvas{
	static final long serialVersionUID = 1L;

	private BufferStrategy backBuffer; // Buffert

	/**
	 * Olika möjliga rörelseriktningar
	 */
	private enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
	public Direction enemyDirection; // Rörelseriktningen på röd kvadrat

	private Image bg; // referens till bakgrundsbilden, rutnätet

	private Dimension dimension = new Dimension(800, 600);

	private boolean gameLoop = true;

	private volatile int meX, meY ; // Koordinater för grönkvadrat
	private volatile int enemyX, enemyY; // Koordinater för rödkvadrat

	private int stepEnemy; // Antal steg den röda kvadraten gjort sedan senast rikningsändring

	private int steps = 0, totSteps = 0; // Antal förflyttningar den gröna kvadraten gjort i spelet
	private int nrOfGames = 0; // Antal spel som spelats sedan start.

	/**
	 * Konstruktor
	 */
	public GameCanvas(){
		createWindow();

		this.createBufferStrategy(2);				
		backBuffer = this.getBufferStrategy();	

		bg = new ImageIcon(getClass().getResource("/grid.png")).getImage();

		initGame();
		gameLoop();
	}

	/**
	 * Initierar med startvärden för nytt spel
	 */
	private void initGame(){
		enemyX = 30 + (int)(Math.random()*10);
		enemyY = (int)(Math.random()*30); 
		meX = (int)(Math.random()*10);
		meY = (int)(Math.random()*10);

		changeDirection();

		stepEnemy = 2 + (int)(Math.random()*6);
	}

	/**
	 * Skapar fönstret
	 */
	private void createWindow(){
		JFrame window = new JFrame("Grid Game"); 

		setPreferredSize(dimension); 

		window.add(this);			
		window.pack();	
		window.setResizable(false);
		window.setVisible(true); 

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.requestFocus();
	}

	/**
	 * Spelloopen
	 */
	private void gameLoop(){
		while(gameLoop){
			updateEnemy();
			GameLogic.updateGame(this);

			Graphics2D g = (Graphics2D) backBuffer.getDrawGraphics();		

			g.drawImage(bg, 0, 0,dimension.width,dimension.height, null);

			g.setColor(Color.red);
			g.fillRect(21+19*enemyX, 15+19*enemyY, 17, 18);

			g.setColor(Color.green);
			g.fillRect(21+19*meX, 15+19*meY, 17, 18);

			steps++;			

			g.dispose();
			backBuffer.show();

			hit();
			try{ Thread.sleep(200);}catch(Exception e){};
		}
	}

	/**
	 * Ändrar riktning på den röda kvadraten, enemy
	 */
	private void changeDirection(){
		if(stepEnemy == 0){
			switch((int)(Math.random()*4)){
			case 0: 
				enemyDirection = Direction.LEFT;
				break;
			case 1: 
				enemyDirection = Direction.RIGHT;
				break;
			case 2: 
				enemyDirection = Direction.UP;
				break;
			case 3: 
				enemyDirection = Direction.DOWN;
				break;
			}
			stepEnemy = 2 + (int)(Math.random()*6);
		}else
			stepEnemy--;
	}

	/**
	 * Uppdaterar läget på den röda kvadraten, enemy
	 */
	private void updateEnemy(){
		changeDirection();

		switch (enemyDirection){
		case LEFT: 
			if(enemyX <= 0)
				enemyDirection = Direction.RIGHT;
			else
				enemyX--;
			break;
		case RIGHT:
			if(enemyX >= 39)
				enemyDirection = Direction.LEFT;
			else
				enemyX++;
			break;
		case UP: 
			if(enemyY <= 0)
				enemyDirection = Direction.DOWN;
			else
				enemyY--;
			break;
		case DOWN:
			if(enemyY >= 29)
				enemyDirection = Direction.UP;
			else
				enemyY++;
			break;
		}
	}

	/**
	 * setmetoder
	 */
	public void incX(){
		if(meX < 39)
			meX++;
	}
	public void decX(){
		if(meX > 0)
			meX--;
	}

	public void incY(){
		if(meY < 29)
			meY++;
	}

	public void decY(){
		if(meY > 0)
			meY--;
	}

	public int getMeX(){
		return meX;
	}

	public int getMeY(){
		return meY;
	}

	public int getEnemyX(){
		return enemyX;
	}

	public int getEnemyY(){
		return enemyY;
	}


	/**
	 * Testar kollision
	 * Skriver ut statistik efter träff.
	 */
	private void hit(){
		if(meX == enemyX && meY == enemyY){
			nrOfGames++;
			totSteps += steps;
			JOptionPane.showMessageDialog(this, "Träff efter " + steps + " uppdateringar.\nOmgång: " + nrOfGames
					+ "\nMedel: " +(totSteps/(float)nrOfGames));

			steps = 0;

			initGame();
		}
	}

	/**
	 * Main
	 * Startar spelet!
	 */
	public static void main(String[] args) {
		new GameCanvas();
	}
}
