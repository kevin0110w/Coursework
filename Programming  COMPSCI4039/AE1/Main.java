import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		CustomerAccount t = new CustomerAccount();
//		CustomerAccount u = t.startTransaction(s);
		orderWine(s, startTransaction(s));
	}
	
	public static CustomerAccount startTransaction(Scanner s) {
		System.out.print("Please enter your name: ");
		String name = s.nextLine();
		System.out.print("Now, please enter your balance in GBP: ");
		double balance = Double.parseDouble(s.nextLine());
		System.out.println("Welcome " + name + ". Your balance is £" + String.format("%.2f", balance) + ".");
		CustomerAccount customer = new CustomerAccount(name, balance);
		return customer;
	}
	
	public static void orderWine(Scanner s, CustomerAccount customer) {
		System.out.print("Please enter wine name: ");
		String wineName = s.nextLine();
		Wine[] wine = new Wine[99999]; // Create a new array that'll contain a list of wine objects. Need to initialise it with a random number
		                               // assume that the user will buy less than 99999 bottles of wine!
		for (int i = 0; i < wine.length; i++) {
//		do {
		if (wineName.equals(" ")) {
			printPrint(wine, customer);
			break;
		}
		System.out.print("Please enter quantity (-ve equals returns): ");
		int quantity = Integer.parseInt(s.nextLine());
		System.out.print("Please enter the price per bottle: £");
		double price = Double.parseDouble(s.nextLine());
		
		if (quantity > 0) {
			customer.buyWine(quantity, price);
		} else {
			customer.returnWine(quantity, price);
		}
		wine[i] = new Wine(wineName, quantity, price); //create a  reference to a new object using user input, that'll be stored in array Wine index 'i'.
		System.out.println(customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getBalance()));
		System.out.print("Please enter wine name: ");
		wineName = s.nextLine();
		}
	}
	
	public static void printPrint(Wine[] wine, CustomerAccount customer) {
		customer.resetBalance();
		String outF = "C:\\Users\\kevin woo hoo\\desktop\\testFile.txt";
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(outF);
			
			String newLine = customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + "\n"; 
			fw.write(newLine);
//		System.out.println(customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getBalance()));
		
			String output = "";
		if (customer.getCounter() <= wine.length) { // if we don't re-size the array so that wine.length == total no. of bottles,
			Wine[] temp = new Wine[customer.getCounter()]; // we'd end up printing a list of 'null' values where the array hasn't been populated
			
			for (int i = 0; i<temp.length; i++) {
				temp[i] = wine[i];
			}
			wine = temp;
			}
		
		for (int i = 0; i < wine.length; i++) {
			if (wine[i].getQuantity() > 0) {
				customer.buyWine(wine[i].getQuantity(), wine[i].getPrice());
			} else {
				customer.returnWine(wine[i].getQuantity(), wine[i].getPrice());
			}
			output = "Wine name: " + wine[i].getWineName() + ", Quantity: " + wine[i].getQuantity() + " units, Total Cost: £" + String.format("%.2f",wine[i].getPrice()) + ", New balance: £" + String.format("%.2f", customer.getBalance())  + "\n";
//			System.out.println(output);
			
			
			fw.write(output);
		}
		}
//			output = "Wine name: " + this.wine[i].name + ", Wine price: " + this.wine[i].price + "\n" + output;
		 catch(IOException e) {
			e.printStackTrace();
	}	finally {
		// Attempt to close the file
		if(fw!=null) {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	}
}
		
		
	
//	public static void writeFile(CustomerAccount customer, ) {
//	
//	String outF = "C:\\Users\\kevin woo hoo\\Desktop";
//	// Create a FileWriter reference
//	FileWriter fw = null;
//	try {
//		// Create a FileWriter object
//		fw = new FileWriter(outF);
//		// Loop over the students
//		for(int i=0;i<nStudents;i++) {
//			/*
//			 * Construct a string for the line
//			 * Note the newline character at the end
//			 */
//			String newLine = 
//					students[i].getName() + "," + 
//					students[i].getGrade() + "\n";
//			// write the line to the file
//			fw.write(newLine);
//		}
//	}catch(IOException e) {
//		e.printStackTrace();
//	}finally {
//		// Attempt to close the file
//		if(fw!=null) {
//			try {
//				fw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//				}
//		}
//		}
//	}

		