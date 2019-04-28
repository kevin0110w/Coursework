public class TrumpetLeaf implements Component {
  private int price;
  private int stockLevel;

  public int getPrice() {
    return price;
  }

  public void displayInformation(){
    System.out.println("trumpet");
  }

  public int computeHirePrice() {
    return 0;
  }
}
