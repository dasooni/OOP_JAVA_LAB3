package lab3;
public class Customer {
	private String theName;
	private CurrentAccount theCurrentAccount;
	
	public Customer(String arg) {
		theName = arg;
		theCurrentAccount = null;
	}
	
	public String getName() {
		return theName;
	}
	
	public boolean hasCurrentAccount() {
		boolean dummy = false;
		if (theCurrentAccount != null) dummy = true; 
		return dummy;
	}
	
	public void addCurrentAccount(CurrentAccount arg) {
		if (!hasCurrentAccount()) {
			theCurrentAccount = arg;}
	}
	
	public CurrentAccount getCurrentAccount() {
		return theCurrentAccount;
	}
	
	public String toString() {
		String dummy = new String();
		dummy = dummy + "\n*******************************";
		dummy = dummy + "\nCustomer : " + theName;
		if (hasCurrentAccount()) {
			dummy = dummy + "\n Account : " + theCurrentAccount.getAccountNumber();
			dummy = dummy + "\n*******************************";
		}
		
		return dummy;
	}
}
