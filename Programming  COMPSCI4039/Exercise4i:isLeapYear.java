/*
Implement your code for computing if a particular year is a leap year. Test your code with a suitable set of test cases.
*/
public class Lab4Ex1 {
	public static void main(String[] args) {
		int year = 2356;
		boolean isLeapYear = false;
		
		if ((year % 4 == 0) && (year % 100 == 0)) {
			if ((year % 400 == 0)) {
				isLeapYear = true;
			}
			//isLeapYear = false;
		} else if ((year % 4 == 0) && (year % 100 != 0)) {
			isLeapYear = true;
		}
		else {
			isLeapYear = false;
		}
	

	
	if (isLeapYear) {
		System.out.println(year + " is a leap year.");
	} else {
		System.out.println(year + " is not a leap year.");
	}
}
}
