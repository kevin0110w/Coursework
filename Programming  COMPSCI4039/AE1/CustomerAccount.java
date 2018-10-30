import java.util.Scanner;
import java.util.*;

public class CustomerAccount {
	private double balance;
	private String name;
	private int counter = 0;  //count number of bottles transacted 
	private double initialBalance;
	
	public CustomerAccount(String name, double balance) { //create a new customer object for the transaction
		this.name = name;
		this.balance = balance;
		this.initialBalance = balance;
	}
	
	public CustomerAccount() {

	}
	
	public CustomerAccount startTransaction(Scanner s) {
		System.out.print("Please enter your name: ");
		String name = s.nextLine();
		System.out.print("Now, please enter your balance in GBP: ");
		double balance = Double.parseDouble(s.nextLine());
		System.out.println("Welcome " + name + ". Your balance is £" + String.format("%.2f", balance) + ".");
		CustomerAccount customer = new CustomerAccount(name, balance);
		return customer;
	}
	
	public double getIntitialBalance() { //return initial balance
		return this.initialBalance;
	}
	
	public double getBalance() { // return current balance after each transaction
		return this.balance;
	}
	
	public void resetBalance() { // I found that if I tried printing the balance after all transactions, 
		this.balance = initialBalance;  // the getbalance() would just return the current after all said transactions had been complete
	} //rather than go through steps again.
	
	public String getName() {
		return this.name;
	}
	
	/*
	* @Param quantity = no. of bottles of wine, price  = submitted by user
	*/
	public void buyWine(int quantity, double price) { // calculates amount to take off current balance 
		double purchasePrice = quantity * price;
		this.balance -= purchasePrice;
		this.counter++; //count up the number of wines 'transacted' when creating final copy of array to have length = number of bottles 
	}
	
	/*
	* @Param quantity = no. of bottles of wine, price  = submitted by user
	*/
	public void returnWine(int quantity, double price) { //calculates amount to add to the customer's balance.
		double returnPrice = (quantity * -1) * (price * 0.8); //quantity is multipled by -1, ensuring returnPrice is positive number.
		this.balance += returnPrice;
		this.counter++; //count up the number of wines 'transacted' when creating final copy of array to have length = number of bottles 
	}
	
	public int getCounter() {
		return this.counter;
	}
}
