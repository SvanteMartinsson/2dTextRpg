import java.util.Scanner;

public class Uppgift2 {

	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	 
	        System.out.print(" Mata in två tal: ");
	        int numberOne = input.nextInt();
	        int numberTwo = input.nextInt();
	 
	        try{
	        int ratio = numberOne/numberTwo;
	        System.out.println("Kvoten = " + ratio);
	        }catch(Exception e){
	        	System.out.println("Du kan inte utföra en nolldivision!");
	        }
	 
	    }
	}

