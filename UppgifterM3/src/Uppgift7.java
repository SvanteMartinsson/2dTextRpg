import java.util.Random;
import java.util.Scanner;

public class Uppgift7 {

	public static void main(String[] args) {

		Random r = new Random();

		Scanner input = new Scanner(System.in);

		int tärning1;
		int tärning2;

		boolean loop = true;

		boolean loop2 = true;

		int val;

		int pengar = 200;

		int satsning = 0;


		while(loop){

			System.out.println("Du har " + pengar + "kr");

			while(loop2){
				System.out.print("Hur mycket vill du satsa?: ");
				satsning = input.nextInt();
				if(satsning>pengar){
					System.out.println("Så mycket pengar har du inte!");
				}else{
					loop2=false;
				}
			}

			tärning1 = r.nextInt(6) + 1;
			tärning2 = r.nextInt(6) + 1;


			System.out.println("Tärning 1: " + tärning1 + " Tärning 2: " + tärning2);

			if(tärning1 == 1 && tärning2 == 6){
				pengar += 3*satsning;
				System.out.println("Dubbelvinst: " + 3*satsning + "kr!");
			}else if(tärning1 + tärning2 == 7){
				pengar += 2*satsning;
				System.out.println("Vinst: " + 2*satsning + "kr!");
			}else if(tärning1 == tärning2){
				pengar += satsning;
				System.out.println("Par: " + satsning + "kr!");
			}else{
				System.out.println("förlust");
				pengar -= satsning;
			}

			System.out.println("Dina pengar just nu: " + pengar);
			System.out.println("Köra igen? 1=ja    2=nej");
			val = input.nextInt();

			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println();

			if(val == 2){
				loop = false;
			}

			loop2 = true;

		}
	}

}
