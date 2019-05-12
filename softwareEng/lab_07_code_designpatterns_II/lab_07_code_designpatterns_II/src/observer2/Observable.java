package observer2;

import java.util.ArrayList;

public abstract class Observable {
	
	protected ArrayList<Observer> observers;
	
	public Observable() {
		//  Instantiate observers here
		this.observers = new ArrayList<Observer>();
	}
	
	public void add(Observer me) {
		this.observers.add(me);
	}
	public void remove(Observer me) {
		this.observers.remove(me);
	}
	
	public abstract void notice();
	
}
