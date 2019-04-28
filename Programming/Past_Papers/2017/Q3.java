public class Q3 {
  public static void main(String[] args) {
    int i = 0;
    boolean test = true;

    if (test) {
      int k = 3;
    }
    //b)
    int k = 2; // no syntax errors but will print 2 rather than 3;

    System.out.println(i);
    System.out.println(k); // will not work due to int k being declared in an inner scope.
    // we have no access to it. It should be declared before the if statement
  }
}
