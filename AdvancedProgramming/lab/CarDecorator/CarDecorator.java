public abstract class CarDecorator extends Car {
  protected Car car;

  public CarDecorator(Car car) {
  this.car = car;
  }

  public String getDesc() {
    return this.car.getDesc();
  }

  public int getPrice() {
  return this.car.getPrice();
  }
}
