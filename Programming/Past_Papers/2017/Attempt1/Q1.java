public class Q1 {
  public static void main(String[] args) {
    whileloop();
    dowhile();
    forloop();
  }

  public static void whileloop() {
    int n = 1;
    int sum = 0;
    while (n <= 100) {
      sum += n;
      n++;
    }
    System.out.println(sum);
  }

  public static void dowhile() {
    int n = 1;
    int sum = 0;
    do {
      sum += n;
      n++;
    } while (n <= 100);
    System.out.println(sum);
  }

  public static void forloop() {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }
    System.out.println(sum);
  }
}
