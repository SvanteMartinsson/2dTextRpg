/**
 * GameLogic
 * Klassen styr den gröna kvadraten
 * Målet är att krocka med fienden, röd kvadrat.
 * 
 * @author Svante Martinsson
 * @since  17 Oktober 2016
 * @see    GameCanvas
 *
 */
public class GameLogic {

	/**
	 * updateGame
	 * 
	 * Metoden anropas varje gång spelet skall uppdateras.
	 * 
	 * Speciella instruktioner 
	 * game.getMeX() returnerar grön kvadrats x-koordinat
	 * game.getMeY() returnerar grön kvadrats y-koordinat
	 * 
	 * game.getEnemyX() returnerar röd kvadrats x-koordinat
	 * game.getEnemyY() returnerar röd kvadrats y-koordinat
	 * 
	 * @param game referens till spelets grafik och motor
	 */
	public static void updateGame(GameCanvas game){

		/* if(game.getEnemyX() == game.getMeX() && game.getEnemyY() > game.getMeY()){
			game.incY();
		}else if(game.getEnemyX() == game.getMeX() && game.getEnemyY() < game.getMeY()){
			game.decY();
		}else if(game.getEnemyX()>=game.getMeX()){
			game.incX();
		}else{
			game.decX();
		}

		if(game.getEnemyY() == game.getMeY() && game.getEnemyX() > game.getMeX()){
			game.incX();
		}else if(game.getEnemyY() == game.getMeY() && game.getEnemyX() < game.getMeX()){
			game.decX();
		}else if(game.getEnemyY()>=game.getMeY()){
			game.incY();
		}else{
			game.decY();
		}

		 */

		if(game.getEnemyX() > game.getMeX()){
			game.incX();
		}else if(game.getEnemyX() < game.getMeX()){
			game.decX();
		}

		if(game.getEnemyY() > game.getMeY()){
			game.incY();
		}else if(game.getEnemyY() < game.getMeY()){
			game.decY();
		}

	}
}
