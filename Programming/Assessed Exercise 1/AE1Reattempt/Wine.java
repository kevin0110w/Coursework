public class Wine{
  private String name;
  private int quantity;
  private double price;

  public Wine(String name, int quantity, double price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public String getWineName() {
    return this.name;
  }

  public int getWineQuantity() {
    return this.quantity;
  }

  public double getWinePrice() {
    return this.price;
  }

  public String toString() {
    return this.name + "(£" + String.format("%4.2f", this.price) + "), " + this.quantity + " units";
  }
}
