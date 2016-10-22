package fridge;

import java.util.Scanner;

public class Store {

	private int x;
	private int decision;
	
	Scanner input = new Scanner(System.in);
	
	public void buyFood(){
		System.out.println("10 banans: 1 10 apples: 2");
		x = input.nextInt();
		if(x == 1){
			setDecision(1);
		}else if(x == 2){
			setDecision(2);
		}else{
			System.out.println("That's not a choise!");
		}
	}
	
	private void setDecision(int y){
		decision = y;
	}
	
	public int getDecision(){
		return decision;
	}
	
}
