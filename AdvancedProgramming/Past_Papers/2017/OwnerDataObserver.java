import java.util.HashMap;

public class OwnerDataObserver extends Observer {
  private Subject subject;

  public OwnerDataObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void notifyMe() {
    HashMap<Burger, Integer> orders = new HashMap<Burger, Integer>();
    orders = subject.getOrder();
    double total = 0.0;
    for (Burger order : orders.keySet()) {
      total += orders.get(order) * order.getPrice();
    }
    System.out.println(String.format("%-15s %-4.2f", "Total Gross Amount: £", total));
  }
}
