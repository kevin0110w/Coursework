/**
 * @author 0808148w
 * This class is for the Monoalphabet Cipher object
 * Each object will have an instance variable for the cipher array, alphabet array. Each array is 1Dimensional containing an int representation of a character in the alphabet in each array
 */
public class MonoAlphabetic {
	private int[] monoAlphabeticArray; //cipher array
	private int[] alphabeticArray; //alphabet array
	private static final int ARRAY_SIZE = 26;

	public MonoAlphabetic(String keyword) {
		this.monoAlphabeticArray = new int[ARRAY_SIZE];
		this.alphabeticArray = new int[ARRAY_SIZE];	
		String wordToArray = createString(keyword); //create string with keyword at beginning and remaining letters to follow
		makeAlphabeticArray(); //make normal alphabetical array for decoding
		makeMonoAlphabeticalArray(wordToArray); //create mono-alphabetical array for encrypting (i.e. encrypted array with keyword at front)
	}

	/**
	 * @Param String keyword to be added at front of cipher
	 * Create a string to be used for cipher with keyword at the start
	 * add alphabets not in the keyword to a string alphabetWithKeyword which is set to the keyword
	 * if the letter at int i of the alphabet is not contained within keyword, String.indexOf will return -1, 
	 * therefore we can add that alphabet to alphabetWithKeyword 
	 * otherwise we can ignore the letter and continue with the for-loop
	 */
	public String createString(String keyword) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetWithKeyword = keyword; 

		for (int i = 0; i<alphabet.length();i++) {
			if (keyword.indexOf(alphabet.charAt(i)) == -1) {
				alphabetWithKeyword = alphabetWithKeyword + alphabet.charAt(i);
			}
		}
//		System.out.println(alphabetWithKeyword); //print string to console to confirm correct string is returned, with keyword in front and 
												//letters not found in keyword, listed in alphabetical order thereafter
		return alphabetWithKeyword;
	}

	/*@Param String keywordFollowedByRestOfAlphabet - from the createString() method 
	 * Create the monoalphabetical cipher array
	 * Store the int representation for each char in the String with keyword + rest of alphabet in each index of the cipher array
	 */
	public void makeMonoAlphabeticalArray(String keywordFollowedByRestOfAlphabet) {
//		String s = "";
		for (int i = 0; i < this.monoAlphabeticArray.length; i++) {
			this.monoAlphabeticArray[i] = (int) keywordFollowedByRestOfAlphabet.charAt(i);
//			s = s + (char) this.monoAlphabeticArray[i] + " ";// Testing to make sure correct cipher array created
		}
//		System.out.print("Encrypted Order:    " + s + "\n");  print to console to check correct cipher array made
	}

	/*
	 * Create an alphabetical array used for decoding purposes
	 * The first index is set to 65, which is incremented by 1 for each following index
	 */
	public void makeAlphabeticArray() {
		int x = 65; //(int)('A') = 65;
//		String s = "";
		for (int i = 0; i < this.alphabeticArray.length; i++) {
			this.alphabeticArray[i] = x;
//			s = s + (char) this.alphabeticArray[i] + " ";// Testing to make sure correct alphabetical array created
			x++;
		}
//		System.out.println("Alphabetical Order: " + s); check to confirm correct a-z array made
	}

	/*
	 * Returns the int representation of the char in index x of the cipher array (encoding)
	 */
	public int getIntOfChar(int x) {
		return this.monoAlphabeticArray[x];
	}

	/*
	 * Returns the int representation of the char in index x of the alphabetical array (decoding)
	 */
	public int getIntOfCharInAlphabeticArray(int x) {
		return this.alphabeticArray[x];
	}

	/*@Param y = int representation of the char that is to be decoded
	 * Get the index number by iterating through each index of the cipher array and checking for equality  
	 */
	public int getNthIndex(int y) {
		int index = 0;
		for (int i = 0; i<this.monoAlphabeticArray.length; i++) {
			if (y == this.monoAlphabeticArray[i]) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * Encoding the string
	 * @Param String inputFile contains the lines of text from the file that has been read by Scanner in main
	 */
	public String encodeStringUsingMonoAlphabetArrayCipher(String inputFile) {
		String encryptedString = ""; 
		for (int i = 0; i < inputFile.length(); i++) {
			if ((int)inputFile.charAt(i) >=65 && (int) inputFile.charAt(i) <= 90) {//makes sure that we only consider capital letters of the alphabet
				int positionInAlphabet = (int) inputFile.charAt(i) - 65; //gets the number of the index of the cipher 'alphabet' (i.e. if charAti = Z(90), 90 - 65 = 25
				int letterToBeAdded = getIntOfChar(positionInAlphabet);//get the int representation of the char that is in index 25 of the cipher array
				encryptedString = encryptedString + (char) letterToBeAdded; //add the char to the encrypted string which will be written to file eventually
			} else { 
				encryptedString = encryptedString + inputFile.charAt(i); //if charAti is not a capital letter, we can just add it to the string to be encrypted
			}	
		}
//		System.out.print("Input Text:   " + inputFile);         // compare input text
//		System.out.print("Encrypted Text: " + encryptedString); // vs output text
		return encryptedString;
	}
	/*@Param String toBeDecoded contains the lines of text from the file that has been read by Scanner in main
	 *Method for decoding a string 
	 *
	 */
	public String decodeStringUsingMonoAlphabetArrayCipher(String toBeDecoded) {
		String decodedString = ""; 
		for (int j = 0; j < toBeDecoded.length(); j++) {
			if ((int)toBeDecoded.charAt(j) >=65 && (int) toBeDecoded.charAt(j) <= 90) {//makes sure that we only consider capital letters of the alphabet
				int ofLetterJ = (int) toBeDecoded.charAt(j); //gets the int representation of the charAtIndex(J) in the string to be decoded
				int indexNumberOfCharInAlphabeticalArray = getNthIndex(ofLetterJ); //returns the index number of charAtIndexJ in the cipher Array
				int letterToBeAdded1 = getIntOfCharInAlphabeticArray(indexNumberOfCharInAlphabeticalArray); //returns the int representation of the character in the alphabetical array at the same index
				decodedString = decodedString + (char)letterToBeAdded1; //add the character to the string to be written to file
			} else {
				decodedString = decodedString + toBeDecoded.charAt(j);//if charAtJ is not a capital letter, we can just add it to the string to be decoded
			}
		}
//		System.out.print("Input Text:   " + toBeDecoded);   //compare input
//		System.out.print("Decoded Text: " + decodedString); // vs output by printing to console
		return decodedString;
	}
}
