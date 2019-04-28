public class Violin implements MyElement {
  private int price;
  private String manufacturer;
  private String recommendedStrings;
  private int stockLevel;

  public Violin(int price, String manufacturer) {
    this.manufacturer = manufacturer;
    this.price = price;
  }
  public int getPrice() {
    return this.price;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }
}
