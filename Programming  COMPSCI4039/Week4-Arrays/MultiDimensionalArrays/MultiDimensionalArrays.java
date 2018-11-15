import java.util.Scanner;

public class MultiDimensionalArrays {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] array = returnArray(s);
		print2DIntArray(array);
	}
		
		public static int[][] returnArray(Scanner s) {
		System.out.print("Please choose an integer: ");
		int number = s.nextInt();
		int numberOne = number + 1;
		int[][] table = new int[number][number];
		for (int row = 0; row<number; row++) {
			int col = 0; //ensures that we start adding
			//values to column at index 0 at the start and gradually move one over to the right as we go down each row, column as a counter
			for (int j = 1; j<numberOne; j++) {//numberOne to ensure we hit all columns due to 0indexing
				int x = j - row; 
				if (x < 0) { //adds 0's to pyramid,
					x = 0;  //makes sure to never go into
				}			//negative
				table[row][col] = x; //sets column to x
				col++;
			}
		}
		return table;
	}
	
	public static void print2DIntArray(int[][] array) {
		for (int i = 0; i<array.length; i++) {
			for( int j = 0; j<array.length;j++) {
			System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
		