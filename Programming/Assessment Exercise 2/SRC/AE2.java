/*
 * This contains the main method for reading the file, writing the file and calling various objects
 */
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AE2 {
	public static void main(String[] args) {
		Scanner s =	 new Scanner(System.in); 
		String fN = "";
		String fN2 = "";
		String inputText = "";
		
		/*
		 * Following method checks that user enters correct file name and that it exists too
		 */
		System.out.println("Please enter name of the input file: ");
		do {
			try {
				fN = getInputFileName(s);
				fN2 = fN + ".txt"; // appending .txt to filename
				inputText = readInputFile(fN2); // storing the file content as a string
				break;
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				System.out.println("Please enter name of the input file: ");
			} 
		} while (s.hasNextLine());

		/*
		 * Ensures get correct keyword
		 */
		String keyWord = ""; 
		try {
			keyWord = getKeyWord(s);
		} catch (AssEx2Exception e) {
			e.printStackTrace();
		}
		
		/** Arrays - edit to test
		 *
		 */
//		MonoAlphabetic array = new MonoAlphabetic(keyWord); //monoalphabetic cipher 
		VignereCipher array = new VignereCipher(keyWord); //vignere cipher object
		

		String toBeWritten = ""; //content to be written to file
		String outputFileName = ""; // output file name
		String letterFrequencyFileName = ""; // letter frequency file name

		
		/*
		 * Method to make sure we get the correct file names based on the last letter
		 * of the file name. This will also determine whether we encrypt or decode
		 */
		if (fN.charAt(fN.length()-1) == 'P') { //checks if last letter is P, else checks if last letter is C
//			toBeWritten = array.encodeStringUsingMonoAlphabetArrayCipher(inputText);  //encoding using monoalphabetical cipher
			toBeWritten = array.encodeStringUsingVignereCipher(inputText); // encoding using vignere cipher
			outputFileName = outputFileName(fN); //return correct file name for output file
			letterFrequencyFileName = letterFrequencyFileName(fN); // return correct file name for frequency table to be written
		} else if (fN.charAt(fN.length()-1) == 'C') {
//			toBeWritten = array.decodeStringUsingMonoAlphabetArrayCipher(inputText); // decoding using monoalphabetical cipher
			toBeWritten = array.decodeStringUsingVignereCipher(inputText); // decoding using vignere cipher
			outputFileName = outputFileName(fN); //return correct file name for output file
			letterFrequencyFileName = letterFrequencyFileName(fN); // return correct file name for frequency table to be written
		}

		LetterFrequency lF = new LetterFrequency(toBeWritten); //construct new lF object passing output text String as a parameter
		String output = lF.createLetterFrequencyTable(); //create Letter frequency table and store as a string ready to be written to output file

		writeOutputFile(outputFileName, toBeWritten); //write encrypted/decoded content to file
		writeLetterFrequencyFile(letterFrequencyFileName, output); //write corresponding letter frequency table to file

	}

	/* @Param Scanner input
	 * Method to return file name as a string
	 * Throws an exception if the user inputs a string that does not contain
	 * P or C at the end
	 */
	public static String getInputFileName(Scanner input) throws FileNotFoundException {
		String fN = "";
		while (input.hasNextLine()) {
			try {
				fN = input.nextLine();
				if ((!(fN.charAt(fN.length()-1) == 'P')) && (!(fN.charAt(fN.length()-1) == 'C'))) {
					throw new AssEx2Exception("File name must end in 'P' or 'C'");
				}
				break;
			} catch (AssEx2Exception e) {
				System.out.println("You've entered an incorrect file name");
				System.out.println(e.getMessage());
				System.out.println("Please enter file name again: ");
			} 
		};
		return fN;
	}
	
	/* @Param String file name
	 * Method to return file contents as a string
	 * throws file not found exception
	 */
	public static String readInputFile(String inputFileName) throws IOException {
		Scanner s = new Scanner(System.in);
		FileReader fr = null;
		String string = "";
		try {
			fr = new FileReader(inputFileName);
			Scanner d = new Scanner(fr);
			while (d.hasNextLine()) {
				String line = d.nextLine();
				string += line;
				string += "\n";
			}	
		} finally {
			if (fr != null) {
				try { 
					fr.close();
				} catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return string;
	}

	/*
	* Method to return correct name for output file
	* Copies all letters of the filename until the last letter where it'll 
	* append either C.txt or D.txt
	*/
	public static String outputFileName(String inputFileName) {
		String outputFileName = "";
		if (inputFileName.charAt(inputFileName.length() - 1) == 'P') {
			for (int i = 0; i < inputFileName.length() - 1; i++) {
				outputFileName = outputFileName + inputFileName.charAt(i);
			}
			outputFileName = outputFileName + "C.txt";
		} else if (inputFileName.charAt(inputFileName.length() - 1) == 'C') {
			for (int i = 0; i < inputFileName.length() - 1; i++) {
				outputFileName = outputFileName + inputFileName.charAt(i);
			}
			outputFileName = outputFileName + "D.txt";
		} else {
			System.out.println("You've entered incorrect filename");
		}
		return outputFileName;
	}
	
	/*
	 * Method that returns the correct name for the letter frequency
	 * file
	 */
	public static String letterFrequencyFileName(String output) {
		String outputFileName = "";
		for (int i = 0; i < output.length() - 1; i++) {
			outputFileName = outputFileName + output.charAt(i);
		}
		outputFileName = outputFileName + "F.txt";
		return outputFileName;
	}
	
	/*
	 * Method to get a valid keyword
	 * I assume that this must contain all capital letters
	 * This method contains another method which checks the validity
	 */
	public static String getKeyWord(Scanner input) throws AssEx2Exception {
		String keyWord = "";
		boolean validKey = true;
		while (validKey) {
			System.out.println("Please enter keyword: ");
			keyWord = input.nextLine();
			validKey = checkKeyWord(keyWord);
		}
		return keyWord;
	}
	
	/*
	 * Method checks that the keyword only contains capital letters
	 * If it does, it returns boolean validKeyWord as false which means the while loop
	 *  in getKeyWord() breaks out.
	 */
	public static boolean checkKeyWord(String keyword) throws AssEx2Exception {
		boolean validKeyWord = false;
		try {
			for (int i = 0; i < keyword.length(); i++) {
				int letter = (int) keyword.charAt(i);
				if ((letter < 65) || (letter > 90)) { //checks for capital letters only
					validKeyWord = true;
					throw new AssEx2Exception("Keyword can only contain capital letters!");
				}
				for (int j = i + 1; j < keyword.length(); j++) {
					if (keyword.charAt(i) == keyword.charAt(j)) {
						validKeyWord = true;
						throw new AssEx2Exception("Keyword can't contain repeating characters!");
					}
				}
			}
		} catch (AssEx2Exception e) {
			System.out.println(e.getMessage());
		}
		return validKeyWord;
	}
	
	/*
	 * Method to write encoded/decoded contents to file
	 * @Param outputFile is the file name of the output file
	 * @Param toBeWritten is the string containing the content to be written to file
	 */
	public static void writeOutputFile(String outputFile, String toBeWritten) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile);
			// System.out.println(toBeWritten); check getting right output
			fw.write(toBeWritten);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Please state file name again");
			return;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
					return;
				}
			}
		}
	}


	/*
	 * Method to write the letter frequency table to file
	 * @Paramm output is the letter frequency table
	 * @Param letterFrequencyFileName is the file name of the output file
	 */
	public static void writeLetterFrequencyFile(String letterFrequencyFileName, String output) {
		Scanner s = new Scanner(System.in);
		FileWriter fw2 = null;
		try {
			fw2 = new FileWriter(letterFrequencyFileName);
			//		System.out.println(toBeWritten); check getting right output		 
			fw2.write(output);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());	
			System.out.println("Please state file name again");
			return;
		}catch(IOException e) {
			System.out.println(e.getMessage());
			return;
		}finally {
			if (fw2!=null) {
				try {
					fw2.close();
				} catch(IOException e) {
					System.out.println(e.getMessage());
					return;
				}
			}
		}
	}
}