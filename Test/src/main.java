import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		// Moment 3 uppgift 5
		Scanner scanner = new Scanner(System.in);
		
		int x;
		int y;
		int z;
		
		int o;
		
		boolean loop = true;
		
		
		// Fråga Henrik om loop.
		while(loop){
		
		System.out.println("Skriv in 3 heltal: ");
		
		try{
		x = scanner.nextInt();
		y = scanner.nextInt();
		z = scanner.nextInt();
		
		if(x < z && x < y){
			System.out.println("det minsta talet blev " + x);
		}else if(z < x && z < y){
			System.out.println("det minsta talet blev " + z);
		}else if(y < x && y < z){
			System.out.println("det minsta talet blev " + y);
		}
		
		o = 0;
		
		}catch(Exception e){
			System.out.println("Fel inmatning");
			o = 1;
		}
		if(o==0){
			loop = false;
		}
		
	}
	}
	  

}
