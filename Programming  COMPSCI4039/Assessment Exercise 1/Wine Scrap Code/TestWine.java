import java.util.*;

public class TestWine {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		System.out.println("Please type your name: ");
//		String name = s.nextLine();
		CustomerAccount c = new CustomerAccount();
		c = c.startTransaction(s);
		Wine wine = new Wine(); 
		wine = c.orderWine(s, c, wine);
		wine.print(c);
		s.close();
	}

}
