import java.util.Scanner;

public class Uppgift3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int age;
		
		System.out.print("Skriv in din ålder: ");
		age = input.nextInt();
		
		if(age>=35 && age<=50){
			System.out.println("Medelålder");
		}else{
			System.out.println("Du är in i medelåldern");
		}
		

	}

}
