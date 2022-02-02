package lab3;

public class SavingsAccount extends Account {

	public CurrentAccount theCurrentAccount;
	
	
	public SavingsAccount(CurrentAccount arg) {
		super(arg.theCustomer, arg.getBank(),0);
		
		accountType = "Savings";
		
		
	}
	
	public void recieve(double arg) {
		
		theBalance = theBalance + arg;
	}
	
	public double send(double arg) {
		double temp = theBalance;
		
		if( arg > theBalance) {
			theBalance = 0;
			return temp;
		}else {
			theBalance -= arg;
			return arg;
		}
	
	}
}

