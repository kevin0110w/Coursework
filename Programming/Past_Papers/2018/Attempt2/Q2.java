public class Q2 {
  public static void findPrimeNumbers(int start, int end) {
  boolean prime = true;
  for (int i = start; i <= end; i++) {
    for (int j = 1; j <= i; j++) {
      if (!(i % j == 0)) {
        prime = false;
        break;
      }
    }
    if (prime) {
      System.out.println(i + " is prime");
    }
    prime = true;
  }
}

  public static void main(String[] args) {
    findPrimeNumbers(1, 100);
  }
}
