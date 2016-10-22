package fridge;

public class Main {

	public static void main(String[] args) {
		loop();
	}
	
	public static void loop(){
		banana bananaObject = new banana();
		Apple appleObject = new Apple();
		Controller control = new Controller();
		Storage storageObject = new Storage(1);
		Store storeObject = new Store();
		
		boolean loopVar = true;
		
		while(loopVar){
			
			control.whatToDo();
			
			if(control.getDecision() == 2){
				if(storageObject.bananas>0){
				bananaObject.peelBanana();
				bananaObject.eat();
				storageObject.bananas--;
				}else{
					System.out.println("You don't have any bananas!");
				}
			}else if(control.getDecision() == 10){
				System.out.println("That wasn't a choise!");
			}else if(control.getDecision() == 5){
				storageObject.displayStorage();
			}else if(control.getDecision() == 9){
				loopVar = false;
			}else if(control.getDecision() == 4){
				storeObject.buyFood();
				storageObject.addFromStore(storeObject.getDecision());
			}else if(control.getDecision() == 3){
				if(storageObject.apples>0){
					appleObject.eat();
					storageObject.apples--;
				}else{
					System.out.println("You don't have any apples!");
				}
			}
		}
		
		
		
	}

}
