
public class BankAccount {
	protected String name;
	protected int accountNumber;
	protected double balance;
	protected static int nextAccountNumber;
	protected Person person;
	
//	public BankAccount(String name) {
//		this.name = name;
//		this.balance = 0.0;
//		this.accountNumber = nextAccountNumber;
//		nextAccountNumber++;
//	}
	
	public BankAccount(Person person) {
	this.person
	= person;
	this.balance = 0.0;
	this.accountNumber = nextAccountNumber;
	nextAccountNumber++;
	}

	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		System.out.println("£" + this.balance);
		return this.balance;
	}
	
	public void depositFunds(double funds) {
		this.balance += funds;
		System.out.println("£" + this.balance);
	}
	
	public void withdrawFunds(double funds) {
		this.balance -= funds;
		System.out.println("£" + this.balance);
	}
	
	public void transferFunds(double amountOfFunds, BankAccount accountToDeposit) {
		this.balance -= amountOfFunds;
		accountToDeposit.depositFunds(amountOfFunds);
		System.out.println(this.person.getName() + ": £" + this.balance);
		System.out.println(accountToDeposit.person.getName() + ": £" + accountToDeposit.balance);
	}
	
	public String toString() {
		return this.person.getName() +", " + this.getAccountNumber() + ", £" + this.balance; 
	}
}
