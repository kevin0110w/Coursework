
public class TimesTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimesTable a = new TimesTable(2);
		
		System.out.print(a.printTable());
		
		System.out.println(a);
		a.setNumber(1029);
		System.out.println(a.printTableUpTo(50));
//		System.out.print(a.printTable());
	}

}
