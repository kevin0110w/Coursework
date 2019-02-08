package tutorial3;

public class InsertValintoSorted {

	public static void main(String[] args) {
		int[] x = new int[] {1,2,3,4};
		x = insertValue(x, 3);
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}

	}
	
	public static int[] insertValue(int[] array, int number) {
		int left = 0;
		int right = array.length-1;
		int ins = number;
		
		for (int i = right; i > number; i--) {
			array[i] = array[i-1];
			array[i-1] = number;
		}
		return array;
	}
	
	public static int findIndex(int[] array, int element) {
		int m = 0;
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			m = (left + right)/2;
			int comp = compareTo(element, array[m]);
			if (comp == 0) {
				return m;
			} else if (comp < 0) {
				right = m -1;
			} else {
				left = m + 1;
			}
		}
		return m;
	}

	public static int compareTo(int m, int n) {
		if (m < n) {
			return -1;
		} else if ( m > n ) {
			return 1;
		} else {
			return 0;
		}
	}
}
