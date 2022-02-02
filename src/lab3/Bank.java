package lab3;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> theAccounts;
	private ArrayList<Customer> theCustomers;
	
	public Bank() {
		theAccounts = new ArrayList<Account>();
		theCustomers = new ArrayList<Customer>();
	}
	
	public void addCurrentAccount(String arg1, double arg2) {
		if (hasCustomer(arg1)) {
			Customer dummy = getCustomer(arg1);
			if (dummy.hasCurrentAccount()) {
				System.out.println("The customer already has a current account.");
			}
			else {
				CurrentAccount newAccount = new CurrentAccount(dummy,this,arg2);
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("there is no customer with that name.");
		}
	}
	
	public void addSavingsAccount(String arg) {
		
		if((!hasCustomer(arg))) {
			System.out.println("there is no customer with that name");
		}
		else {
			Customer dummy = getCustomer(arg);
			
			if((dummy.getCurrentAccount().hasSavingsAccount())) {
				System.out.println("the costumer already has a savings account");
			}
			else {
				theAccounts.add( dummy.getCurrentAccount().createSavingsAccount());
			}
		}
	  }
	
	public Account getAccount(int arg) {
		Account dummy = null;
		for(int i = 0; i < theAccounts.size(); i++) {
			
		if(theAccounts.get(i).accountNumber == arg) {
			dummy = theAccounts.get(i);
			return dummy;
		}
		
		}
		System.out.println("no such account exist");
		return dummy;
		
	}	
	
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int i = 0; i < theCustomers.size(); i++) {
			if (theCustomers.get(i).getName().equals(arg)) {
				dummy = true;
			}
		}		
		return dummy;
	}
	
	
	public void addCustomer(String arg) {
		if (hasCustomer(arg)) {
			System.out.println("the customer already exists.");
		}
		else {
			theCustomers.add(new Customer(arg));
			System.out.println("customer added.");
		}
	}
	
	
	public Customer getCustomer(String arg) {
		if (!hasCustomer(arg)) return null;
		else {
			Customer dummy;
			int irun = 0;
			do {
				dummy = theCustomers.get(irun);
				irun++;
				
			} while (!dummy.getName().equals(arg));
			return dummy;
		}
	}
	
	
	
	public void computeAnnualChange() {
		for(int i = 0; i <theAccounts.size(); i++) {
			theAccounts.get(i).annualChange();
		}	
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
		Customer dummy = getCustomer(arg1);
		
		if(dummy!=null && getCustomer(arg1).hasCurrentAccount() != false) {
			
			if(arg2.equals("save")) {
				if(!dummy.getCurrentAccount().hasSavingsAccount() ) {
					addSavingsAccount(arg1);
				}
				dummy.getCurrentAccount().send(arg3);
				
			}	
			
			if (arg2.equals("withdraw")) {
			
			if(dummy.getCurrentAccount().hasSavingsAccount() ) {
				dummy.getCurrentAccount().recieve(arg3);	
			}
		}
	
		else if(arg2.equals("external")) {
			
			dummy.getCurrentAccount().recieve(0,arg3);
		}
			
		else if(!(getCustomer(arg2) == null)) {
			dummy.getCurrentAccount().send(getCustomer(arg2).getCurrentAccount().getAccountNumber(), arg3);
		}
	}
		}
				
	public void transactions(String arg) {
		Customer dummy = getCustomer(arg);
		if(dummy == null){
			System.out.println("??");
		}
		else {
		String res = dummy.getCurrentAccount().listTransactions();
		System.out.println(res);
		}
	}
	
	public String toString() {
		String result = "bank information : ";
		double totalValue = 0.0;
		for (int i = 0; i < theAccounts.size(); i++) {
			totalValue = totalValue + theAccounts.get(i).getBalance();
		}
		result = result + "\n number of customers : " + theCustomers.size();	
		result = result + "\n number of accounts : " + theAccounts.size();
		result = result + "\n in controls a total of " + totalValue;
		return result;
	}
}

