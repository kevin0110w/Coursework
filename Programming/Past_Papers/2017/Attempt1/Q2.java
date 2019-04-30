public class Q2 {
  public static void main(String[] args) {
    System.out.println(isRooster(1909));
    System.out.println(isRooster(1921));
    System.out.println(isRooster(1933));
    System.out.println(isRooster(1934));
  }

  public static boolean isRooster(int n) {
    boolean rooster = false;
    if (n < 1900 || n > 2017) {
      rooster = false;
    } else {
    for (int i = 1909; i <= 2017; i+=12) {
      if (i == n) {
        rooster = true;
      }
    }
    }
  return rooster;
  }
}
