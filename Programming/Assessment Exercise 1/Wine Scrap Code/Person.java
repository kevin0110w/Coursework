
public class Person {
	private String name;
	private double balance;
	private Person[] order = new Person[1000];
	private int counter = 0;
	
	public Person(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void addOrder(Wine a) {
		if(counter == 1000) {
			Person[] newArray = new Person[1000];
			for(int i=0;i<counter;i++) {
				newArray[i] = order[i];
			}
			order = newArray;
		}
		order[counter++] = a;
	}
}
