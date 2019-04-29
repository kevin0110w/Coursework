public class BaconDecorator extends BurgerDecorator{
  public BaconDecorator(Burger decoratedBurger) {
    super(decoratedBurger);
  }
  @Override
  public Double getPrice() {
    return super.getPrice() + 1.00;
  }
  @Override
  public String getDescription() {
    return super.getDescription() + " with bacon";
  }
}
