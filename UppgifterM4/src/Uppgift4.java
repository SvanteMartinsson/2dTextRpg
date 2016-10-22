
public class Uppgift4 {

	public static void main(String[] args) {
		
		String txt = "Jag heter Olle";
		
		String[] txtArray = txt.split(" ");
		
		
		
		for(int i = 0; i<3; i++){
			System.out.println(txtArray[i]);
		}
		
		System.out.println(txt.substring(11));
		
		System.out.println(txt.substring(5, 9));

	}

}
