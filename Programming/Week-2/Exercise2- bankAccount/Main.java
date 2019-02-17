
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BankAccount bankAccountOne = new BankAccount("Kevin", 1, 200);
//		BankAccount bankAccountTwo = new BankAccount("Danny", 2, 500);
		
		//		System.out.println(bankAccountOne.accountNumber());
		//		System.out.println(bankAccountTwo.accountNumber());
		
		//		System.out.println(bankAccountOne.accountNumber());
		
		//		bankAccountTwo.depositMoney(20);
		//		System.out.println(bankAccountTwo);
		
//		Person bobby = new Person("Bobby", 25, 176);
//		BankAccount bankAccountBobby = new BankAccount(bobby, 12, 50);
//		System.out.println(bankAccountBobby);
//		bankAccountBobby.depositMoney(20);
//		System.out.println(bankAccountBobby);
//		bankAccountBobby.withdrawMoney(30);
//		System.out.println(bankAccountBobby);
//		
//		Person timmy = new Person("Timmy", 2, 123);
//		BankAccount bankAccountTimmy = new BankAccount(timmy, 2, 124);
//		System.out.println(bankAccountTimmy);
//		bankAccountTimmy.transferFunds(20, bankAccountBobby);
//		System.out.println(bankAccountTimmy);
//		System.out.println(bankAccountBobby);
		
		Person kevin = new Person("Kevin", 27, 183);
		Person joanna = new Person("Joanna", 33, 123);
		
		BankAccount bankAccountKevin = new BankAccount(kevin, 1, 500);
		BankAccount bankAccountJoanna = new BankAccount(joanna, 1, 250);
		
		bankAccountJoanna.withdrawMoney(20);
		System.out.println(bankAccountJoanna);
		System.out.println(joanna);
		bankAccountJoanna.transferFunds(50, bankAccountKevin);
		System.out.println(bankAccountJoanna);
		System.out.println(bankAccountKevin);
		bankAccountKevin.withdrawMoney(20);
		System.out.println(bankAccountKevin);
		bankAccountKevin.withdrawMoney(550);
		System.out.println(bankAccountKevin);
	}

}
