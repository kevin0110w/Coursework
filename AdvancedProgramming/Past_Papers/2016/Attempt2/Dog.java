public class Dog implements MyElement {
  private String name;
  private int legs;

  public Dog() {
    this.legs = 4;
    this.name = "dog";
  }

  public void accept(MyVisitor visitor) {
    visitor.visit(this);
  }

  public String getName() {
    return this.name;
  }

  public int getLegs() {
    return this.legs;
  }
}
