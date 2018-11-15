public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

	public int setAge(int age) {
		return this.age = age;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hi, my name is " + this.name + ". My age is " + this.age + ".");
	}
	
	public String toString() {
		return "I am " + this.name + " and my age is " + this.age + ".";
	}
	
	public String sayWhat() {
		return this.name + " says WHAT!";
	}

}

