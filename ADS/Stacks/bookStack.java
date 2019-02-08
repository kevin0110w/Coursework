
package Stacks;
import java.util.*;

public class bookStack {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<book> books = new Stack<book>();
		books.push(new book("moby_dick"));
		books.push(new book("war_and_peace"));
		books.push(new book("rob_roy"));
		Iterator<book> iterator = books.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			System.out.println("Book " + i + ": " + iterator.next());
			i++;
		}
		
		System.out.println("____");
		book b = books.pop();
		System.out.println("Top book removed is " + b);
	}

}
