/**
 * This class will create bond trade objects containing details for the firstValueOfaTrade, thirdValueOfaTrade and secondValueOfaTrade for each trade
 */

import java.util.ArrayList;

public class BondTrade {
	private double firstValueOfaTrade;
	private double secondValueOfaTrade;
	private double thirdValueOfaTrade;

	public BondTrade(double firstValueOfaTradeOfaTrade, double secondValueOfaTradeOfaTrade, double thirdValueOfaTradeOfaTrade) {
		this.firstValueOfaTrade = firstValueOfaTradeOfaTrade;
		this.secondValueOfaTrade = secondValueOfaTradeOfaTrade;
		this.thirdValueOfaTrade = thirdValueOfaTradeOfaTrade;
	}

	public double getFirstValueOfaTrade() {
		return this.firstValueOfaTrade;
	}

	public double getSecondValueOfaTrade() {
		return this.secondValueOfaTrade;
	}

	public double getThirdValueOfaTrade() {
		return this.thirdValueOfaTrade;
	}

	/**
	 * 
	 * @param comboBoxIndex chosen in the gui, determines which column, data is retrieved from
	 * @return either first, second or third  (i.e. either yield, days_to_maturity or amountCHF in example csv) 
	 * value associate with a trade which is determined by the selection in the combo box
	 */
	public double getValue(int comboBoxIndex) {
		if (comboBoxIndex == 0) {
			return this.firstValueOfaTrade;
		} else if (comboBoxIndex == 1) {
			return this.secondValueOfaTrade ;
		} else {
			return this.thirdValueOfaTrade;
		}
	}
}



