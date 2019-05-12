public abstract class Car {
  protected String name;
  protected int price;
  public Car(String name) {
    this.name = name;
  }
  public abstract void makeCar();
  public String getName() {
    return this.name;
  }

  public abstract void setPrice();
  public int getPrice() {
    return this.price;
  }
}
