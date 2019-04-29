public class BaconDecorator extends Decorator {
  public BaconDecorator(Burger burger) {
    super(burger);
  }

  public String getName() {
    return super.getName() + " with bacon ";
  }

  public double getPrice() {
    return super.getPrice() + 0.99;
  }
}
