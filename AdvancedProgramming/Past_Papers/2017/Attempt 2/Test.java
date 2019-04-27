public class Test {
  public static void main(String[] args) {
    BasicBurger burger = new BasicBurger();
    CheeseDecorator c = new CheeseDecorator(burger);
    BaconDecorator b = new BaconDecorator(burger);
    BaconDecorator d = new BaconDecorator(new CheeseDecorator(burger));
    System.out.println(c.getName() + ": " + c.getPrice());
    System.out.println(b.getName() + ": " + b.getPrice());
    System.out.println(d.getName() + ": " + d.getPrice());
  }
}
