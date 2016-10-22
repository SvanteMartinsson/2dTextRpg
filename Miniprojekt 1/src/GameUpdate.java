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
	
	/**
	 * Anropas då vänster piltangent trycks ner
	 */
	public void leftKey(){
		greenX = 10;
	}
	
	/**
	 * Anropas då höger piltangent trycks ner
	 */
	public void rightKey(){
		greenX = 900;
	}
	
	/**
	 * Anropas då upp piltangent trycks ner
	 */
	public void upKey(){
		greenY = 10;
	}
	
	/**
	 * Anropas då ner piltangent trycks ner
	 */
	public void downKey(){
		greenY = 600;
	}
	
	/**
	 * Anropas då A tangenten trycks ner
	 */
	public void aKey(){
		greyX = 10;
	}
	
	/**
	 * Anropas då D tangenten trycks ner
	 */
	public void dKey(){
		greyX = 800;
	}
	
	/**
	 * Anropas då W tangenten trycks ner
	 */
	public void wKey(){
		greyY = 10;
	}
	
	/**
	 * Anropas då S tangenten trycks ner
	 */
	public void sKey(){
		greyY = 550;
	}
}
