import java.util.Scanner;

public class Uppgift1M4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double[] array = new double[4];
		
		// tar in alla tal
		for(int i = 0; i<=3; i++){
			System.out.println("Skriv in ett tal: ");
			array[i] = input.nextDouble();
		}
		
		// Skriver ut talen baklänges
		for(int i = 3; i>=0; i--){
			System.out.println(array[i]);
		}
		
	}
	
}