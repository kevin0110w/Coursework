public class TestComponent {
  public static void main(String[] args) {
  Composite x = new Composite();
  Leaf y = new Leaf(9);
  Composite z = new Composite();
  Leaf a = new Leaf(5);
  Leaf b = new Leaf(2);
  x.addChild(y);
  z.addChild(a);
  z.addChild(b);
  x.addChild(z);
  System.out.println(x.getNumber());
  System.out.println(z.getNumber());
}}
