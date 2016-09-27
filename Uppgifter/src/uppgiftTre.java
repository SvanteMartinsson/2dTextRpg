import java.util.Scanner;

public class uppgiftTre {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		double f;
		double c;
		
		System.out.print("Skriv in temperaturen i fahrenhiet: ");
		f = input.nextFloat();
		
		c =  ((f-32.0)*0.56);
		
		System.out.println("Det är " + c + "celsius.");
		

	}

}
