public class Trumpet implements MyElement {
  private double price;
  private int stockLevel;

  public Trumpet() {
    this.price = 10.99;
  }
  public double getPrice() {
  return this.price;
  }

  public String getName() {
    return "Trumpet";
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
