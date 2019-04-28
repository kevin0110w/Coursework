public class Trumpet implements MyElement {
  private int price;
  private int StockLevel;
  public int getPrice() {
    return price;
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
