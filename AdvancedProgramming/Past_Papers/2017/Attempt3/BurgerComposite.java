import java.util.ArrayList;

public class BurgerComposite implements BurgerComponent {
  ArrayList<BurgerComponent> burgers;

  public BurgerComposite() {
    this.burgers = new ArrayList<BurgerComponent>();
  }

  public void addBurger(BurgerComponent b) {
    this.burgers.add(b);
  }

  public String getName() {
    System.out.println("This order: ");
    String s = "";
    for (BurgerComponent bc : this.burgers) {
      s = s + bc.getName() + "\n";
    }
    return s;
    }


  public double getPrice() {
    System.out.println("Order total: ");
    double p = 0;
    for (BurgerComponent bc : this.burgers) {
      p = p + bc.getPrice();
    }
    return p;
  }
}
