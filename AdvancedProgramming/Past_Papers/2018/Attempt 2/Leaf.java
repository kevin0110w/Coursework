public class Leaf implements Component {
  private int no;

  public Leaf(int n) {
    this.no = n;
  }

  @Override
  public int getMax() {
    return this.no;
  }
}
