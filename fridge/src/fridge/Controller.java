package fridge;

import java.util.Scanner;

public class Controller {
	
	private int decision;
	private int getInt;
	
	Scanner input = new Scanner(System.in);
	
	public void whatToDo(){
		System.out.println("Quit: 1 Eat a banana: 2 Eat a apple: 3 Visit the store: 4 Display Storage: 5");
		decision = input.nextInt();
		if(decision == 1){
			setDecision(9);
		}else if(decision == 2){
			setDecision(2);
		}else if(decision == 3){
			setDecision(3);
		}else if(decision == 4){
			setDecision(4);
		}else if(decision == 5){
			setDecision(5);
		}else{
			setDecision(10);
		}
	}
	
	private void setDecision(int x){
		getInt = x;
	}
	
	public int getDecision(){
		return getInt;
	}
	
}
