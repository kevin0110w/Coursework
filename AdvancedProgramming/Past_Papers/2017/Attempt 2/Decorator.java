public abstract class Decorator extends Burger {
  protected Burger burger;
  public Decorator(Burger burger) {
    this.burger = burger;
  }

  @Override
  public String getName() {
    return this.burger.getName();
  }

  @Override
  public double getPrice() {
    return this.burger.getPrice();
  }
}
