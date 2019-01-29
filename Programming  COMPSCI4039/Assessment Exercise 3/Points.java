/**
 * This class is used to create each point for each bond trade for the graph once the appropriate calculations have been undertaken
 * to get it on the graph area
 * @author Freckles
 *
 */
public class Points {
	private double x;
	private double y;
	private double radius;
	private double firstValueOfaTrade;
	private double secondValueOfaTrade;
	private double thirdValueOfaTrade;

	/**
	 * 
	 * @param x is the percentage difference, based on min and max values of a selected column, for a value of a bond trade in that column that is selected as the xaxis
	 * @param x is the percentage difference, based on min and max values of a selected column, for a value of a bond trade in that column that is selected as the yaxis
	 * @param r is the value of the radius
	 * @param firstValueOfaTrade is the firstValueOfaTrade value associated with this bond trade
	 * @param secondValueOfaTrade is the secondValueOfaTrade value associated with this bond trade
	 * @param thirdValueOfaTrade is the thirdValueOfaTrade value associated with this bond trade
	 * These last three values are used for the purposes of the mouseclick listener in the window class
	 */
	public Points(double x, double y, double r, double firstValueOfaTrade, double secondValueOfaTrade, double thirdValueOfaTrade) {
		this.x = x;
		this.y = y;
		this.radius = r;
		this.firstValueOfaTrade = firstValueOfaTrade;
		this.secondValueOfaTrade = secondValueOfaTrade;
		this.thirdValueOfaTrade = thirdValueOfaTrade;
	}
	//return x coordinate which will later be manipulated to fit the window
	public double getX() {
		return this.x;
	}
	//return y coordinate which will later be manipulated to fit the window
	public double getY() {
		return this.y;
	}
	//return radius value
	public double getRadius() {
		return this.radius;
	}
	//return first value associated with a trade (yield in example csv file) of a bond trade 
	public double getFirstValueOfaTrade() {
		return this.firstValueOfaTrade;
	}

	// return second value associated with a trade (daysToMaturity in example csv file) of a bond trade 
	public double getSecondValueOfaTrade(){
		return this.secondValueOfaTrade;
	}

	// return third value  associated with a trade (amountCHF(000) in example csv file)  of a bond trade 
	public double getThirdValueOfaTrade() {
		return this.thirdValueOfaTrade;
	}

}
