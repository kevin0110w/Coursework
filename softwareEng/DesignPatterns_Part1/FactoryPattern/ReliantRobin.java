public class ReliantRobin extends Car {
  public ReliantRobin(String name) {
  super(name);
  setPrice();
  makeCar();
}

public void setPrice() {
  super.price = 1000;
}

@Override
public void makeCar() {
  System.out.println("Car Model: " + super.getName() + ", Cost: " + super.getPrice());
}
}
