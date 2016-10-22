import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Deklarerar variabeln för summan pengar användaren skriver in
		int pengar;
		
		// Deklarerar och tilldelar sedlarna
		int enKrona = 1;
		int femma = 5;
		int tjugo = 20;
		int femtio = 50;
		int hundra = 100;
		int tvåHundra = 200;
		
		// Deklarerar en variabel som används för att kolla antalet sedlar av en sedel som ska användas. Variabeln återanvänds med alla sedlar.
		int antal;
		
		System.out.print("Skriv in en summa pengar: ");
		
		// Tilldelar värdet användaren matat in till variablen pengar
		pengar = input.nextInt();
		
		// Här räknas det ut hur många sedlar och mynt som behövs för summan användaren matade inn. Först hur många 200 lappar, sedan 100 lappar osv..
		int kvar = pengar%tvåHundra;
		pengar = pengar - kvar;
		antal = pengar/tvåHundra;
		System.out.print(antal + " styck(en) 200 lapp(ar), ");
		
		antal = kvar/hundra;
		kvar = kvar%hundra;
		System.out.print(antal + " styck(en) 100 lapp(ar), ");
		
		antal = kvar/femtio;
		kvar = kvar%femtio;
		System.out.print(antal + " styck(en) 50 lapp(ar), ");
		
		antal = kvar/tjugo;
		kvar = kvar%tjugo;
		System.out.print(antal + " styck(en) 20 lapp(ar), ");
		
		antal = kvar/femma;
		kvar = kvar%femma;
		System.out.print(antal + " femmor, ");
		
		antal = kvar/enKrona;
		kvar = kvar%enKrona;
		System.out.print(antal + " enkronor ");
		
	
		

	}

}
