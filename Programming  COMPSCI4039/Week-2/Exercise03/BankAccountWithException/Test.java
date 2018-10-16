public class Main {

	public static void main(String[] args) {
			Person kevin = new Person("Kevin", 28);
			BankAccount b = new SavingsAccount(kevin, 0.5);
			SavingsAccount k = new SavingsAccount(kevin, 0.5);
			System.out.println(b);
			b.depositFunds(100);
			b.withdrawFunds(150); - throws an exception, not enough funds
			System.out.println(b.getBalance());

  }   
}
