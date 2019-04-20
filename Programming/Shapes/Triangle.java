public class Triangle extends AbstractShape {
  public Triangle(double width, double length) {
    super(width, length);
  }

  @Override
  public double getArea() {
    return (0.5 * this.width) * this.length;
  }
}
