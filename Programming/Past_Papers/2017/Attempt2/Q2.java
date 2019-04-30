public class Q2 {
  public static boolean isRoosterYear(int year) {
    boolean rooster = false;
    for (int i = 1909; i <= 2017; i+=12) {
      if (year == i) {
        rooster = true;
      }
    }
    return rooster;
  }

  public static void main(String[] args) {
    System.out.println(isRoosterYear(1909));
    System.out.println(isRoosterYear(1921));
    System.out.println(isRoosterYear(1945));
    System.out.println(isRoosterYear(2016));
  }
}
