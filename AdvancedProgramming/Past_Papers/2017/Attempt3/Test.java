public class Test {
  public static void main(String[] args) {
    // BasicBurger b = new BasicBurger();
    // CheeseDecorator c = new CheeseDecorator(b);
    // BaconDecorator bd = new BaconDecorator(b);
    // BaconDecorator bdd = new BaconDecorator(new CheeseDecorator(b));
    // System.out.println(c.getName() + c.getPrice());
    // System.out.println(bd.getName() + bd.getPrice());
    // System.out.println(bdd.getName() + bdd.getPrice());

    BurgerComposite bc = new BurgerComposite();
    CompBurger b = new CompBurger();
    CheeseBurger c = new CheeseBurger(b);
    bc.addBurger(b);
    bc.addBurger(c);
    System.out.println(c.getName() + c.getPrice());
    System.out.println(bc.getName() + bc.getPrice());
  }
}
