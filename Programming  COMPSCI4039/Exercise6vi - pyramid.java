/*
Write a program that, provided with the number of rows (in this case 4) produced the following triangle:
   1
  2 2
 3 3 3
4 4 4 4
I.e. you need to use the correct number of spaces to lay out the triangle. To add spaces to a string, you could write a loop that adds one space (s += “ “;) each time around.
*/
import java.util.*;

public class pyramid {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int n = Integer.parseInt(s.nextLine());
		
		String pyramidToBePrinted = buildPyramid(n);
		
		System.out.print(pyramidToBePrinted);
		
		s.close();
	
	}
	
	public static String buildPyramid(int noOfRows) {
		String newWord = "";
		int rowCount = 1;
		for (int i = noOfRows; i > 0; i--) {
//			to work out number of spaces to print
			for (int j = 1; j<i; j++) { 
				newWord = newWord + " ";
			}	
			for (int j = 1; j <= rowCount; j++) {
				newWord = newWord + rowCount + " ";
				} 
			
			newWord += '\n';
			rowCount++;
		}
		return newWord;
	}
}

