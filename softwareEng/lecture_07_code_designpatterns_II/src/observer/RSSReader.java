package src.observer;

public class RSSReader extends Observable {
	
	public RSSReader() {
		super();
	}

	public void add(Observer me) {
		this.observables.add(me);
		
	}

	public void remove(Observer me) {
		this.observables.remove(me);
		
	}

	public void notice() {
		for (Observer me : this.observables) {
			me.update();
		}		
	}

}
