public class Trumpet implements MyElement {
  private int price;
  private int stockLevel;

  public Trumpet(int price) {
    this.price = price;
  }
  public int getPrice() {
    return this.price;
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
