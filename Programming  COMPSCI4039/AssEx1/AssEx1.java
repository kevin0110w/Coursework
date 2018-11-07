import java.util.Scanner;

public class AssEx1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CustomerAccount c = new CustomerAccount(); //create a customeraccount object to access methods within that class
		c = c.startTransaction(s); //this method will return a new object which the reference c will point to
		Wine wine = new Wine();  // Create a wine object that has an instance variable of type array that'll be populated by a list of wine objects. Need to initialise it with a random number (not sure how many transactions will be handled
								//	at this stage, have chosen 999 assuming that the user will buy less than 1000 bottles of wine! Can always grow it if they have decide to order more!

		wine = c.orderWine(s, c, wine); //method that involves user interaction and buy bottles of wine.
		wine.print(c, s); //method to print transaction to file
		s.close();
	}
}
