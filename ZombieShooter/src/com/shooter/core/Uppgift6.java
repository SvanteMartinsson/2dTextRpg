package com.shooter.core;

import java.util.Scanner;

public class Uppgift6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String inOrd = "";
		
		inOrd = scanner.nextLine();
		
		switch(inOrd){
		
		case "hund":
			System.out.println("dog");
			break;
		
		case "musik":
			System.out.println("music");
			break;
		
		case "sol":
			System.out.println("sun");
			break;
		
		case "hej":
			System.out.println("hello");
			break;
		
		case "nej":
			System.out.println("no");
			break;
			
			default: 
				System.out.println(inOrd + " finns inte i lexikonet");
				break;
		
		}

	}

}
