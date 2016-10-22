package test_test_test;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int a;
		int n;
		int i = 0;
		float p = 1;
		
		a = input.nextInt();
		n = input.nextInt();
		
		if(n<0){
			
			while(i>n){
				p = p*1/a;
				i--;
			}
			System.out.println(p);
			
		}else{
		while(i<n){
			
			p=p*a;
			i++;
		}
		System.out.println(p);
			
		}
		

	}

}
