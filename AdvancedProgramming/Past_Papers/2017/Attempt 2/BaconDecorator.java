public class BaconDecorator extends Decorator {
  public BaconDecorator(Burger burger) {
    super(burger);
  }

  @Override
  public String getName() {
    return super.getName() + " with bacon";
  }

  @Override
  public double getPrice() {
    return super.getPrice() + 1;
  }
}
