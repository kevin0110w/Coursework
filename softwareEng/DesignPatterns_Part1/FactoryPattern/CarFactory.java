public class CarFactory implements CarBuilder {
  private Car car;

  public Car buildCar(String carName) {
    if (carName.equals("Mini")) {
      car = new Mini(carName);
    } else if (carName.equals("ReliantRobin")) {
      car = new ReliantRobin(carName);
    } else if (carName.equals("Lada")) {
      car = new Lada(carName);
    }
    else {
      System.out.println("Invalid car name provided");
      car = null;
    }
    return car;
  }
}
