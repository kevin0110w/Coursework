/*Write some code that, given a month (encoded as the first three letters of the month’s name as a String, e.g. Jan, Feb, Mar, etc) and an integer for the year, prints out how many days there are in the month. E.g. if the month is Mar, it has 31 days, if Sep, 30 days, if Feb, 28 or 29 depending on if it is a leap year. Hint, you might want to use or (||) to test for multiple months at once (e.g. detect if it is one of the ones with 30 days)
Refactor again so that the code for the number of days in the month is its own method, that itself calls the method to determine if it is a leap year or not. This new method will be passed two arguments (the String for the month and the int for the year) and will return an int (the number of days in the month).
*/

public class Lab4Ex4 {
	public static void main(String[] args) {
		int year = 2356;
		String month = "Jan";
		
		
		System.out.println(calcLeapYear(year));
		System.out.println(numberOfDays(month, year));
		
		 year = 1700;
		 month = "Feb";
		
		System.out.println(calcLeapYear(year));
		System.out.println(numberOfDays(month, year));
		
		 year = 2000;
		 month = "Feb";
		
		System.out.println(calcLeapYear(year));
		System.out.println(numberOfDays(month, year));
		
	}
		
	public static boolean calcLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 == 0)) {
			if ((year % 400 == 0)) {
				return true; //is a leap year
			}
		} else if ((year % 4 == 0) && (year % 100 != 0)) {
			return true; //is a leap year
		}
		else {
			return false; //is not a leap year
		}
		return false;//is not a leap year
	}
	
	public static int numberOfDays(String month, int year) {
		if (month.equals("Jan") || month.equals("Mar") || 
				month.equals("May") || month.equals("Jul") ||
				month.equals("Aug") || month.equals("Oct") ||
				month.equals("Dec")) {
			return 31;
		} else if (month.equals("Apr") || month.equals("Jun")
				|| month.equals("Sep") || month.equals("Nov")) {
			return 30;
		} else if (month.equals("Feb") && (calcLeapYear(year))) {
			return 29;
		} else {
			return 28;
		}
	}
	
}
