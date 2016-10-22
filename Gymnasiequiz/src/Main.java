import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sam = 0;
		int nat = 0;
		int tek = 0;
		int eko = 0;
		int estet = 0;
		int hum = 0;
		int svar = 0;
		int tot = sam+nat+tek+eko+estet+hum;
		
		
		System.out.println("Är du intresserad av datorer? Ja = 1 Nej = 2");
		svar = input.nextInt();
		if(svar == 1){
			tek++;
		}
		
		System.out.println("Har du bra betyg i NO ämnen? Ja = 1 Nej = 2");
		svar = input.nextInt();
		if(svar == 1){
			nat++;
		}
		
		if(tek>tot-tek){
		System.out.println("Teknik är linjen för dig!");
		}else if(nat>tot-nat){
			System.out.println("Natur är linjen för dig!");
		}else if(tek==nat){
			System.out.println("Teknik eller natur funkar för dig!");
		}
		
		
		

	}

}
