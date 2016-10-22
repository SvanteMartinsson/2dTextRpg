import java.util.Scanner;

public class Uppgift8 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int år;

		System.out.print("Skriv in ett årtal: ");

		try{
			år = scanner.nextInt();

			if(år % 100 == 0 && år % 400 == 0){

				System.out.println(år + " är ett skottår!");

			}else if(år % 100 != 0 && år % 4 == 0){
				System.out.println(år + " är ett skottår!");
			}else{
				System.out.println(år + " är inte ett skottår!");
			}
		}catch(Exception e){
			System.out.println("Du kan endast mata in heltal!");
		}




	}

}