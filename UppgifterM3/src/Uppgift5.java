import java.util.Scanner;

public class Uppgift5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		for(int i = 0; i<=2; i++){
			System.out.print("Skriv in ett heltal: ");
			if(i==0){
				x = input.nextInt();
			}else if(i==1){
				y = input.nextInt();
			}else{
				z = input.nextInt();
			}
			
		}
		
		if(x<y && x<z){
			System.out.println(x);
		}else if(y<x && y<z){
			System.out.println(y);
		}else{
			System.out.println(z);
		}
		

	}

}
