public class Lada extends Car {
  public Lada(String name) {
    super(name);
    setPrice();
    makeCar();
  }

  public void setPrice() {
    super.price = 500;
  }

  @Override
  public void makeCar() {
    System.out.println("Car Model: " + super.getName() + ", Cost: " + super.getPrice());
  }
}
