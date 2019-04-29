import java.util.HashMap;

public class BurgerDataObserver extends Observer {
	
    public BurgerDataObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
    }

    public void notifyMe() {
    	HashMap<Burger, Integer> orders = new HashMap<Burger, Integer>();
    	orders = subject.getOrder();
    	for (Burger order : orders.keySet()) {
    		System.out.println(order.getDescription() + ": " + orders.get(order) + " quantities");
      }
    }
}
