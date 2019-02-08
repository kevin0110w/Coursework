package tutorial3;

public class DeleteValueInUnsortedArray {

	public static void main(String[] args) {
		int[] a = new int[] {10, 3, 2, 1, 2};
		int[] b = delElement(a, findElement(a, 3));
		for (int i = 0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static int findElement(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				return i;
			} 


		}
		return -1;
	}

	public static int[] delElement(int[] array, int position) {
		for (int i = position; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		return array;

	}
}
