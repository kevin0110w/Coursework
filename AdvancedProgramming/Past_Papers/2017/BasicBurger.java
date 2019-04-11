public class BasicBurger extends Burger {
  private Double price;

  public BasicBurger() {
    this.price = 1.99;
  }

  @Override
  public Double getPrice() {
    return this.price;
  }

  @Override
  public String getDescription() {
    return "A basic burger";
  }
}
