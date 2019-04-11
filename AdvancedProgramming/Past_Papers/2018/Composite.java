import java.util.ArrayList;

public class Composite implements Component {
  private ArrayList<Component> children;
  private int maxNumber;

  public Composite() {
    this.children = new ArrayList<Component>();
    this.maxNumber = 0;
  }

  public void addChild(Component aComponent) {
    this.children.add(aComponent);
  }

  @Override
  public int getNumber() {
    int temp = 0;
    for (Component x : this.children) {
      if (temp <= x.getNumber()) {
        temp = x.getNumber();
      }
    }
    this.maxNumber = temp;
    return this.maxNumber;
  }

}
