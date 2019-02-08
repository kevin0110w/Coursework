package tutorial3;

public class Contact {
	public String name;
	public String number;

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	static String searchByName(Contact[] book, String targetName) {
		int l = 0;
		int r = book.length-1;
		while (l <= r) {
			int m = (l+r)/2;
			int comp = targetName.compareTo(book[m].name);
			if (comp == 0) {
				return book[m].number;
			} else if (comp < 0) {
				r = m - 1;
			} else {
				l = m+ 1;
			}
		}
		return "Not Found!";
	}

	static String[] searchByNumber(Contact[] book, String targetNumber) {
		String[] names = new String[book.length];
		for (int i = 0 ; i < book.length; i ++) {
			if (book[i].number == targetNumber) {
				names[i] = book[i].name;
			}
		}
		return names;
	}
	public static void main(String[] args) {
		Contact[] x = new Contact[4];
		x[0] = new Contact("Bill", "555");
		x[1] = new Contact("Bob", "455");
		x[2] = new Contact("Charles", "111");
		x[3] = new Contact("Dick", "555");
//		for (int i = 0; i<x.length; i++) {
//			System.out.println(x[i]);
//		}
		System.out.println(searchByName(x, "Bill"));
		String[] y = new String[2];
		y = searchByNumber(x, "555");
		for (int i = 0; i < y.length; i++) {
			System.out.println(y[i]);
		}
		
	}
	
	public String toString() {
		return this.name + ": " + this.number;
	}
}
