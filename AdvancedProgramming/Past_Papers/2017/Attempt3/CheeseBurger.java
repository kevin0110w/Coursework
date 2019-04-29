public class CheeseBurger extends CompBurger implements BurgerComponent {
  protected CompBurger burger;

  public CheeseBurger(CompBurger burger) {
    this.burger = burger;
  }

  public String getName() {
    return super.getName() + " with cheese";
  }

  public double getPrice() {
    return super.getPrice() + 0.5;
  }
}
