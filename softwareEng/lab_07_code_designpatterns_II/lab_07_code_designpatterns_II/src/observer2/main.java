package observer2;

public class main {

	public static void main(String[] args) throws InterruptedException {
		
		HollywoodTime hollywood = new HollywoodTime();
		Observer timeViewer = new TimeViewer();
		
		//  The observer must tell the observable thing it wants to subscribe to updates
		hollywood.add(timeViewer);
		
		//  Whenever something is updated in the observable, all the observers will be notified
		while (true) {
			hollywood.updateHollywoodTime();
			Thread.sleep(1000);
		}

	}

}
