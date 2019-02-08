public class AbstractPetTest {
	public static void main(String[] args) {
	//	Cat a = new Cat("Spot",2); // abstract
	//	Cat a = new Siamese("Spot",2); // Siamese has implemented everything.
		AbstractPet a = new Siamese("Spot",2); // Siamese has implemented everything.
		System.out.println(a.description());
		System.out.println(a);
	}
}