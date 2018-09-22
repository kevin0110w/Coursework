/*
The double version of integer division. Write a program that for two doubles (a and b) it computes how many times b can fit into a, and the remainder. For example, if a = 4.2 and b = 1.6, then b can fit into a twice (2 x 1.6 = 3.2) with a remainder of 1.0 (4.2 minus 3.2).
*/
import java.util.*;

public class Exercise6vii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two 'double' numbers: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		sc.nextLine();
		
		int numberOfTimes = (int)(doubleCalc(a,b));
		double remainder = remainderCalc(a,b);
		System.out.println(b + " can fit into " + a + " " + numberOfTimes + " times with a remainder of " + remainder + ".");
		
		sc.close();
	}
	
	public static double doubleCalc(double a, double b) {
		int numberFit = (int) (a / b);
		return numberFit;
	}
	
	public static double remainderCalc(double a, double b) {
		double remainder = a - (doubleCalc(a, b) * b);
		return remainder;
	}
}
