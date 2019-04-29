public class HVisitor implements MyVisitor {
  public void visit(Trumpet t) {
    double x = computeHirePrice(t);
    System.out.println(x * 50);
  }

  public void visit(Violin v) {
  double x = computeHirePrice(v);
  System.out.println(x * 25);
  }

  public double computeHirePrice(MyElement element) {
    return element.getPrice();
  }
}
