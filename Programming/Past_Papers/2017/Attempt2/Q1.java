public class Q1 {
  public static void whileLoop() {
    int i = 1;
    int sum = 0;
    while (i <= 100) {
      sum += i;
      i++;
    }
    System.out.println(sum);
  }

  public static void doWhile() {
    int i = 1;
    int sum = 0;
    do {
      sum += i;
      i++;
    } while (i <= 100);
    System.out.println(sum);
  }
  public static void forLoop() {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }
    System.out.println(sum);
  }

  public static void main(String[] args) {
    whileLoop();
    doWhile();
    forLoop();
  }
}
