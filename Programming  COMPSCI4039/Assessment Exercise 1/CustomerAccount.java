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

		String name = (String) returnName(s);
		double balance = returnBalance(s);
				
		CustomerAccount customer = new CustomerAccount(name, balance);
		System.out.println("Welcome " + name + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + ".");
		return customer;
	}
	
	public Wine orderWine(Scanner s, CustomerAccount customer, Wine wine) {
		System.out.print("Please enter wine name: "); //was considering making a is empty exception like the user name section  
		String wineName = s.nextLine();               // but then remembered that is the input we want to end the program!
		do {
		if (wineName.equals(" ")) {
			break;
		}
		int quantity = returnQuant(s); //separate method for user to return quantity of a particular wine bottle in a transaction
		double price = returnPrice(s); //separate method for user to return price per bottle for a particular wine in a transaction
		
		if (quantity > 0) {
			customer.buyWine(quantity, price);
		} else {
			customer.returnWine(quantity, price);
		}
		
		wine.addWine(new Wine(wineName, quantity, price)); //create a reference to a new object using user input, that is stored in array Wine index based on counter within wine class.
		System.out.println(customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getBalance()));
		System.out.print("Please enter wine name: ");
		wineName = s.nextLine();
		}  while (!wineName.equals(" "));
		return wine;
	}
	
	/**
	 * This method returns the users input name only if it isn't blank or contain special chars
	 * @param scanner s
	 * @return name of the customer
	 */
	public String returnName(Scanner s) {
		String name = ""; //I've found that I Need to initialise name otherwise would return null
		System.out.print("Please enter your name: ");    
		do {
			try {
				 name = s.nextLine();
				if (name.equals(" ") || name.isEmpty()) { //if user input is not satisfactory, exception is thrown, otherwise we can safely break out of the loop
					throw new CustomerAccountException ("Name cannot be empty!"); //user is asked to input again therefore skipping break out of do-while loop.
				}
				String test = "`¬!£$%^&*()_-+={}[]:;@\'<,>.?/|\'\"\\\t\r\n\f1234567890"; //String containing special chars which we'll iterate through one by one and check whether
				boolean containsSpecialChar = false; 							//user input name contains the char @ index j.
				for (int i = 0; i<name.length(); i++) {
					for (int j = 0; j<test.length(); j++) {
						if (name.substring(i,i+1).equals(test.substring(j,j+1))) {
							containsSpecialChar = true;
							throw new CustomerAccountException ("Name cannot contain special characters!"); 
						}
					}
				}
				break; // once user enters a correct name, no thrown exceptions, we can safely break out of do-while loop.
		} catch (CustomerAccountException e) {
			System.out.println("You have entered an incorrect name!");
			System.out.println(e);
			System.out.print("Please enter your name again: ");
		} 
		} while (s.hasNextLine());
		return name;
	}
	
	/**
	 * 
	 * @param s
	 * @return initial balance
	 */
    public double returnBalance(Scanner s) {
        double balance = 0;    
        System.out.print("Now, please enter your balance in GBP: ");    
		do {
			try {
				balance = Double.parseDouble(s.nextLine()); //if user input is satisfactory, we can safely break out of the loop, otherwise the exception is thrown and
				break; //user is asked to input again therefore skipping break.
		} catch (NumberFormatException e) {
			System.out.println("You must enter a number! Please try again!");
			System.out.print("Please enter your balance in GBP: ");
		} catch (java.util.InputMismatchException e) {
			System.out.println("You must enter a number! Please try again!");
			System.out.print("Please enter your balance in GBP: ");
			} 
		} while (s.hasNextLine());  
		return balance;
	}
	
    /**
     * 
     * @param s
     * @return quantity of wines bottles for each transaction
     */
	public  int returnQuant(Scanner s){
		int quantity = 0;
		System.out.print("Please enter quantity (-ve equals returns): ");
		do {
			try {
				quantity = Integer.parseInt(s.nextLine());  
				if (quantity == 0) {
					throw new CustomerAccountException("Quantity cannot equal 0!");
				}
				break; //if an exception has not arisen, can safely break
		} catch (NumberFormatException e) {
			System.out.println("You must enter an integer number! Please try again!");
			System.out.print("Please enter quantity (-ve equals returns): ");
		} catch (java.util.InputMismatchException e) {
			System.out.println("You must enter an integer number! Please try again!");
			System.out.print("Please enter quantity (-ve equals returns): ");
		} catch (CustomerAccountException e) { 
			System.out.println(e);
			System.out.println("You must enter an integer number! Please try again!");
			System.out.print("Please enter quantity (-ve equals returns): ");
		}
	} while (s.hasNextLine());
		return quantity;
	}
	
	/**
	 * 
	 * @param s
	 * @return price per bottle of a wine
	 */
	public double returnPrice(Scanner s) {
		double price = 0;
		System.out.print("Please enter the price per bottle: £");
		do {
			try {
				 price = Double.parseDouble(s.nextLine());
				 if (price == 0) {
						throw new CustomerAccountException("Price cannot equal 0!");
					}
					break;
		} catch (NumberFormatException e) {
			System.out.println("You must enter a number! Please try again!");
			System.out.print("Please enter the price per bottle: £");
		} catch (java.util.InputMismatchException e) {
			System.out.println("You must enter a number! Please try again!");
			System.out.print("Please enter the price per bottle: £");
		} catch (CustomerAccountException e) {
			System.out.println(e);
			System.out.println("You must enter a number! Please try again!");
			System.out.print("Please enter the price per bottle: £");
		}
	} while (s.hasNextLine());
		return price;
	}
	
	/*
	 * return initial balance
	 */
	public double getIntitialBalance() { 
		return this.initialBalance;
	}
	
	/*
	 * return current balance after each transaction
	 */
	public double getBalance() { 
		return this.balance;
	}
	
	/** I found that if I tried printing the balance after all transactions, 
	 * the getbalance() would just return the current after all said transactions had been complete
	  rather than go through steps again.
	  */
	public void resetBalance() { 
		this.balance = initialBalance;
	}
	
	/*
	 * return customer's name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	* @Param quantity = no. of bottles of wine, 
	* price  = price per bottle
	* both submitted by user
	*/
	public void buyWine(int quantity, double price) { // calculates amount to take off current balance 
		double purchasePrice = quantity * price;
		this.balance -= purchasePrice;
		this.counter++; //count up the number of wines 'transacted' when creating final copy of array to have length = number of bottles 
	}
	
	/*
	* @Param quantity = no. of bottles of wine, 
	* price  = price per bottle
	* both submitted by user
	*/
	public void returnWine(int quantity, double price) { //calculates amount to add to the customer's balance.
		double returnPrice = (quantity * -1) * (price * 0.8); //quantity is multiplied by -1, ensuring returnPrice is positive number.
		this.balance += returnPrice;
		this.counter++; //count up the number of wines 'transacted' when creating final copy of array to have length = number of bottles 
	}
	
	/**
	 * 
	 * @return number of transactions so far
	 */
	public int getCounter() {
		return this.counter;
	}
}
