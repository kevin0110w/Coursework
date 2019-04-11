public abstract class BurgerDecorator extends Burger {
  protected Burger decoratedBurger;

  public BurgerDecorator(Burger decoratedBurger) {
    this.decoratedBurger = decoratedBurger;
  }
  @Override
  public Double getPrice() {
    return this.decoratedBurger.getPrice();
  }
  @Override
  public String getDescription() {
    return this.decoratedBurger.getDescription();
  }
}
