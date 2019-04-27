public class CompositeTest {
  public static void main(String[] args) {
    Composite top = new Composite();
    // Leaf nine = new Leaf(9);
    Leaf one = new Leaf(1);
    Composite mid = new Composite();
    Leaf five = new Leaf(5);
    Leaf two = new Leaf(2);
    // mid.addComp(five);#
    mid.addComp(one);
    mid.addComp(two);
    // top.addComp(nine);
    top.addComp(mid);
    top.addComp(one);
    System.out.println(top.getMax());
  }
}
