
To import a file containing lines of math equations and work out the results using the scanner facility

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseTwoFileIO {

	public static void main(String[] args) throws IOException {
//		String fN = "H:\\Desktop\\dolphin.txt";
		String fN = "H:\\Desktop\\sums.txt";
		FileReader fR = null;
		Scanner s = null;
		
		try {
			fR =  new FileReader(fN);
			 s = new Scanner(fR);
			
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
//		while (s.hasNextLine()) {
//			String line = s.nextLine();
//			System.out.println(line);
//		}

		while (s.hasNextLine()) {
			String line = s.nextLine();
			Scanner t = new Scanner(line);
			int numberOne = t.nextInt();
			char operator = t.next().charAt(0);
			int numberTwo = t.nextInt();
			int result = 0;
			if (operator == '+') {
				result = numberOne + numberTwo;
			} else if  (operator == '-') {
				result = numberOne -numberTwo;
			} 
			
			System.out.println(result);
		}
		fR.close();
	}
}
	

//		
//		
//		 fR.close();
//	}
//}
