/*Write a method that pads a String with a character of the users choice to make it up to a particular length. E.g. if I want to pad the string “Simon” with @ characters to make it a total of 10 characters, I would get:
    @@@@@Simon
Your method should take three arguments: the String, the padding character, and the total length desired. Note that for some String s, you can get its length (as an integer) using: s.length();

*/

import java.util.*;

public class Exercise6viii {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose a string of your choice: ");
		String string = sc.nextLine();
		System.out.println("Please choose a padding character: ");
		String paddingChar = sc.nextLine();
		System.out.println("Please choose the total length: ");
		int totalLength = Integer.parseInt(sc.nextLine());
		
		System.out.println(paddingString(string, paddingChar, totalLength));
		
		sc.close();
	}
	
	public static String paddingString(String string, String paddingChar, int totalLength) {
		String newWord = "";
		int remainingLength = totalLength - string.length();
		for (int i = 0; i <= remainingLength; i++) {
			newWord += paddingChar;
		}
		return newWord += string;
	}
}
