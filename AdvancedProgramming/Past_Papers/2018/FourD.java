public class FourD {
  private int x;

  public FourD(int x) {
    this.x = x;
  }
  public void setValue(int y) {
    this.x = y;
  }
  public String toString() {
    return Integer.toString(this.x);
  }

  public static void main(String[] args) {
    final FourD x = new FourD(3);
    FourD y = new FourD(4);
    System.out.println(x);
    x.setValue(5);
    System.out.println(x);
    System.out.println(y);
  }
}
