package observer2;

import java.util.Date;

public class TimeViewer implements Observer {

	//  The observer waits until its update method is call to recieve the latest data from
	//  whatever it is observing 
	
	public void update(Date time) {
		// TODO Auto-generated method stub
		System.out.println("Current Time is: " + time.toString());
		
	}

}
