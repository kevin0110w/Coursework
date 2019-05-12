package observer;

import java.util.ArrayList;

public abstract class Observable {
	
	protected ArrayList<Observer> observables;
	
	public Observable() {
		//  Instantiate obervables here
		this.observables = new ArrayList<Observer>();
	}
	
	public abstract void add(Observer me);
	public abstract void remove(Observer me);
	public abstract void notice();
	
}
