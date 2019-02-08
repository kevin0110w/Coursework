
public class TowersOfHanoi {
	private static int i = 1;
	public static void main(String[] args) {
		System.out.println(moves(3));
	}
	
	public static int moves(int discs) {

		int total = 1;
		if (discs == 1) {
			System.out.println("Move no. " + i);
			i++;
			return total;
		} else {
			System.out.println("Move no. " + i);
			i++;
			return total + 2 * moves(discs-1);
		}
	}
}
