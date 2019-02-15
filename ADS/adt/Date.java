package adt;

public class Date {
	private int y;
	private int m;
	private int d;

	public Date (int y, int m, int d ) {
		if (m < 1 || m > 12 || d < 1 || d > length(m, y)) throw new IllegalArgumentException("Improper Date");
		this.y = y;
		this.m = m;
		this.d = d;
	}
	public void advance(int n) {
		int y = this.y;
		int m = this.m;
		int d = this.d + n;
		int last;
		while (d > (last = length(m, y))) {
			d -= last;
			if (m<12) { 
				m++;
			} else {
				m = 1; 
				y++;
			}
		}
		this.y = y;
		this.m = m;
		this.d = d;
	}
	private int length(int m2, int y2) {
		int x = 0;
		switch (m2) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
			x = 31;
		}
		case 4: case 6: case 9: case 11:  {
			x = 30;
		}
		case 2:  {
			if (isLeap(y2)) {
				x = 29;
			} else {
				x = 28;
			}
		}
		}
		return x;
	}
		
	private boolean isLeap(int year) {
		return (year%4 == 0 && (y%100 != 0 || y%400 ==0));
	}
	
	private int getDay() {
		return this.d;
	}
	
	private int getMonth() {
		return this.m;
	}
	private int getYear() {
		return this.y;
	}
	
	private void setDay(int day) {
		if (day <= length(this.getMonth(), this.getYear())) {
			this.d = day;
		}
	}
	
	private void setMonth(int month) {
		if (this.d <= length(month, this.getYear())) {
			this.m = month;
		}
	}
	
	private void setYear(int year) {
		this.y = year;
	}
	
	public String toString() {
		return this.d + "/" + this.m + "/" + this.y;
	}
		
	public static void main(String[] args) {
		Date adate = new Date(1990, 10, 01);
		adate.advance(29);
		System.out.println(adate);
	}
}
