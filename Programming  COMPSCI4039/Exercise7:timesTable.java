/*
In the previous exercises, you wrote a program that could show entries in a times table. Modify your code so that it works for double as well as int. E.g. the your code should be able to show the times table for any double number (e.g. 8.24579). To display the results use String.format, specifying the format string for the doubles so that the layout works well even when we get a long way through the table. Assume that the number you’re computing the times table for is between 0 and 99 and that the maximum term you’ll go up to is 99. The output should look like:
~~.~~~ x ~~ = ~~~~~.~~~
    where the ~ show how wide each field should be. Write this as a method.
In the previous exercise we assumed various ranges for the values passed to the times table method. Add some conditions to the start of the function that check whether or not these conditions are met, and only draw the table if they are. You might find it useful to know that you can use the command return; to jump out of a method at any time (a bit like break does for loops).
*/


import java.util.Scanner;

public class Lab7Ex1 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter an number");
	double a = scanner.nextDouble();
	//System.out.println("Please enter how many entries you would like to see");
	//int numberOfTimes = scanner.nextInt();
	timesTable(a);
	//for (int i = 0; i <= 10; i++) {
	//	System.out.println(a + " times " + i + " = " + (a*i));
	//}
	
	scanner.close();
}

	public static void timesTable(double value) {
		if (value >= 0 && value <= 99) {
		for (int i = 0; i <= 99; i++) {
			double result = value * i;
			String line = String.format("%9.3f",result);
			String value1 = String.format("%9.3f", value);
			System.out.println(value1 + " times " + i + " = " + line);
			}
		}
	}
}
