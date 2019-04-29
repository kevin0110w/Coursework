public class CompBurger implements BurgerComponent {
  protected String name;
  protected double price;

  public CompBurger() {
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
