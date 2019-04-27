
public class TimesTable {
	private int number;
	
	public TimesTable(int number) {
		this.number = number;
	}
	
	public void setNumber(int number) { 
		this.number = number;
	}
	
	public String printTable() {
		String newLine = "";
		for (int i = 1; i <= 10; i++) {
			newLine += "Element " + i + ": " + this.number + " x " + i + " = " + (this.number * i) + "\n" ;
	}
		return newLine;
	
	}
	public String printTableUpTo(int upTo) {
		String newLine = "";
		for (int i = 1; i <= upTo; i++) {
			newLine += "Element " + i + ": " + this.number + " x " + i + " = " + (this.number * i) + "\n" ;
	}
		return newLine;
	
	}
	public String toString() {
		return "Times table of " + this.number + "?";
	}
}
