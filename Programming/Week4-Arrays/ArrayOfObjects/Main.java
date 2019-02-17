
public class Main {

	public static void main(String[] args) {
		Person[] people = new Person[4];
		people[0] = new Person("Bill", 56);
		people[1] = new Person("Kevin", 10);
		people[2] = new Person("Joe", 18);
		people[3] = new Person("Mark", 1);
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getName());
		}
		people[0].setName("charles");
		System.out.println(people[0].getName());
//	    int totalAge = calculateAge(people);
//	    System.out.println("Total age: " + totalAge);
		Person cat = new Person("Cat", 1);
		Person tommy = new Person("Tommy");
		Person chan = new Person("Chan", 10);

		people[0].addChild(cat);
		people[0].addChild(tommy);
		people[0].addChild(chan);
		people[0].addChild(cat);
		people[0].addChild(cat);
		
		System.out.println(people[0]);
	}
	
	public static int calculateAge(Person[] people) {
		int sum = 0;
		for (int i = 0; i<people.length; i++) { // for (Person q: people) {
			sum += people[i].getAge(); // sum += q.getAge();
		}
		return sum;
	}
}
