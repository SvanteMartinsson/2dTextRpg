/**
 * GameUpdate
 * Klassen uppdaterar spelfigurernas läge
 * De olika metoderna anropas då en specifik tangent trycks ner.
 * 
 * Skriv koden för att få interaktivitet i spelet
 * 
 * @author Henrik Bygren
 * @since  2016-05-10
 * @see    GameUpdate
 *
 */
public class GameUpdate {
	// Koordinater för spelfigurerna
	int greenX = 900, greenY = 200;
	int greyX = 10, greyY = 200;
	int bulletX, bulletY;
	int speed = 5;
	
	/**
	 * Anropas då vänster piltangent trycks ner
	 */
	public void leftKey(){
		greenX -=speed;
	}
	
	/**
	 * Anropas då höger piltangent trycks ner
	 */
	public void rightKey(){
		greenX +=speed;
	}
	
	/**
	 * Anropas då upp piltangent trycks ner
	 */
	public void upKey(){
		greenY -=speed;
	}
	
	/**
	 * Anropas då ner piltangent trycks ner
	 */
	public void downKey(){
		greenY +=speed;
	}
	
	/**
	 * Anropas då A tangenten trycks ner
	 */
	public void aKey(){
		greyX-=speed;
	}
	
	/**
	 * Anropas då D tangenten trycks ner
	 */
	public void dKey(){
		greyX+=speed;
	}
	
	/**
	 * Anropas då W tangenten trycks ner
	 */
	public void wKey(){
		greyY-=speed;
	}
	
	/**
	 * Anropas då S tangenten trycks ner
	 */
	public void sKey(){
		greyY +=speed;
	}
	public void spaceKey(){
		
	}
	public void qKey(){
		speed+=10;
	}
}
