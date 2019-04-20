public class Rectangle extends AbstractShape {

  public Rectangle(double width, double length) {
    super(width, length);
  }

  @Override
  public double getArea() {
    return this.width * this.length;
  }
}
