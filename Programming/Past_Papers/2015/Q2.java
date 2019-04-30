public class Q2 {

  public static void getMultiples(int start, int stop, int divisor) {
    int p = 0;
    for (int i = start; i <= stop; i++) {
      if (i % divisor == 0) {
        System.out.println("Integer " + i + " can be divided exactly by " + divisor + ": " + i + "/" + divisor + "=" + (i/divisor) + "");
        p++;
      }
    }
    System.out.println("Between " + start + " and " + stop + " there are " + p + " numbers that can be divided exactly by " + divisor + "");
  }

  public static void main(String[] args) {
    getMultiples(1, 100, 7);
  }
}
