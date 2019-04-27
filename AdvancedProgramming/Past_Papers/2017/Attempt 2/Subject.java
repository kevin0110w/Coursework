import java.util.ArrayList;

public class Subject {
  private ArrayList<Observer> observers;
  private ArrayList<Burger> burgers;

  public Subject() {
    this.observers = new ArrayList<Observer>();
  }

  public void setData(ArrayList<Burger> burgers) {
    this.burgers = burgers;
    this.notifyObservers();
  }

  public ArrayList<Burger> getData() {
    return this.burgers;
  }

  public void attachObserver(Observer observer) {
    this.observers.add(observer);
  }

  public void notifyObservers() {
    for (Observer o : this.observers) {
      o.notifyMe();
    }
  }
}
