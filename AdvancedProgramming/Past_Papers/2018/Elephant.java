public class Elephant {
  public static int age = 3;

  public static void main(String[] args) {
      Elephant e = new Elephant();
      Elephant b = new Elephant();
      b.age = 2;
      System.out.println("" + e.age + " " + b.age);
  }
}
