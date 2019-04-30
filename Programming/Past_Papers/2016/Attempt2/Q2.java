public class Q2 {
  public static void main(String[] args) {
    System.out.println(factorial(2));
  }

  public static int factorial(int n) {
    if (n <= 1) {
      return n;
    } else {
      return n * factorial(n-1);
    }
  }
}
