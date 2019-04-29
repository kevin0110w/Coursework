public class Violin implements MyElement {
  private double price;
  private String manufacturer;
  private String recommendedStrings;
  private int stockLevel;

  public Violin() {
  this.price = 10.99;
  }
  public double getPrice() {
    return price;
  }

  public String getName() {
    return "Violin";
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
