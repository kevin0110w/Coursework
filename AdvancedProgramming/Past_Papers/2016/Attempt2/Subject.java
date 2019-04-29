import java.util.ArrayList;

public class Subject {
  private ArrayList<Observer> observers;
  private int noOfStudents;

  public Subject() {
    this.observers = new ArrayList<Observer>();
  }

  public void attach(Observer o) {
  this.observers.add(o);
  }

  public void setData(int no) {
    this.noOfStudents = no;
    this.notifyObservers();
  }

  public int getData() {
    return this.noOfStudents;
  }

  public void notifyObservers() {
    for (Observer o : this.observers) {
      o.notifyMe();
    }
  }
}
