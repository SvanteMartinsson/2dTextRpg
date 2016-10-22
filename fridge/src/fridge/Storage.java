package fridge;

public class Storage {
	
	public int bananas = 0;
	public int apples = 0;
	private String storageName;
	
	public Storage(int y){
		if(y == 1){
			storageName = "this Storage";
		}
	}
	
	public void displayStorage(){
		System.out.println("Apples: " + apples + " Bananas: " + bananas + " in " + storageName);
	}
	
	public void addFromStore(int x){
		if(x == 1){
			bananas+= 10;
		}else if(x == 2){
			apples+=10;
		}
	}
}
