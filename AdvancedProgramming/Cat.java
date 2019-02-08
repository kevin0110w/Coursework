public abstract class Cat extends AbstractPet {
	public Cat(String n, int a) {
		super(n,a);
	}
	public String description() { // has to have, class that extends abstract class (i.e. this is in AbstractPet) must implement all abstract methods and attributes
		// interface just method signatures and variables that are constants - abstract classes richer than interfaces
		String output = name + " is a cat and is aged " + age;
		return output;
	}
	
	public abstract void stroke();
}