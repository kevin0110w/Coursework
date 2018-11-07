import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.util.Scanner;

public class Wine {
	private String name;
	private int quantity;
	private double price;
	private Wine[] wine; 
	private int counter;
	private final static int BOTTLES = 999;
	
	/**
	 * To construct a new wine object per transaction. This will be entered into the array.
	 * @param name of the wine that user has input
	 * @param quantity of the wine that user has input
 	 * @param price per bottle of wine that user has input
	 */
	public Wine(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	/*
	 * To construct a wine object with an array as an instance variable with a fixed number of indexes
	 * Rather than hard coding the number of indexes, I use a constant but assume that the user is buying 999 or less bottles of wine during this situation
	 * The 'counter' field counts up no. of wine purchased and is used so that when the user buys wines, each is added into the array in successive indexes without any gaps. 
	 */ 
	public Wine() {
		this.wine = new Wine[BOTTLES]; 
		this.counter = 0; 
	}
	/*
	 * Returns the name of the bottle of wine - needed in output file
	 */
	public String getWineName() {
		return this.name;
	}
	
	/*
	 * Returns the number of units / bottles ordered - needed in the output file
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	
	/*
	 * This method returns the price per bottle - needed in the output file
	 */
	public double getPricePerBottle() {
		return this.price;
	}
	
	/*
	 * This method returns the total cost for the transaction - needed in the output file
	 */
	public double getTotalCostPerOrder() {
		return this.price * this.quantity;
	}
	
	
	public void addWine(Wine newWine) {
		if (this.counter == this.wine.length) { // condition checks whether we have room, i.e. fillable space or total number of orders = length - 1).
			expandArray();
		}
		
		this.wine[this.counter] = newWine; // since arrays are 0 index, first wine object will be added to 0th index, counter
//		has been initialised to 0 and counts up with each addition, ensuring every other wine object will be added to the next slot sequentially
		//providing user keeps entering wines
		this.counter++;
	}
	
	/*
	 * This method expands the array by one in case we need to grow the size of the current array, i.e. user initially orders more than 999 times!
	 */
	public void expandArray() {
		Wine[] temp = new Wine[this.counter + 1];
		for (int i = 0; i < this.counter; i++) {
			temp[i] = this.wine[i];
		}
		this.wine = temp;
	}
	
	/**
	 * 
	 * @param customer
	 * @param wine
	 * @return re-sized wine array to match number of orders Customer has made
	 */
	public Wine[] resizeArray(CustomerAccount customer, Wine[] wine) {
		if (customer.getCounter() <= this.wine.length) { // if we don't re-size the array so that wine.length == total no. of bottles,
			Wine[] temp = new Wine[customer.getCounter()]; // we'd end up printing a list of 'null' values where the array hasn't been populated
			
			for (int i = 0; i<temp.length; i++) {
				temp[i] = this.wine[i];
			}
			wine = temp;
			}
		return wine;
	}
	
	/**
	 * I used the following method to test  expandArray() worked!
	 */
	public void printArray() {
		int number = 0;
		for (int i = 0; i < this.wine.length; i++) {
			System.out.println(this.wine[i].getWineName());
			number++;
		}
		System.out.println(number); //get an idea how many indexes are filled
	}
	
	public void print(CustomerAccount customer, Scanner s) {
		customer.resetBalance(); //found if I don't reset the balance, it would just keep showing the value of the user's final balance over and over again after they'd gone through all the transactions
		// in the output text value
		FileWriter fw = null;
		boolean writable = false;
		String	outputFile = "statement.txt";
			while (!writable) {	
			try {
				//outputFile = s.nextLine(); // had originally intended on asking the user to enter their own directory but this has been commented out following Simon's recent email. 
				fw = new FileWriter(outputFile);
				String newLine = customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + "\n"; 
				fw.write(newLine);
				String output = "";
				wine = resizeArray(customer, wine); //must resize array if array is not filled up otherwise we would throw a null pointer exception
			
				for (int i = 0; i < wine.length; i++) { //ensuring we get the correct running balance for printing
					if (wine[i].getQuantity() > 0) {
						customer.buyWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
					} else {
						customer.returnWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
					}
					output = "Wine name: " + wine[i].getWineName() + "(£" + String.format("%.2f", wine[i].getPricePerBottle()) + "), Quantity: " + wine[i].getQuantity() + " units, Total Cost: £" + String.format("%.2f",wine[i].getTotalCostPerOrder()) + ", New balance: £" + String.format("%.2f", customer.getBalance())  + "\n";
					fw.write(output);
			}
				writable = true;  // if user gets to this stage without an exception been thrown, can safely exit by setting the while loop condition to not true = false.
//		}	catch (FileNotFoundException e) {  // FNF is a type of IO Exception.. don't need to catch a FNF exception therefore
//				System.out.println("Not able to write to file. Caught File Not Found Exception: " + e.getMessage());
//				System.out.println("Please type location and file name where you'd like to store file output: ");
		}	catch(IOException e) {
				System.out.println("Not able to write to file. Caught IOException: " + e.getMessage());
				System.out.println("Please type location and file name where you'd like to store file output: ");
				outputFile = s.nextLine(); // just in case user gave the wrong filename to the filewriter, they can enter an alternative filepath
		 } finally {
			if (fw!=null) {
				try {
					System.out.println("Transaction Ended");
					fw.close();
				} catch (IOException e) {
					System.out.println("Caught IO Exception: " + e.getMessage());
					//not too concerned about catching this one as catch block in the earlier while loop ensures that we get a valid directory/file
					//so filewriter should always be opened.
					}
				}
		 	}	
		}
	}
}
/** Following methods were used to test whether user had input a writable path and whether there existed a file of the same name.
 They are omitted from the final program as they didn't work!
 
	public void print(CustomerAccount customer, Scanner s) {
		customer.resetBalance(); //found if I don't reset the balance, it would just keep showing the value of the user's final balance over and over again after they'd gone through all the transactions
		// in the output text value
		String outputFile = "C:\\Users\\kevin woo hoo\\desktop\\statement.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile);
			String newLine = customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + "\n"; 
			fw.write(newLine);
			String output = "";
			wine = resizeArray(customer, wine);
			for (int i = 0; i < wine.length; i++) {
				if (wine[i].getQuantity() > 0) {
					customer.buyWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
				} else {
					customer.returnWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
				}
				output = "Wine name: " + wine[i].getWineName() + "(£" + String.format("%.2f", wine[i].getPricePerBottle()) + ") , Quantity: " + wine[i].getQuantity() + " units, Total Cost: £" + String.format("%.2f",wine[i].getTotalCostPerOrder()) + ", New balance: £" + String.format("%.2f", customer.getBalance())  + "\n";
				fw.write(output);
				}
		}
		
		/
		/*
		 *
		boolean isRegularExecutableFile = true;
		System.out.println("Please enter the location where you'd like to store the output file and its name: ");
		while (isRegularExecutableFile) {
			try {
			String outF = s.nextLine();
			Path file = Paths.get(outF);
			isRegularExecutableFile = isWritable(file);
			if (isRegularExecutableFile) { // confirms user input correct path location
				if (doesFileExists(file)) {//if isRegularExecutableFile remains true after isWritable(Path path), we are confident the input path //is sound and can safely break out of the while loop and write to the input path directory
			System.out.println("File already exists. Do you wish to overwrite (y/n)?");
			 String command = s.nextLine();
			 if (command.equals("n")) {
				 outF = inputPath(s);
			 } else {
				 outF = inputPath(s);
			 }
				} 
			fw = new FileWriter(outF);
			String newLine = customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + "\n"; 
			fw.write(newLine);
			String output = "";
		
			if (customer.getCounter() <= this.wine.length) { // if we don't re-size the array so that wine.length == total no. of bottles,
			Wine[] temp = new Wine[customer.getCounter()]; // we'd end up printing a list of 'null' values where the array hasn't been populated
			
			for (int i = 0; i<temp.length; i++) {
				temp[i] = this.wine[i];
			}
			this.wine = temp;
			}
 		
			for (int i = 0; i < this.wine.length; i++) {//go through each index in the array one by one ensuring 
			if (this.wine[i].getQuantity() > 0) { // this.balance is set to the correct value after eahc transaction and can print the correct balance values later.
				customer.buyWine(this.wine[i].getQuantity(), this.wine[i].getPricePerBottle());
			} else {
				customer.returnWine(this.wine[i].getQuantity(), this.wine[i].getPricePerBottle());
			}
			output = "Wine name: " + this.wine[i].getWineName() + "(£" + String.format("%.2f", this.wine[i].getPricePerBottle()) + "), Quantity: " + this.wine[i].getQuantity() + " units, Total Cost: £" + String.format("%.2f",this.wine[i].getTotalCostPerOrder()) + ", New balance: £" + String.format("%.2f", customer.getBalance())  + "\n";
//			System.out.print(output);
			fw.write(output);
//			if (isRegularExecutableFile) {
//				if (doesFileExists(file)) {//if isRegularExecutableFile remains true after isWritable(Path path), we are confident the input path //is sound and can safely break out of the while loop and write to the input path directory
//			System.out.println("File already exists. Do you wish to overwrite (y/n)?");
//			 String command = s.nextLine();
//			 if (command.equals("y")) 
//				break; 
//			 else {
//				 inputPath(s);
//			 }
				 } 
			 }
			} 
		 catch(IOException e) {
			System.out.println("You've entered an incorrect location. Please correctly specify location and output name file: ");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally { 
		}
			if (fw!=null) {
			try {
				System.out.println("Closing PrintWriter");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace(); //not sure how you could catch this type of exception
				}
				}
			}
		}
	/**
	 * 
	 * Eventually became even more complicated and chose to bypass this.
	 * @param path which has been entered by user, we'll check that it is possible to write the output to this path
	 * @return true or false depending whether it is possible to write and vice versa.
	 
	public boolean isWritable(Path path) {
		boolean isRegularExecutableFile = false;
		if (Files.isWritable(path)) {
			isRegularExecutableFile = true;
		} else {
			isRegularExecutableFile = false;
		}
		return isRegularExecutableFile;
	}
	
	public boolean doesFileExists(Path path) {
		boolean doesFileExists = true;
		if (Files.exists(path)) {
			doesFileExists = true;
		} else {
			doesFileExists = false;
		}
		return doesFileExists;
	}
	
	public String inputPath(Scanner s) {
		while (true) {
			System.out.println("Please enter the location where you'd like to store the output file and its name: ");
		String outPut = s.nextLine();
		Path file = Paths.get(outPut);
		if ((isWritable(file) && (!doesFileExists(file)))) {
			return outPut;
		}
		return outPut;
	}
}
*/


