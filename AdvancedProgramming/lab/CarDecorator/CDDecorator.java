public class CDDecorator extends CarDecorator {
  public CDDecorator(Car car) {
  super(car);
  }

  public int getPrice() {
  return super.getPrice() + 250;
  }

  public String getDesc() {
  return super.getDesc() + " with a CD Player";
  }
}
