import java.util.Scanner;

public class uppgiftTvå {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int x;
		int y;
		int area;
		
		System.out.print("Skriv in bredden: ");
		x = scanner.nextInt();
		System.out.println();
		
		System.out.print("Skriv in höjden: ");
		y = scanner.nextInt();
		
		System.out.println();
		area = x*y;
		
		System.out.print("Arean: ");
		System.out.print(area);
		

	}

}
