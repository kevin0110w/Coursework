package observer2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class HollywoodTime extends Observable {
	
	Date hollywood;
	
	public HollywoodTime() {
		TimeZone timeZone = java.util.TimeZone.getTimeZone("GMT-8");
		Calendar calendar = java.util.Calendar.getInstance(timeZone);
		
		this.hollywood = calendar.getTime();
	}		

	//  The observable class keeps a list of the things it needs to give notice to when it updates.
	public void notice() {
		for (Observer observer: this.observers) {
			observer.update(this.hollywood);
		}
		
	}
	
	//  This method is the ongoing what that this observable gets updated.  This could be run in the main
	//  method of an instantiation of this class running as a service.
	public void updateHollywoodTime() {
		TimeZone timeZone = java.util.TimeZone.getTimeZone("GMT-8");
		Calendar calendar = java.util.Calendar.getInstance(timeZone);
		
		this.hollywood = calendar.getTime();
		this.notice();
	}


}
