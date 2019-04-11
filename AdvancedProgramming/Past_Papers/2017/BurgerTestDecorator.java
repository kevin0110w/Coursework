import java.util.HashMap;
import java.util.Random;
public class BurgerTestDecorator {
  public static void main(String[] args) {
	  Random rand = new Random();
	  int i = 0;
		 Burger burger = new BasicBurger();	  
//	    System.out.println(burger.getDescription() + ": £" + burger.getPrice());
	    Burger cheese = new CheeseDecorator(new BasicBurger());
//	    System.out.println(cheese.getDescription() + ": £" + cheese.getPrice());
	    Burger meal = new MealDecorator(new BasicBurger());
//	    System.out.println(meal.getDescription() + ": £" + meal.getPrice());
	    Burger bacon = new BaconDecorator(new BasicBurger());
//	    System.out.println(bacon.getDescription() + ": £" + bacon.getPrice());
	    Subject s = new Subject();
	    HashMap<Burger, Integer> orders = new HashMap<Burger, Integer>();
	    orders.put(burger, 0);
	    orders.put(cheese, 0);
	    orders.put(meal, 0);
	    orders.put(bacon, 0);
	    new BurgerDataObserver(s);
	    s.setData(orders);
	    Integer value = 0;
	  while (i < 10) {
		  int j = rand.nextInt(3)+1;
		  if (j == 1) {
			   value = orders.get(burger);
			  if (value == null) {
				  value = 0;
			  }
			  value++;
			  orders.put(burger, value);
		  } else if (j == 2) {
			   value = orders.get(cheese);
			  if (value == null) {
				  value = 0;
			  }
			  value++;
			  orders.put(cheese, value);
		  } else if (j == 3) {
			   value = orders.get(bacon);
			  if (value == null) {
				  value = 0;
			  }
			  value++;
			  orders.put(bacon, value);
		  } else  {
			   value = orders.get(meal);
			  if (value == null) {
				  value = 0;
			  }
			  value++;
			  orders.put(meal, value);
		  }
		  i++;
	  }
	  s.setData(orders);
  }
}
