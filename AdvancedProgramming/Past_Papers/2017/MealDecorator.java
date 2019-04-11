public class MealDecorator extends BurgerDecorator{
  public MealDecorator(Burger decoratedBurger) {
    super(decoratedBurger);
  }
  @Override
  public Double getPrice() {
    return super.getPrice() + 2.00;
  }
  @Override
  public String getDescription() {
    return super.getDescription() + " meal deal";
  }
}
