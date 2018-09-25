
public class BankAccount {
//	private String name;
	private Person person;
	private int accountNumber;
	private double balance;
//	private int nextAccountNumber;
	private static int nextAccountNumber = 0;
	//needs to be static
//	 in order for the values to gradually increment. If not made
//	all be zeroed
	
//	public BankAccount(String name, int accountNumber, double 
	public BankAccount(Person person, int accountNumber, double
			balance) {
//		this.name = name;
		this.person = person;
		this.accountNumber = nextAccountNumber;
//		this.balance = 0.0;
		this.balance = balance;
		this.nextAccountNumber++;
	}
	
	public int accountNumber() {
		return this.accountNumber;
	}
	
	public double withdrawMoney(double money) {
		if (this.balance < money) { 
			System.out.println("You do not have enough funds! Do you wish to take out an overdraft?");
		} else  if		
		(this.balance >= money) {
		 balance = this.balance - money;
		} 
		return balance;
	}
	
	public double depositMoney(double money) {
		balance = this.balance + money;
		return  balance;
	}
	
	public void transferFunds(double amountToTransfer, BankAccount bankToReceiveMoney ) {
		this.balance = this.balance - amountToTransfer;
		bankToReceiveMoney.balance = bankToReceiveMoney.balance + amountToTransfer;
	
	}
	
	public String toString() {
		return "Name: " + person.getName() + " - Account Number: " + 
	this.accountNumber + " - Balance: " + this.balance;
	}

}
