import java.util.Scanner;

public class Uppgift4 {

	public static void main(String[] args) {
		float[] array = new float[1000];
		
		Scanner scanner = new Scanner(System.in);
		
		int counter= 0;
		
		int val;
		
		float inTal = 0;
		
		boolean loop = true;
		
		while(loop){
			System.out.print("Skriv in ett decimaltal: ");
			inTal = scanner.nextFloat();
			array[counter] = inTal;
			counter++;
			
			
			System.out.print("Vill du skriva in ett till tal? ja=1 nej=2 : ");
			val = scanner.nextInt();
			
			if(val == 2)
				loop = false;
		}
		
		for(int i = 0; i<=array.length; i++){
			System.out.println(array[i]);
		}

	}

}
