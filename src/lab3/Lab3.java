package lab3;

public class Lab3 {

	public static void main(String[] args) {
		
		Bank theBank = new Bank();
		
		theBank.addCustomer("Henry");
		System.out.println(theBank.hasCustomer("Henry"));
		System.out.println(theBank.hasCustomer("John"));
		theBank.addCustomer("John");
		theBank.addCustomer("Matilda");
		System.out.println(theBank.getCustomer("Matilda"));
		
		theBank.addCurrentAccount("Hermine",100.00);
		theBank.addCurrentAccount("Henry", 400.00);
		theBank.addCurrentAccount("John", 400.00);
		theBank.addCurrentAccount("Matilda", 400.00);
		
		theBank.addSavingsAccount("John");
		theBank.addSavingsAccount("Matilda");
		
		System.out.println(theBank.getAccount(1));
		System.out.println(theBank.getAccount(4));
		System.out.println(theBank.getAccount(8));
		
		System.out.println(theBank.getAccount(1));
		theBank.transfer("Henry","external",1000.0);
		System.out.println(theBank.getAccount(1)); //should print savings account
		
		theBank.transfer("Henry","save",1400.0);
		System.out.println(theBank.getAccount(1));
		
		System.out.println(theBank.getAccount(6)); //Henrys save account OK
		theBank.transfer("Henry","withdraw",300.0);
		System.out.println(theBank.getAccount(1));
		theBank.transfer("Henry","withdraw",10000.0);
		System.out.println(theBank.getAccount(1));
		
		theBank.transfer("John","external",1000.0);
		theBank.transfer("Matilda","external",800.0);
		theBank.transfer("John","save",500.0);
		theBank.transfer("John","withdraw",4000.0);
		theBank.transfer("John","Matilda",400.0);
		theBank.transfer("Matilda","John",100.0);
		theBank.transfer("John","Henry",-400.0);
		theBank.transfer("John","save",800.0);
		
		theBank.transactions("Henry");

		theBank.transactions("John");
		
		theBank.transactions("Matilda");
		
		System.out.println(theBank);
		
		System.out.println(theBank.getAccount(2));
		theBank.computeAnnualChange();
		System.out.println(theBank.getAccount(2));
	}

}
