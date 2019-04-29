import java.util.ArrayList;
import java.util.HashMap;

public class Subject {
  private ArrayList<Observer> observers = new ArrayList<Observer>();
  private HashMap<Burger, Integer> orders = new HashMap<Burger, Integer>();

  public void setData(HashMap orders) {
    this.orders = orders;
    this.notifyAllObservers();
  }

  public HashMap<Burger, Integer> getOrder() {
    return this.orders;
  }
  public void attach(Observer observer) {
    this.observers.add(observer);
  }

  public void notifyAllObservers() {
      for (Observer observer : this.observers ) {
        observer.notifyMe();
    }
  }
}
