
public class Factorial {

	public static void main(String[] args) {
		
	}
	public static int factorial(int n) {
		int total = 0;
		for (int i = 0; i <= n; i++) {
		    total = total +  (n* (n-1));
		}
		return total;
	}
	
	public static int factorial2(int n) {
		if (n ==0) {
			return 1;
		} else {
			return n * factorial2(n-1);
		}
	}
}
