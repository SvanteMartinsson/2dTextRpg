import java.util.Scanner;

public class uppgiftFyra {

	public static void main(String[] args) {
		
		// Skapar en ny Scanner
		Scanner input = new Scanner(System.in);
		
		// Variabler
		int sec;
		int hours;
		int secLeft;
		int min;
		
		System.out.print("Skriv in antalet sekunder: ");
		
		sec = input.nextInt();
		
		// Alla beräkningar
		hours = sec/3600;
		secLeft = sec%3600;
		min = secLeft/60;
		secLeft = secLeft%60;
		System.out.println(sec + " " + hours + " " + min + " " + secLeft);
		
		

	}

}
