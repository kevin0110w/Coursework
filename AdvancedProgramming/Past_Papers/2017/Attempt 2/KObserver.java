import java.util.ArrayList;

public class KObserver implements Observer {
  private Subject subject;

  public KObserver(Subject s) {
    this.subject = s;
    this.subject.attachObserver(this);
  }

  @Override
  public void notifyMe() {
    ArrayList<Burger> burgers = this.subject.getData();
    for (Burger b : burgers) {
    System.out.println(b.getName());
    }
  }
} 
