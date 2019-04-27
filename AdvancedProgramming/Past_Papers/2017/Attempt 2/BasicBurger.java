public class BasicBurger extends Burger {
  private String name;
  private double price;

  public BasicBurger() {
    this.name = "A Basic Burger";
    this.price = 1.99;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
