package calculator;

import java.util.Scanner;

public class Main {
	
	static Scanner userInput = new Scanner(System.in);
	
	

	public static void main(String[] args) {
		float numOne;
		float numTwo;
		float answer = 0;
		String option;
		boolean loop = true;
		
		while(loop==true){
		System.out.print("Addition, Subtraction, Multiplication or Division? (WRITE ONLY IN LOWERCASE!) \n Type:");
		option = userInput.next();
		System.out.print("Enter your first number: ");
		numOne = userInput.nextFloat();
		System.out.print("Enter your second number: ");
		numTwo = userInput.nextFloat();
		if(option.equals("addition")){
			answer = addition(numOne, numTwo);
			getAnswer(answer);
		}else if(option.equals("subtraction")){
			answer = subtraction(numOne, numTwo);
			getAnswer(answer);
		}else if(option.equals("multiplication")){
			answer = multiplication(numOne, numTwo);
			getAnswer(answer);
		}else if(option.equals("division")){
			answer = division(numOne, numTwo);
			getAnswer(answer);
		}else{
			System.out.println("Error! unvalid option chosen!");
		}
		System.out.println("Do you whish to quit? (if so, do /quit but if not, type /continue)\ntype: ");
		option = userInput.next();
		
		if(option.equals("/quit")){
			loop = false;
		}
			
		}
		
		
		
		}
	
	static float addition(float numX, float numY){
		return numX + numY;
	}
	
	static float subtraction(float numOne, float numTwo){
		
		return numOne - numTwo;
	}
	
	static float multiplication(float numOne, float numTwo){
		return numOne * numTwo;
	}
	
	static float division(float numOne, float numTwo){
		return numOne / numTwo;
	}	
	
	static void getAnswer(float finalAnswer){
		System.out.println("The answer is " + finalAnswer);
	}
	

}
