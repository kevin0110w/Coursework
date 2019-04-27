public class AssertionExample {
  private int myInt;

  public AssertionExample(int n) {
    this.myInt = n;
  }

  public void decrement(int d) {
    assert this.myInt >= d;
    this.myInt = this.myInt - d;
  }

  public static void main(String[] args) {
    AssertionExample a = new AssertionExample(5);
    a.decrement(10);
    System.out.println(a.myInt);
  }
}
