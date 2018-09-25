import java.util.Scanner;
import java.util.Calendar;

public class Lab4Ex6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter your date of birth: ");
		int day = s.nextInt();
		int month = s.nextInt();
		int year = s.nextInt();
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		s.close();
		printBirthYear(day, month, year);
	}
	
	public static int calculateDifferenceYear(int day, int month, int year) {
		int thisDay = Calendar.getInstance().get(Calendar.DATE);
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if ((thisYear >= year) && (thisMonth >= month) && (thisDay >= day)) {
			return thisYear - year;
		} else if ((thisYear >= year) && (thisMonth < month)) {
			return thisYear - year - 1;
		} else if ((thisYear >= year) && (thisDay < day) && (thisMonth == month)) {
			return thisYear - year - 1;
		}
		return 0;
	}
		
		public static void printBirthYear(int day, int month, int year) {
			System.out.println("The difference in birth year is " + calculateDifferenceYear(day, month, year));
		}
}
