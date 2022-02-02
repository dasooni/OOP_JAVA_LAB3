package lab3;

public class Transaction {
	
	private int otherAccount;
	private double money;
	private double balance;
	
	public Transaction(int arg1, double arg2, double arg3) {
		otherAccount = arg1;
		money = arg2;
		balance = arg3;
	}
	
	public String toString() {
		return String.format("%12s %2d %22s %7f %12s %7f", " account:  ", otherAccount, "transferred money: ", money, "balance: ", balance);
	}

}
