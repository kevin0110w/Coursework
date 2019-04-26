import java.io.FileWriter;
import java.io.IOException;

public class Wine {
	private String name;
	private int quantity;
	private double price;
	private Wine[] wine; 
	private int counter;
	private final static int BOTTLES = 999;
	
	public Wine(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Wine() {
		this.wine = new Wine[BOTTLES];
		this.counter = 0;
	}
	public void addWine(Wine wine) {
		this.wine[this.counter] = wine;
		this.counter++;
	}
	
//	public void print(CustomerAccount customer) {
//		if (customer.getCounter() <= wine.length) { // if we don't re-size the array so that wine.length == total no. of bottles,
//			Wine[] temp = new Wine[customer.getCounter()]; // we'd end up printing a list of 'null' values where the array hasn't been populated
//			
//			for (int i = 0; i<temp.length; i++) {
//				temp[i] = wine[i];
//			}
//			wine = temp;
//			}
//		
//		String output = "";
//		for (int i = 0; i < this.wine.length; i++) {
//			output =  this.wine[i].getWineName() + "(" + this.wine[i].getPricePerBottle() + ")" + ", " + this.wine[i].getQuantity() + " units ," + " total cost: " + this.wine[i].getTotalCostPerOrder() + "\n";
//			System.out.print(output);
//		}
//	public void print(Wine wine2, CustomerAccount customer) {
	public void print(CustomerAccount customer) {
		customer.resetBalance();
		String outF = "C:\\Users\\kevin woo hoo\\desktop\\testFile.txt";
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(outF);
			String newLine = customer.getName() + ". Your balance is £" + String.format("%.2f", customer.getIntitialBalance()) + "\n"; 
			fw.write(newLine);
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
				customer.buyWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
			} else {
				customer.returnWine(wine[i].getQuantity(), wine[i].getPricePerBottle());
			}
			output = "Wine name: " + wine[i].getWineName() + "(£" + String.format("%.2f", wine[i].getPricePerBottle()) + ") , Quantity: " + wine[i].getQuantity() + " units, Total Cost: £" + String.format("%.2f",wine[i].getTotalCostPerOrder()) + ", New balance: £" + String.format("%.2f", customer.getBalance())  + "\n";
			System.out.print(output);
			fw.write(output);
			}
		}	 catch(IOException e) {
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

	
//	
//	public void setWineName(String name) {
//		this.name = name;
//	}
	
	public String getWineName() {
		return this.name;
	}
	
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
//	public void setPrice(double price) {
//		this.price = price;
//	}
	
	public double getPricePerBottle() {
//		return this.price * this.quantity;
		return this.price;
	}
	
	public double getTotalCostPerOrder() {
		return this.price * this.quantity;
	}
}
	
//	public void printPrint() {
//		String output = "";
//		for (int i = 0; i < this.wine.length; i++) {
//			output = this.wine[i].name + output;
//			System.out.println(output);
////			output = "Wine name: " + this.wine[i].name + ", Wine price: " + this.wine[i].price + "\n" + output;
//		}
//	}

