public class Person {
	private String name;
	private int age;
	private Person[] children;
	private int nChildren;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.children = new Person[3];
		this.nChildren = 0;
	}
	
//	public void addChild(Person child) {
//		if (counter <= 3) {
//		this.children[counter] = child;
//		++counter;
//		}
//	}
	
	public void addChild(Person child) {
		if (nChildren == this.children.length) {
		Person[] temp = new Person[this.children.length + 1];
		
		for (int i = 0; i<children.length; i++) {
			temp[i] = children[i];
		}
		children = temp;
		}
		this.children[nChildren] = child; //this.children[nChildren++] = child;
		nChildren++;
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

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hi, my name is " + this.name + ". My age is " + this.age + ".");
	}
	
	public String toString() {
		return "Children: " + this.children[0].name + ", " + this.children[1].name + ", " + this.children[2].name + ", " + this.children[3].name + ", " + this.children[4].name;
	}
	
//	String line - name + " " + age;
//	if (nCHildren>0) {
//		line += "( ";
//		for (int i = 0; i < nChildren;i ++) {
//		}
			}
		
	
