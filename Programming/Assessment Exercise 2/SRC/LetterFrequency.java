/* @author 0808148w
 * This class is for constructing the letter frequency table
 */
import java.util.Scanner;

public class LetterFrequency {
	private double sum; // counts total number of capital letters that appear in the string to be written to file
	private double[] countLetter; //counts the frequency of each letter in the output text. Each index is for each letter a -> z
	private double[] alphabetArray; //this array is for the first column of the table
	private double[] avgCounts; //avgCounts as provided with the specs
	private double[] freqPercent; //to store the frequency that a letter appears as a %
	private double[] diff; // the different between the avgcount and the frequency%
	private static final int ARRAY_SIZE = 26;

	public LetterFrequency(String outputString) {
		this.sum = 0;
		this.countLetter = new double[ARRAY_SIZE]; 
		this.alphabetArray = new double[ARRAY_SIZE];
		populateAlphabetArrayinInts(); //populate the array that'll be used to display each alphabet as an int representation in each row i.e. 65 -> 90
		this.avgCounts = new double[] {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
			       0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
				   6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};
		this.freqPercent = new double[ARRAY_SIZE];
		this.diff = new double[ARRAY_SIZE];
		countLetterFreq(outputString); // populate the array with the frequency count of each letter in each index (i.e if A appears 5 times, countLetter[0] == 5, Z appears 2 times, 
										//countLetter[25] == 2). 
		populateFreqPercentArray(); //populate the array with the frequency that each letter appears as a % of the total number of capital letters in output file
		populateDiffArray(); //populate the array with the difference between the avgCount and frequency % for each letter
	}
	
	/*
	 * This method is used to populate an array of length 26 with the alphabet, an int representation of each alphabet (65 - 90 inclusive) is stored in each index
	 * This changes this.object's instance variable
	 */
	public void populateAlphabetArrayinInts() {
		int x = 65; // start with A. (char) 65 = A.
		for (int i = 0; i<alphabetArray.length;i++) {
			this.alphabetArray[i] = x;
			x++;
		}
	}
	 /* This method counts the frequency that each letter appears in the output text
	 * a switch statement is used so that if the character matches exactly, it can break out the loop
	 * rather than iterate through the alphabet each time
	*/
	public void countLetterFreq(String outputString) {
		for (int i = 0; i < outputString.length(); i++) {
			char letter = outputString.charAt(i);
			switch (letter) {
			case 'A' : this.countLetter[0]++; sum++; break; //Frequency of A
			case 'B' : this.countLetter[1]++; sum++; break;
			case 'C' : this.countLetter[2]++; sum++; break;
			case 'D' : this.countLetter[3]++; sum++; break;
			case 'E' : this.countLetter[4]++; sum++; break;
			case 'F' : this.countLetter[5]++; sum++; break;
			case 'G' : this.countLetter[6]++; sum++; break;
			case 'H' : this.countLetter[7]++; sum++; break;
			case 'I' : this.countLetter[8]++; sum++; break;
			case 'J' : this.countLetter[9]++; sum++; break;
			case 'K' : this.countLetter[10]++; sum++; break;
			case 'L' : this.countLetter[11]++; sum++; break;
			case 'M' : this.countLetter[12]++; sum++; break;
			case 'N' : this.countLetter[13]++; sum++; break;
			case 'O' : this.countLetter[14]++; sum++; break;
			case 'P' : this.countLetter[15]++; sum++; break;
			case 'Q' : this.countLetter[16]++; sum++; break;
			case 'R' : this.countLetter[17]++; sum++; break;
			case 'S' : this.countLetter[18]++; sum++; break;
			case 'T' : this.countLetter[19]++; sum++; break;
			case 'U' : this.countLetter[20]++; sum++; break;
			case 'V' : this.countLetter[21]++; sum++; break;
			case 'W' : this.countLetter[22]++; sum++; break;
			case 'X' : this.countLetter[23]++; sum++; break;
			case 'Y' : this.countLetter[24]++; sum++; break;
			case 'Z' : this.countLetter[25]++; sum++; break;//Frequency of Z
			default: break;
			}
		}
	}
	/*
	 * This method is used to populate an array of length 26 with the frequency% that an alphabet appears in the output text
	 * This method uses the results from countLetterFreq() which populated each array index with the no. of times at which a letter appeared in the output text
	 * I found out that a 'NaN' is written in an index in output file if 0 / sum calculation done, therefore made sure 
	 * the index for freqPercent% gets 0 value as a minimum. This also ensures no NaN values written in Diff% column.
	 */
	public void populateFreqPercentArray() {
		for (int i = 0; i < freqPercent.length; i++) {
			if (this.countLetter[i] == 0) {
				this.freqPercent[i] = 0;
			} else {
				this.freqPercent[i] = (this.countLetter[i] / this.sum) * 100;
			}
		}
	}
	/*
	 * This method is used to populate an array of length 26 with the difference% that an alphabet appears in the output text, between the avgCount and freq%
	 * This method uses the results from populateFreqPercentArray() which populated each array index with the freq% that each letter appeared in the output text
	 */
	public void populateDiffArray() {
		for (int i = 0; i < diff.length; i++) {
			this.diff[i] = this.freqPercent[i] - this.avgCounts[i];
		}
	}
	
	/*
	 * This method returns the frequency table as a String
	 */
	public String createLetterFrequencyTable() {
		String output = "LETTER ANALYSIS \n \n"; // heading followed by two new lines
		output = output + "Letter  Freq   Freq%   AvgFreq%   Diff  \n"; //add to the string with the column headings
		double[][] y = {this.alphabetArray, this.countLetter, this.freqPercent, this.avgCounts, this.diff}; //create a multidimensional array (array of arrays) by adding the various other 1D arrays
		double max = y[2][0]; // assume at the start that the Freq% of A(row 3, index 0) is highest and set to max
		int character = 0; //get the index of the letter with the highest freq%
		for (int i = 0; i < y[0].length; i++) { //this iterates through 0 - 25 inclusive
			if (y[2][i] >= max) { 
				max = y[2][i];  // if another letter has the same frequency% as A but appears later in alphabet, max will be overwritten. 
				character = i;
			}
			output = output + String.format("%3s", (char)y[0][i]) + " " + String.format("%7d", (int) y[1][i]) + " " +  String.format("%8.1f", y[2][i]) + " " + String.format("%7.1f", y[3][i]) + " " + String.format("%9.1f", y[4][i]) + "\n";
		}   // need to invert the table and format, can't use a nested for loop here due to the different format style per column
//		System.out.println("The most frequent letter is " + (char)y[0][character] + " at " + String.format("%.2f", max) + "%"); check getting right letter
		output = output + "\n" + "The most frequent letter is " + (char)y[0][character] + " at " + String.format("%.1f", max) + "%";
		return output;
	}
}


