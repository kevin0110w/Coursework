public class Q2 {


  public static void getMultiples(int start, int stop, int divisor) {
    int k = 0;
    for (int i = start; i <= stop; i++) {
      if (i % divisor == 0) {
        System.out.println("Integer " + i + " can be divided exactly by " + divisor + ": " + i + "/" + divisor + "=" + (i/divisor));
        k++;
      }
    }
    System.out.println("Between " + start + "and " + stop + "there are " + k + "numbers that can be divided exactly by " + divisor);
  }

  public static void main(String[] args) {
    getMultiples(1, 100, 7);
  }

}
