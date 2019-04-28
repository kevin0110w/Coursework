import java.util.ArrayList;

public class MusicalComposite implements Component {
  private ArrayList<Component> instruments;

  public MusicalComposite() {
  this.instruments = new ArrayList<Component>();
  }

  public void addInstrument(Component x) {
  this.instruments.add(x);
  }

  public void removeInstrument(Component x) {
  this.instruments.remove(x);
  }
  public void displayInformation() {
  for (Component x : this.instruments) {
    x.displayInformation();
  }
  }

  public int computeHirePrice() {
return 0;
  }

  public int getPrice() {
    int temp = 0;
    for (Component x : this.instruments) {
      temp += x.getPrice();
    }
    return temp;
  }
}
