public class DisplayVisitor implements MyVisitor {
  public void visit(Trumpet t) {
    System.out.println(t.getName() + ": " + t.getPrice());
  }

  public void visit(Violin v) {
  System.out.println(v.getName() + ": " + v.getPrice());
}
}
