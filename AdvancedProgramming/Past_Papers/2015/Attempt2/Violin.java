public class Violin implements MyElement {
  private int price;
  private String manufacturer;
  private String recommendedStrings;
  private int stockLevel;
  public int getPrice() {
    return price;
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
