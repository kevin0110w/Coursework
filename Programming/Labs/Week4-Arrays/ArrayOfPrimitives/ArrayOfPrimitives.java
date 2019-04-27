import java.lang.reflect.Array;
import java.util.Random;

public class ArrayOfPrimitives {
	public static void main(String[] args) {
/**
	//	Write a program that will create an array with 
//	length 100 and populate the array with random numbers between 0 and 
//	1. The following code will create a random number between 0 and 1.

	public static void main(String[] args) {
	double[] myArray = new double[100];
//	generally better to do int nElements = 100;
//	double[] myArray = new MyArray[nElements];
//	avoids hard coded declarations inside array, avoid 'magic numbers' 
//	can cause confusion
	
	Random random = new Random();
		
	for (int i = 0;i < myArray.length; i++) {
		myArray[i] = random.nextDouble();
//		System.out.println(myArray[i]);
	}
	
	System.out.println(mean(myArray));
	}
	
// Extended the solution to get the mean back when passing a array of double
	public static double mean(double[] a) {
		double sum = 0.0;
		double average = 0.0;
		for (int i = 0;i < a.length; i++) {
			sum += a[i];
		}
		average = sum/a.length;
		return average;
//		to return two ints or more than one from a method
//		create a class with those two ints and you can return an object
//		with those two instance variables*/
	
	int[] a = {1,2,3,3,4,3,4,5};
	int[] positions = (finder(a, 3));
	printArray(positions);
	positions=finder(a,4);
	printArray(positions);
	}

	
	public static int[] finder(int[] a, int e) { 
//		return an array of ints
		int[] storedArray = new int[a.length]; 
		//don't know how many occurences
		// we have right now. So we can create the new one with the 
		// same length as the array that is been passsed into this
		//method
		for (int i = 0; i < storedArray.length; i++) {
			storedArray[i] = -1;
		}
		int nextPos = 0;
		for (int i = 0; i<a.length; i++) {
			if (a[i] == e) {
				storedArray[nextPos] = i;
				nextPos++;
			}
		}
		return storedArray;
	}
	
	public static void printArray(int[] positions) {
		for (int i = 0; i<positions.length; i++) {
			if (!(positions[i] == -1)) {
			System.out.print(positions[i] + ", ");
			}
		}
		System.out.println();
	}
}
