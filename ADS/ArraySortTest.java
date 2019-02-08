
public class ArraySortTest implements Comparable {
	private static int[] x;
	
	public static void main(String[] args) {
		x = new int[] {1,3,2,5,4};
		for (int i = 0; i < x.length; i++) {
			
		}
	}
	
	public static void sort(Object[] a) {
	}
	}
	@Override
	public int compareTo(Object arg0) {
		if (this < arg0) {
			return -1;
		} else if (this > arg0) {
			return 1;
		} else {
			return 0;
		}
	}

}
