public class CheeseDecorator extends Decorator {
  public CheeseDecorator(Burger burger) {
    super(burger);
  }

  public String getName() {
    return super.getName() + " with cheese ";
  }

  public double getPrice() {
    return super.getPrice() + 0.5;
  }
}
