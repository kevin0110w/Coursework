/**
 * This class will create a String version of the values for each bond trade  which will be held in a list
 * Each row will then be converted to a BondTrade object to be held in an arraylist of type BondTrade
 *
 */
public class StringList {
	private String firstValue;
	private String secondValue;
	private String thirdValue;
	public StringList(String firstValue, String secondValue, String thirdValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.thirdValue = thirdValue;
	}
	public String getFirstValue() {
		return this.firstValue ;
	}
	public String getSecondValue() {
		return this.secondValue;
	}
	public String getThirdValue() {
		return this.thirdValue;
	}
}
