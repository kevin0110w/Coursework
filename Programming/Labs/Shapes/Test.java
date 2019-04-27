public class Test {
  public static void main(String[] args) {
    AbstractShape rect = new Rectangle(2, 4);
    AbstractShape tri = new Triangle(3, 4);
    System.out.println(rect.getArea());
    System.out.println(tri.getArea());
    AbstractShape[] x = new AbstractShape[2];
    x[0] = rect;
    x[1] = tri;
    for (int i = 0; i < x.length; i++) {
      System.out.println(x[i] + "" + x[i].getArea());
    }
  }
}
