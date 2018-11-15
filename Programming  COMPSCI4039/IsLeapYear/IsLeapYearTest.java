
public class IsLeapYearTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsLeapYear a = new IsLeapYear();
		a.setYear(1700);
		
		if (a.isLeapYear()) {
			System.out.println(a.getYear() + " is a leap year");
		} else {
			System.out.println(a.getYear() + " is not a leap year");
		}
		
		System.out.println(a.daysOfMonths("feb"));
	}

}
