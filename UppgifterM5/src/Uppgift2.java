import java.util.Scanner;

public class Uppgift2 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choise;

        double balance = 0, amount;
        double[] history = new double[100];
        int postNr = 0;

        
  	    do{
      	  System.out.println("VÄLJ ETT ALTRNATIV");
      	  System.out.println("[1] Insättning");
      	  System.out.println("[2] Uttag");
      	  System.out.println("[3] Saldo");
      	  System.out.println("[4] Visa historik");
      	  System.out.println("[5] Avsluta");

      	  choise = input.nextInt();
      	  

      	  switch(choise){
      	  case 1: // Insättning
           	  break;
      	  case 2: // Uttag
           	  break;
      	  case 3: // Visa saldo
          	  break;
      	  case 4: 
      		
      		double tempBalance = 0;
      		 
      		for(int i = 0; i<postNr; i++){
      			tempBalance += history[i];
      		 
      			if(history[i] > 0)
      		System.out.print(history[i] + "\t\t\t\t");
      			else
      		System.out.print("\t\t" + history[i] + "\t\t");
      		 
      			System.out.println(tempBalance);
      		 
      			
      		}
          	
          	  break;
      	  case 5: // Avsluta, Gör inget!!
  	              break;
      	  default:
          	  System.out.println("Felaktigt val("+ choise + ")!");
      	}

  	    }while(choise != 5);
	}

}
