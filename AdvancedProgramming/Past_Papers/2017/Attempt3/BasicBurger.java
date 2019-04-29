public class BasicBurger extends Burger {
  private String name;
  private double price;

  public BasicBurger() {
    this.name = "Basic burger";
    this.price = 1.99;
  }

  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }
}
