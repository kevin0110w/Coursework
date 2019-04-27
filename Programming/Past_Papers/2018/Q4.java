public class Q4 {
  public static int recursive(int n) {
    if (n > 0) {
      return n + recursive(n-1);
    } else {
      return n;
    }
  }
  public static void main(String[] args) {
    System.out.println(recursive(10));
  }
}
