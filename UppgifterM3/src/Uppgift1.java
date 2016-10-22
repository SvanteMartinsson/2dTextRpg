import java.util.Scanner;

public class Uppgift1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		float längd = 0;
		
		System.out.print("Skriv in längd: ");
		
		try{
		längd = input.nextFloat();
		
		if(längd>2){
			System.out.println("basketspelare");
		}else{
			System.out.println("Handbollsspelare");
		}
		
		}catch(Exception e){
			System.out.println("Du kan endast skriva in siffror!");
		}
		
		

	}

}
