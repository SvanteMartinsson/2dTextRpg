import java.util.Scanner;

public class uppgiftFem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int perOne;
		int perTwo;
		int perThree;
		float averageAge;
		
		perOne = input.nextInt();
		perTwo = input.nextInt();
		perThree = input.nextInt();
		
		averageAge = (perOne + perTwo + perThree)/3;
		
		System.out.println(averageAge);

	}

}
