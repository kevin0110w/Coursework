package sorting;

public class SelectionSort {
	
	public static void main(String[] args) {
		String[] anArray = new String[] {"cat", "bat", "pig", "snake", "goat", "chimp"};
		int left = 0;
		int right = anArray.length-1;
		selectionSort(anArray, left, right);
	}
	
	public static String[] selectionSort(String[] unsortedArray, int left, int right) {
		for (int i = left; i < right; i++) {
			int p = i;
			String least = unsortedArray[p];
			for (int k = i+1; k <= right; k++) {
				int comp = unsortedArray[k].compareTo(least);
				if (comp < 0) {
					p = k;
					least = unsortedArray[p];
					System.out.print("(word at index: )"+ p +": " );
					printArray(unsortedArray);
					System.out.println("------------------------------------");
				}
			}
			if (p != i) {
				unsortedArray[p] = unsortedArray[i];
				unsortedArray[i] = least;
			}
		}
	
		return unsortedArray;
	}
	
	private static void printArray(String[] unsortedArray) {
		String s = "[";
		for (int i = 0; i < unsortedArray.length; i++) {
			s += " " + unsortedArray[i] + ", ";
		}
		s += "]";
		System.out.println(s);
	}
}
