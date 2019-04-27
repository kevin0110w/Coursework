
public class IsLeapYear {
	private int year;

	public IsLeapYear(int year) {
		setYear(year);
	}
	
	public IsLeapYear() {
		setYear(0);
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isLeapYear() {
		boolean isLeapYear = false;
		if (this.year % 4 == 0 && this.year % 100 == 0 && this.year % 400 == 0) {
			isLeapYear = true;
		} else if (this.year % 4 == 0 && this.year % 100 != 0) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}
		return isLeapYear;
	}
	
	public int daysOfMonths(String month) {
		if (month.equals("jan") || month.equals("mar") || month.equals("may") || month.equals("jul") ||
				month.equals("aug") || month.equals("oct")|| month.equals("dec")) {
			return 31;
		} else if (month.equals("apr") || month.equals("jun") || month.equals("sep") ||
				month.equals("nov")) {
			return 30; 
		} else if (this.isLeapYear()) {
			return 29;
		} else {
			return 28;
		}
	}
}
