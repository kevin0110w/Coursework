package inheritance;
public abstract class AbstractPet {
	protected String name; // protected so those in subclass or classes in same package have access, alternatively use getter/setter methods
	protected int age;
	public AbstractPet(String n, int a) {
		name = n;
		age = a;
	}
	abstract String description();
	public String toString() {
		String output = name + " is aged " + age;
		return output;
	}
}