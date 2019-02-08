package tutorial3;

public class DeleteValueInSortedArray  {

	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,10};
		int b = findIndex(a, 10);
        a = deleteElement(a, b);
        for (int i = 0 ; i < a.length; i++) {
        	System.out.println(a[i]);
        }
	}
	
	public static int[] deleteElement(int[] array, int position) {
		int[] x = new int[array.length-1];
		int n = 0;
		
		for (int i = 0;  i < position;  i++ ) {
			x[i] = array[i];
		}
		for (int i = position+1; i < array.length; i ++) {
			x[i-1] = array[i];
			n++;
		}
		return x;
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
