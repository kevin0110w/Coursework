
public class Render {

	public static void main(String[] args) {
//		System.out.println(render(29, 2));
//		System.out.println(render(29, 8));
//		System.out.println(render(29, 10));
//		System.out.println(render(-29, 8));
		System.out.println(factorial(5));
		System.out.println(factorial2(5));
	}
	
	public static String render(int i, int r) {
		String s = "";
		if (i<0) {
			s += '-';
			s += render(-i, r);
		} else if (i<r) {
			char d = (char)('0' + i);
			s += d;
		} else {
			char d = (char)('0' + i % r);
			s += render(i/r, r);
			s += d;
		}
		return s;
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
