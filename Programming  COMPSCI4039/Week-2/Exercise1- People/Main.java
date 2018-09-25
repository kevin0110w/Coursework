
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person personOne = new Person("Kevin", 27, 166);
		Person personTwo = new Person("Fiona", 24, 133);
		Person personThree = new Person("Timmy", 32, 199);
		
		System.out.println(personOne.getAge());
		personOne.getAge();
		personTwo.setAge(12);
		System.out.println(personTwo.setAge(12));
		personTwo.getAge();
		personThree.sayHello();
		System.out.println(personOne.sayWhat());
		System.out.println(personTwo.toString());
	}

}
