public class Q1 {
  public static void main(String[] args) {
    boolean test;
    boolean a = true;
    boolean b = false;
    test = a && b;
    System.out.println("p: false");
    System.out.println(test);
    test = a || b;
    System.out.println("p: true");
    System.out.println(test);
    test= a && !b;
    System.out.println("p: true");
    System.out.println(test);
    test = !a || b;
    System.out.println("p: false");
    System.out.println(test);
    test = !(a && b);
    System.out.println("p: true");
    System.out.println(test);

  }
}
