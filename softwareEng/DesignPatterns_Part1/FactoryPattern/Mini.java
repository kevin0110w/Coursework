public class Mini extends Car {
  public Mini(String name) {
    super(name);
    setPrice();
    makeCar();
  }

  public void setPrice() {
    super.price = 10000;
  }

  @Override
  public void makeCar() {
    System.out.println("Car Model: " + super.getName() + ", Cost: " + super.getPrice());
  }
}
