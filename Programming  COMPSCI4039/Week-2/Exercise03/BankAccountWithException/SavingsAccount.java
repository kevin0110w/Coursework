public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(Person person, double interestRate) {
		super(person);
		this.interestRate = interestRate;
	}
	
	public void addInterest() {
		this.balance = this.balance + (this.interestRate / 100.0);
	}
	
	public void withdrawFunds(double funds) throws OverdrawnException {
		if (this.getBalance() < funds) {
			double needs  = funds - this.getBalance();
			throw new OverdrawnException(needs);
//			System.out.println("No chance!");
	
		} else {
			this.balance -= funds;
		}
		System.out.println(this.person.getName() + ": £" + this.balance);
	}
	
	public String toString() {
		return "Savings Account: " + this.person.getName() + ": Funds: " + this.getBalance() + " InterestRate: " + this.interestRate;
	}

}
