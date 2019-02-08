public class Dog extends Pet {
	public Dog(String n,int a) {
		super(n,a);
	}
	//overriding description method that was in pet.
	public String description() {
		String output = name + " is my dog and is aged " + age;
		return output;
	}
	public void provideBone() {
		System.out.println(name + " says: Thanks for the bone!");
	}
}