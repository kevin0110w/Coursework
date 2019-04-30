public class Prime {

  public static void findPrimeNumbers(int n) {
    for (int i = 1; i <= n; i++) {
      if (!prime(i)) {
        System.out.print(i + " ");
      }
    }
  }

    public static boolean prime(int number) {
      boolean prime = false;
      for (int i = 2; i < number; i++) {
        if (number % i == 0 || number == 1) {
          prime = true;
          break;
        }
      }
      return prime;
    }

    public static void main(String[] args) {
      findPrimeNumbers(10);
    }
}
