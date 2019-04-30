public class Q1 {
  public static void main(String[] args) {
    boolean test;
    boolean a = true;
    boolean b = false;

    test = a && b;
    System.out.println("Predicted: False");
    System.out.println("Result: " + test);
    test = a || b;
    System.out.println("Predicted: True");
    System.out.println("Result: " + test);
    test = a && !b;
    System.out.println("Predicted: True");
    System.out.println("Result: " + test);
    test = !a || b;
    System.out.println("Predicted: False");
    System.out.println("Result: " + test);
    test = !(a && b);
    System.out.println("Predicted: True");
    System.out.println("Result: " + test);

  }
}
