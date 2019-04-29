public class Human implements MyElement {
  private String name;
  private int legs;

  public Human() {
    this.name = "human";
    this.legs = 2;
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }

  public int getLegs() {
    return this.legs;
  }

  public String getName() {
    return this.name;
  }
}
