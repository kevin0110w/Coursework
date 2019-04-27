public class CheeseDecorator extends Decorator {

  public CheeseDecorator(Burger burger) {
    super(burger);
  }

  @Override
  public String getName() {
    return super.getName() + " with cheese";
  }

  @Override
  public double getPrice() {
    return super.getPrice() + 0.5;
  }
}
