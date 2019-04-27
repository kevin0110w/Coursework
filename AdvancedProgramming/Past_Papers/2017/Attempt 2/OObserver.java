import java.util.ArrayList;

public class OObserver implements Observer {
  private Subject subject;

  public OObserver(Subject s) {
    this.subject = s;
    this.subject.attachObserver(this);
  }

  @Override
  public void notifyMe() {
    ArrayList<Burger> burgers = this.subject.getData();
    double totalPrice = 0;
    for (Burger b : burgers) {
      totalPrice += b.getPrice();
    }
    System.out.println("Total Earnings: " + totalPrice);
  }
}
