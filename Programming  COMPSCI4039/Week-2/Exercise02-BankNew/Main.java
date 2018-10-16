
public class BankAccountTest {

	public static void main(String[] args) {
			Person kevin = new Person("Kevin", 28);
			BankAccount b = new SavingsAccount(kevin, 0.5);
			SavingsAccount k = new SavingsAccount(kevin, 0.5);
			System.out.println(b);
			System.out.println(k);
			
////		BankAccount bankKevin = new BankAccount("Kevin");
////		BankAccount bankJo = new BankAccount("Jo");
////		
////		System.out.println(bankKevin.getAccountNumber());
////		System.out.println(bankJo.getAccountNumber());
////		
////		System.out.println(bankKevin.getBalance());
////		
////		bankKevin.depositFunds(1000);
////		double bankKev = bankKevin.getBalance();
////		System.out.println(bankKev);
////		
////		bankKevin.withdrawFunds(100);
////		System.out.println(bankKev);
////		
////		System.out.println(bankKevin);
//		
//		Person ted = new Person("Teddy", 28);
//		Person kevin = new Person("Kevin", 20);
//		
//		BankAccount bankTed = new BankAccount(ted);
//		BankAccount bankTeddy = new BankAccount(ted);
//		BankAccount bankKevin = new BankAccount(kevin);
//		BankAccount savingsTed = new SavingsAccount(ted, 20);
//		bankTed.depositFunds(100);
////		bankTed.getBalance();
////		System.out.println(bankTed);
////		System.out.println(bankTeddy);
////		System.out.println(bankKevin);
////		
////		bankTed.transferFunds(50, bankKevin);
////		System.out.println(bankKevin);
////		System.out.println(bankTeddy);
////		System.out.println(bankTed);
//		SavingsAccount savingsKevin = new SavingsAccount(kevin, 5);
//		savingsKevin.depositFunds(1000);
//		savingsKevin.addInterest();
//		savingsKevin.transferFunds(100.05, bankTed);
//		savingsKevin.withdrawFunds(492.12);
//		System.out.println(savingsKevin);
//		System.out.println(bankTed);
	}

}
