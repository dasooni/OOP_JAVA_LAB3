package lab3;

import java.util.*;

public class CurrentAccount extends Account {
	
	private SavingsAccount theSavingsAccount;
	//protected String accountType; 	
	private ArrayList<Transaction> theTransaction;

	public CurrentAccount(Customer arg1, Bank arg2, double arg3) {
		super(arg1,arg2, arg3);
		theSavingsAccount = null;
		accountType = "Current";
		theTransaction = new ArrayList<Transaction>();	
		
	}
	
	public boolean hasSavingsAccount() {
		if(theSavingsAccount == null) {
			
			return false;
		}else
		{
			return true;
		}
	}
	
	public SavingsAccount createSavingsAccount() {
		if(hasSavingsAccount()) {
			System.out.println("savings account exists");
			return null;
		}
		else
		{
		
	theSavingsAccount = new SavingsAccount(this);
	System.out.println("added a savings account to the current account: " + getAccountNumber());
	return theSavingsAccount;	
		}
		
	}
	public Customer getCustomer() {
		return theCustomer;
	}
	
	public Bank getBank() {
		return theBank;
	}
	
	public SavingsAccount getSavingsAccount() {
		return theSavingsAccount;		
	}
	
	
	
	public void send(double arg) {
		if(!hasSavingsAccount()) {
			System.out.println("no savings account");
		}
		else 
		{
			if( arg > theBalance) {
				double res = theBalance;
				theSavingsAccount.recieve(theBalance);
				theBalance = 0;
				System.out.println("no money");
				theTransaction.add(new Transaction(theSavingsAccount.accountNumber, -res, this.theBalance));
			}
			else
			{
				theBalance = theBalance - arg;
				theSavingsAccount.recieve(arg);
				theTransaction.add(new Transaction(theSavingsAccount.accountNumber, -arg, this.theBalance));
			}
			
		}
	
	}
	
	public void recieve(double arg) {
		double temp = theSavingsAccount.send(arg);
		theBalance = theBalance + temp;
		theTransaction.add(new Transaction(theSavingsAccount.getAccountNumber(), temp, theBalance));
		
	}
	
	
	public void recieve(int arg1, double arg2) {

		this.theBalance = theBalance + arg2;
		theTransaction.add(new Transaction(arg1, arg2,theBalance));	
	}
	
	public void send(int arg1, double arg2) {
	
		if(theBank.getAccount(arg1) == null) {
			System.out.println("no such account exists");
		}else if (theBank.getAccount(arg1).equals(theSavingsAccount)){
			System.out.println("that is no a current account");
		}else {
			double amountpaid = arg2;
			if( arg2> theBalance) {
				amountpaid = arg2;
			}
			theBalance =theBalance - amountpaid;
			CurrentAccount dummy = (CurrentAccount) theBank.getAccount(arg1);
			dummy.recieve(accountNumber,arg2);
			theTransaction.add(new Transaction(arg1, -amountpaid,theBalance));
		}	
	}
	
	public String listTransactions() {
		String sum = "transaction summary of the current account: " + accountNumber;
		
		for(int i = 0; i < theTransaction.size(); i++) {
			sum = sum + "\n" + theTransaction.get(i).toString(); 		
		}
		return sum;
	}
		
	public String toString() {
		String result = "\n***************************"; 
		result=result + "\n" + super.toString();
		result= result + "\n**************************"; 
		return result;
	}
}
