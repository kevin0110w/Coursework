public class OverloadedTest {
  public static void main(String[] args) {
    int a = 2;
    int b = a;
    a = returnNumber(a);
    System.out.println(a);
    a = returnNumber(a, b);
    System.out.println(a);
  }

  public static final int returnNumber(int x) {
    return 2*x;
  }

  public static final int returnNumber(int x, int y) {
    return x*y;
  }
}
