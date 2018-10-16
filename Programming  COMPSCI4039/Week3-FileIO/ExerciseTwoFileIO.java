import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseTwoFileIO {

	public static void main(String[] args) throws IOException {
		String fN = "H:\\Desktop\\dolphin.txt"; //- file reading text file
		FileReader fR = null;
		Scanner s = null;
		
		try {
			fR =  new FileReader(fN);
			 s = new Scanner(fR);
			
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
		while (s.hasNextLine()) {
		
			
			String line = s.nextLine();
			System.out.println(line);
		}
		 fR.close();
	}
}
