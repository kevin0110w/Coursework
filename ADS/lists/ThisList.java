package lists;

import java.util.LinkedList;
import java.util.List;

public class ThisList {

	public static void main(String[] args) {
//		List<long>thisList = new LinkedList<>();
		List<String>thisList = new LinkedList<>();
		thisList.add("Mireilla");
		thisList.add("Linda");
		thisList.add("Peter");
		thisList.add("Rita");
		thisList.add("Mireilla");
		thisList.add("Christina");
		thisList.remove("Mireilla");
		System.out.println(thisList);
	}
}
