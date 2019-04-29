public class Test {
  public static void main(String[] args) {
    BasicCar bc = new BasicCar();
    AlloyDecorator a = new AlloyDecorator(bc);
    CDDecorator cd = new CDDecorator(bc);
    AlloyDecorator c = new AlloyDecorator(cd);
    System.out.println(a.getDesc() + ": " + a.getPrice());
    System.out.println(cd.getDesc() + ": " + cd.getPrice());
    System.out.println(c.getDesc() + ": " + c.getPrice());
  }
}
