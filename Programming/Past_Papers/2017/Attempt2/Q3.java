public class Q3 {
  public static void main(String[] args) {
    int i = 0;
    boolean test = true;

    if (test) {
      int k = 3; //a
    }

    // b)
    int k = 2;
    System.out.println(i); // should print out 0;
    // System.out.println(k); //a this should not work due to scope.. the k is declared within the if statement.
    System.out.println(k); //b this should print 2
  }
}
