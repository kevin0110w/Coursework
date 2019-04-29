public abstract class Decorator extends Burger {
  protected Burger burger;

  public Decorator(Burger burger){
    this.burger = burger;
  }

  public String getName() {
    return this.burger.getName();
  }

  public double getPrice() {
    return this.burger.getPrice();
  }
}
