package com.firstengine.core;

import java.awt.Rectangle;

public class CollisionDetection {

	int score1;
	int score2;

	public void collBall(Rectangle pRec, Rectangle bRec, GameObject object){

		// Collision with ball and players
		if(bRec.intersects(pRec)){	
			object.velX *= -1;

			if(object.velX < 0){
				object.velX -= 0.5;
			}else{
				object.velX += 0.5;
			}

			if(object.velY < 0){
				object.velY -= 0.5;
			}else{
				object.velY += 0.5;
			}

		}
	}

	public void collWithWallB(GameObject ball){
		// Collision that's unqiue for the ball
		score1 = 0;
		score2 = 0;

		if(ball.y>400){
			ball.velY *= -1;
		}else if(ball.y<0){
			ball.velY *= -1;
		}
	
		if(ball.x>680){
			ball.velX *= -1;
			score1 = 1;
			ball.x = 200;
			ball.velX = -5;
			ball.velY = 5;

		}else if(ball.x<0){
			ball.velX *= -1;
			score2 = 1;
			ball.x = 200;
			ball.velX = 5;
			ball.velY = -5;
		}
	}

}
