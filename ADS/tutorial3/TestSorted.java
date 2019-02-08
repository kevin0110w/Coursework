package tutorial3;

public class TestSorted {

	public static void main(String[] args) {
		int[] anArray = new int[] {5,2,4,3,1};
		int[] a = new int[] {0};
		int[]  b = new int[] {1,2,3,4,5};
		int[] d = new int[] {2,2,2};
		System.out.println(testSorted(anArray));
		System.out.println(testSorted(a));
		System.out.println(testSorted(b));
		System.out.println(testSorted(d));
	}
	
	public static boolean testSorted(int[] array) {
		if (array.length == 0 || array.length ==1) {
			return true;
		}
		boolean sorted = false;
		if (array.length > 1) {
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] <= array[i+1]) {
					sorted = true;
				} else {
					sorted = false;
				}
			}
		}
		return sorted;
	}
}
