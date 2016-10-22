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
	
	int vel = 5;
	
	/**
	 * Anropas då vänster piltangent trycks ner
	 */
	public void leftKey(){
		greenX -= vel;
	}
	
	/**
	 * Anropas då höger piltangent trycks ner
	 */
	public void rightKey(){
		greenX += vel;
	}
	
	/**
	 * Anropas då upp piltangent trycks ner
	 */
	public void upKey(){
		greenY -= vel;
	}
	
	/**
	 * Anropas då ner piltangent trycks ner
	 */
	public void downKey(){
		greenY += vel;
	}
	
	/**
	 * Anropas då A tangenten trycks ner
	 */
	public void aKey(){
		greyX -= vel;
	}
	
	/**
	 * Anropas då D tangenten trycks ner
	 */
	public void dKey(){
		greyX += vel;
	}
	
	/**
	 * Anropas då W tangenten trycks ner
	 */
	public void wKey(){
		greyY -= vel;
	}
	
	/**
	 * Anropas då S tangenten trycks ner
	 */
	public void sKey(){
		greyY += vel;
	}
}
