public class AlloyDecorator extends CarDecorator{
  public AlloyDecorator(Car car) {
  super(car);
  }

  public String getDesc() {
  return super.getDesc() + " with alloys";
  }

  public int getPrice() {
  return super.getPrice() + 500;
  }
}
