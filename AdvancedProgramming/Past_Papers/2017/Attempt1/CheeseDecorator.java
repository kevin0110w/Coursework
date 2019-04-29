public class CheeseDecorator extends BurgerDecorator{
  public CheeseDecorator(Burger decoratedBurger) {
    super(decoratedBurger);
  }

  @Override
  public Double getPrice() {
    return super.getPrice() + .50;
  }
  @Override
  public String getDescription() {
    return super.getDescription() + " with cheese";
  }
}
