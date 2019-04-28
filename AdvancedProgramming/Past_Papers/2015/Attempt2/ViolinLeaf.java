public class ViolinLeaf implements Component {
  private int price;
  private String manufacturer;
  private String recommendedStrings;
  private int stockLevel;

  public int getPrice() {
  return price;
  }

  public int computeHirePrice() {
  return 0;
  }

  public void displayInformation() {
  System.out.println("violin");
  }
}
