import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;;

public class Main {

	static int[][] gameBoard = new int[3][3];
	static Scanner userInput = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		//initialize game board
		for(int x=0;x<3; x++){
			for(int i=0;i<3;i++){
				gameBoard[x][i] = 0;
			}
		}
		
		gameLoop();
		
		
		

	}
	
	static void gameLoop(){
		boolean loop = true;
		String input;
		
		// The game loop
		while(loop==true){
			
			
		displayBoard();
		playerMove();
		
		if(checkIfWin() == true){
			System.out.print("Do you want to play again? (y/n): ");
			input = userInput.next();
			if(input.equals("n")){
				loop = false;
			}else{
				for(int x=0;x<3; x++){
					for(int i=0;i<3;i++){
						gameBoard[x][i] = 0;
					}
				}
			}
			
		}
		
		if(loop){
			computerMove();
		}
		
		
		
		if(checkIfLose() == true){
			System.out.print("Do you want to play again? (y/n): ");
		input = userInput.next();
		if(input.equals("n")){
			loop = false;
		}else{
			resetBoard();
		}
			
		}
			
		
		}
		
	}
	
	static void playerMove(){
		String playerInput;
		boolean loop = true;
		
		System.out.println();
		
		while(loop == true){
		System.out.print("Your move: ");
		playerInput = userInput.next();
		
		if(playerInput.equals("a1")){
			if(gameBoard[0][0] == 0){
				gameBoard[0][0] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
			
		}else if(playerInput.equals("a2")){
			if(gameBoard[1][0] == 0){
				gameBoard[1][0] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("a3")){
			if(gameBoard[2][0] == 0){
				gameBoard[2][0] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("b1")){
			if(gameBoard[0][1] == 0){
				gameBoard[0][1] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("b2")){
			if(gameBoard[1][1] == 0){
				gameBoard[1][1] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("b3")){
			if(gameBoard[2][1] == 0){
				gameBoard[2][1] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("c1")){
			if(gameBoard[0][2] == 0){
				gameBoard[0][2] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("c2")){
			if(gameBoard[1][2] == 0){
				gameBoard[1][2] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
		}else if(playerInput.equals("c3")){
			if(gameBoard[2][2] == 0){
				gameBoard[2][2] = 1;
				loop = false;
			}else{
				System.out.println("That one is already taken!");
			}
			
		}
		}
		
	}
	
	static boolean checkIfLose(){
		if(gameBoard[0][0] == 2 && gameBoard[0][1] == 2 && gameBoard[0][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[1][0] == 2 && gameBoard[1][1] == 2 && gameBoard[1][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[2][0] == 2 && gameBoard[2][1] == 2 && gameBoard[2][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[0][1] == 2 && gameBoard[2][1] == 2 && gameBoard[2][1] == 2){
			System.out.println("\nComputer wins!");
			displayBoard();
			return true;
		}else if(gameBoard[0][0] == 2 && gameBoard[1][0] == 2 && gameBoard[2][0] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[2][0] == 2 && gameBoard[2][1] == 2 && gameBoard[2][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[0][2] == 2 && gameBoard[1][2] == 2 && gameBoard[2][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[0][0] == 2 && gameBoard[1][1] == 2 && gameBoard[2][2] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else if(gameBoard[0][2] == 2 && gameBoard[1][1] == 2 && gameBoard[2][0] == 2){
			displayBoard();
			System.out.println("\nComputer wins!");
			return true;
		}else{
			return false;
		}
		
	}
	
	static boolean checkIfWin(){
		if(gameBoard[0][0] == 1 && gameBoard[0][1] == 1 && gameBoard[0][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[1][0] == 1 && gameBoard[1][1] == 1 && gameBoard[1][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[2][0] == 1 && gameBoard[2][1] == 1 && gameBoard[2][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[0][1] == 1 && gameBoard[2][1] == 1 && gameBoard[2][1] == 1){
			System.out.println("\nYou win!");
			displayBoard();
			return true;
		}else if(gameBoard[0][0] == 1 && gameBoard[1][0] == 1 && gameBoard[2][0] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[2][0] == 1 && gameBoard[2][1] == 1 && gameBoard[2][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[0][2] == 1 && gameBoard[1][2] == 1 && gameBoard[2][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[0][0] == 1 && gameBoard[1][1] == 1 && gameBoard[2][2] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else if(gameBoard[0][2] == 1 && gameBoard[1][1] == 1 && gameBoard[2][0] == 1){
			displayBoard();
			System.out.println("\nYou win!");
			return true;
		}else{
			return false;
		}
		
	}
	
	static void displayBoard(){
		
		System.out.println("  A B C");
		for(int x=0; x<3; x++){
			if(x>0)
				System.out.println();
			    System.out.print(x+1 + " ");
			for(int i=0; i<3; i++){
				
				if(i>0)
				System.out.print(" ");
				
			System.out.print(gameBoard[x][i]);
			}
		}
	}
	
	static void computerMove(){
		int x;
		int y;
		boolean loop = true;
		
		while(loop == true){
			
			x = 0;
			y = 0;
		
		x = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		y = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		
		
		if(gameBoard[y][x] == 0){
			gameBoard[y][x] = 2;
			loop = false;
		}
		
		}
	}
	
	static void resetBoard(){
		for(int x=0;x<3; x++){
			for(int i=0;i<3;i++){
				if(gameBoard[x][i]>0){
					gameBoard[x][i] = 0;
				}
			}
		}
	}
	

}
