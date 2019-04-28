public class HireVisitor implements MyVisitor {
  public void visit(Violin violin) {
System.out.println("violin");
  }

  public void visit(Trumpet trumpet) {
    System.out.println("trumpet");
  }
}
