/**
 * @author 0808148w
 * This class is for the Vignere Cipher object
 * Each object will have an instance variable for the cipher array and from the inherited class. Cipher will be 
 * a multidimensional array and will hold an int representation of a character in the alphabet in each index 
 */
public class VignereCipher extends MonoAlphabetic {
	private int[][] vignereCipherArray;
//	private int[][] multiAlphabeticalArray; Assumed I needed to make this at the start, realised it only needed a 1D array to work! Used the inherited value.
	private static final int ARRAY_SIZE = 26;

	public VignereCipher(String keyword) {
		super(keyword);
//		this.multiAlphabeticalArray = new int[keyword.length()][ARRAY_SIZE];//alphabetic array for decoding will have as many rows as the number of characters in the keyword 
//		makeMultiAlphabeticArray();
		this.vignereCipherArray = new int[keyword.length()][ARRAY_SIZE];//cipher array will have as many rows as the number of characters in the keyword
		populateCipherArray(keyword); 	
	}

	/**
	 * @param Each char of the keyword will be kept in the first index of each successive row
	 * This method is used to populate the cipher array which has been instantiated
	 */
	public void populateCipherArray(String keyword) {
		for (int i = 0; i < this.vignereCipherArray.length; i++) {//iterate through each row
			int letter = (int) keyword.charAt(i); //get the int representation of the char at index i in the keyword
			for (int j = 0; j<this.vignereCipherArray[i].length;j++) {//iterate through each index in row i
				this.vignereCipherArray[i][j] = letter; // start each row with the corresponding int representation of the char at I in the keyword
				if (letter == 90) { //we check once Z has been set, so that we can reset to 64 then increment so that on the next iteration, A is set and so forth
					letter = 64; 
				}
//				System.out.print((char) this.vignereCipherArray[i][j] + " "); //Print to console to confirm correct cipher array produced
				letter++; //increment the letter so that each index gets the next int representation of the char in the alphabet
			}
			System.out.println();
		}
	}

	/*
	 * This method encrypts the text to be written to file
	 * @Param inputFile is the String representation of the file read by Scanner to be encrypted
	 */
	public  String encodeStringUsingVignereCipher(String inputFile) {
		String encryptedString = "";
		int rowCounter = 0; //used as a counter for going down each row
		for (int i = 0; i<inputFile.length();i++) {
			if ((int)inputFile.charAt(i) >=65 && (int) inputFile.charAt(i) <= 90) { //only consider capital letters
				int positionInAlphabet = (int) inputFile.charAt(i) - 65; //gets the position/index number of the letter at i (i.e. if charAti = Z, Z = 90, 90 - 65 = 25, go to the 25th index of the cipher array
				if (rowCounter >= this.vignereCipherArray.length) { //Once the program has gone through each row (i.e. row counter is bigger than the number of rows),
					rowCounter = 0; //we reset the row counter so that it jumps back to the top
				}
				int letterToBeAdded = getIntOfChar(positionInAlphabet, rowCounter); //get the int representation of the character that is in the cipher array at rowCounter at index number of alphabetic
				rowCounter++; //increment rowCounter
				encryptedString = encryptedString + (char) letterToBeAdded; //add the character from the cipher to the encryptedString as long it is a capital letter
			} else {
				encryptedString = encryptedString + inputFile.charAt(i); //add the character from the cipher to the encryptedString if it's anything other than a capital letter
			}

		}
//		System.out.print("Input Text:   " + inputFile);        //Comparing input 
//		System.out.print("Encypted Text: " + encryptedString); // with output
		return encryptedString;	
	}

	/*For encoding purposes
	 * Return the int representation of the char in the vignere cipher array, that is in row # 'rowCount' and index # positionInAlphabet
	 */
	public int getIntOfChar(int positionInAlphabet, int rowCount) {
		return this.vignereCipherArray[rowCount][positionInAlphabet];
	}

	/*
	 * To decrypt text that was previously encrypted using Vignere Cipher
	 * @Param toBeDecoded is the string representation of the file that has been read by scanner
	 */
	public String decodeStringUsingVignereCipher(String toBeDecoded) {
		String decryptedString = ""; 
		int rowCount = 0; 
		for (int j = 0; j < toBeDecoded.length(); j++) {
			if (((int)toBeDecoded.charAt(j) >=65) && ((int)toBeDecoded.charAt(j) <= 90)) { //only consider capital letters
				int ofLetterJ = (int) toBeDecoded.charAt(j); // get the int representation of the letter of the alphabet at index j of the encoded string
				if (rowCount >= this.vignereCipherArray.length) { //checks if the rowCount is greater than the number of rows in the alphabetical array which is dependent on the length of the keyword
					rowCount = 0; //reset it if it is, return to the top
				}
				int indexNumberInAlphabeticArray = getNthIndex(ofLetterJ, rowCount); //get the index number of the alphabetical array by getting the index number where the char is stored in the cipher array at row 'rowCount'
	//			int letterToBeAdded1 = getIntOfCharInAlphabeticArray(indexNumberInAlphabeticArray, rowCount); // when I initially thought I might need a multi-D a-z array
				int letterToBeAdded1 = getIntOfCharInAlphabeticArray(indexNumberInAlphabeticArray); // get the int representation of the char that is stored at index # 'nthindex' and row 'rowCount'
				rowCount++; //iterate through each row
				decryptedString = decryptedString + (char)letterToBeAdded1;//add the character to the string that is to be written to file containing the decoded message if capital letter
			} else {
				decryptedString = decryptedString + toBeDecoded.charAt(j); // add the character to the string that is to be written to file if it's anything other than a capital letter
			}
		}
//		System.out.print("Input Text:   " + toBeDecoded);     //printing to console to check input
//		System.out.print("Decoded Text: " + decryptedString); // vs output
		return decryptedString;
	}

	/**
	 * Get the index number that the char will be in alphabetical array by iterating through each index of the cipher array and checking for equality
	 * @param intOfLetter int representation of the letter of the alphabet in encrypted message
	 * @param rowCount
	 * @return index number to go to in the alphabet array
	 */
	public int getNthIndex(int intOfLetter, int rowCount) {
		int index = 0;
		for (int i = 0; i<this.vignereCipherArray[rowCount].length; i++) { //iterate through indexes at row 'rowCount'
			if (intOfLetter == this.vignereCipherArray[rowCount][i]) { 
				index = i; //go to this index number in the alphabet array
				break;
			}
		}
		return index;
	}

	/* For whatever reason, i initially assumed that I needed to use a multialphabetical array for encoding/decoding purposes.
	 * Make a multiAlphabeticArray for decoding purposes
	 * 
	public void makeMultiAlphabeticArray() {
		int x = 65; //(int)('A') = 65;
		for (int i = 0; i < this.multiAlphabeticalArray.length; i++) {
			for (int j = 0; j<this.multiAlphabeticalArray[i].length; j++) {
			this.multiAlphabeticalArray[i][j] = x;
			System.out.print((char) (this.multiAlphabeticalArray[i][j]) + " ");
			x++;
		}
			x = 65; //reset x going down each row so that x = (char)'65' = A..
			System.out.println();
		}
	}*/
	/* Once I realised I didn't need a multidimensional A-Z array, I defaulted to the method from the inherited 
	 * Return the int representation of the letter of the alphabet at row 'rowCount' and index calculated from the cipher array
	 *
	public int getIntOfCharInAlphabeticArray(int indexNumberInAlphabeticArray, int rowCount) {
		return this.multiAlphabeticalArray[rowCount][indexNumberInAlphabeticArray];
	}*/
}
