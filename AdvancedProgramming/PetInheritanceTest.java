public class PetInheritanceTest {
	public static void main(String[] args) {
		Pet a = new Pet("Flossy",3);
		System.out.println(a.description());

		System.out.println();System.out.println();

		Pet b = new Dog("Bonzo",4);

		// Dog z = b;

		System.out.println(b.description()); // will use description method in dog class, as object of type dog
		// Why wouldn't b.provideBone() work? b is reference type Pet, no provideBone method?
		((Dog)b).provideBone(); // if you want to just do it once
		// Dog bb = b; making a new references to the same object reference as b // if you want to do multiple actions..
		// bb.provideBone();
		// ((Dog)a).provideBone(); will not work 
		// System.out.println();System.out.println();

		Dog c = new Dog("Rex",5);
		System.out.println(c.getName()); //use method in inherited sub-class
		c.provideBone();
		Pet aa = c;

		// System.out.println();System.out.println();

		// Pet d = new Goldfish("Clive",1);
		// System.out.println(d.description());
		// System.out.println("This pet is called " + d.getName());

		// System.out.println();System.out.println();

		Pet[] e = new Pet[3];
		e[0] = new Dog("Colin",2);
		e[1] = new Goldfish("Ruth",1);
		e[2] = new Pet("Molly",4);

		for(int i=0;i<e.length;i++) {
			System.out.println(e[i].description());
		}

		// System.out.println();System.out.println();

		// // Pet also has a toString method
		// System.out.println(a);
		// System.out.println(b);
	}
}