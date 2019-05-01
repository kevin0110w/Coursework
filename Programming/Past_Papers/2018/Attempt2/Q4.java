public class Q4 {
  public static int recursion(int n) {
    if (n == 0) {
      return n;
    } else {
      return n + recursion(n-1);
    }
  }

  public static void main(String[] args) {
    System.out.println(recursion(10));
  }
}
