import java.util.List;
import java.util.ArrayList;

public class Composite implements Component {
  private List<Component> children;

  public Composite() {
    this.children = new ArrayList<Component>();
  }

  public void addComp(Component x) {
    this.children.add(x);
  }

  @Override
  public int getMax() {
    int temp = 0;
    for (Component x : this.children) {
      if (x.getMax() >= temp) {
        temp = x.getMax();
      }
    }
    return temp;
  }
}
