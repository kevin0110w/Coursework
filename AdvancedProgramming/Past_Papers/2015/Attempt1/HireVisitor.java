public class HireVisitor implements MyVisitor {
  public void visit(Violin violin) {
    System.out.println("Violin Hire price: " + (violin.getPrice() * 0.5) + " - " + violin.getManufacturer());
  }

  public void visit(Trumpet trumpet) {
    System.out.println("Trumpet hire price: " + (trumpet.getPrice() * 0.1));
  }
}
