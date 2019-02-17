
public class Person {
	private String name;
	private int age;
	private int height;
	
	public Person(String name, int age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int setHeight(int height) {
		return this.height = height;
	}
	
	public int setAge(int age) {
		return this.age = age;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hi, my name is " + this.name + ". My age is " + this.age + " and my height is " + this.height + ".");
	}
	
	public String toString() {
		return "I am " + this.name + " and my age is " + this.age + ".";
	}
	
	public String sayWhat() {
		return this.name + " says WHAT!";
	}

}
