import java.util.*;

public class ObserverPatternTest {
  public static void main(String[] args) {
    ArrayList<Burger> order = new ArrayList<Burger>();
    BasicBurger b = new BasicBurger();
    order.add(b);
    order.add(new CheeseDecorator(b));
    order.add(new BaconDecorator(b));
    order.add(new BaconDecorator(new CheeseDecorator(b)));
    Subject subject = new Subject();
    OObserver owner = new OObserver(subject);
    KObserver kitchen = new KObserver(subject);
    subject.setData(order);
    order.remove(1); // remove the cheese burger one.
    subject.setData(order);
  }
}
