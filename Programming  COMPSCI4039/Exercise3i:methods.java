/*Write a short program that has a main method that prints a message into the console.
Refactor your code so that you write a method that does the printing, and your main method calls that method instead of doing the printing itself. Don’t worry about passing anything to the method, just define the text to be displayed in the method.
Improve your code from the previous part so that the text to be displayed is passed to the method when it is called by the main method.
*/

public class Lab3Ex1 {
	public static void main (String[] args) {
		String str = "hello";
		print(str);
	}
	
	public static void print(String string) {
		//String str = "test";
		System.out.println(string);
	}
}
