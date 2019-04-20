public class Test {
  public static void main(String[] args) {
    AbstractShape rect = new Rectangle(2, 4);
    AbstractShape tri = new Triangle(3, 4);
    System.out.println(rect.getArea());
    System.out.println(tri.getArea());
  }
}
