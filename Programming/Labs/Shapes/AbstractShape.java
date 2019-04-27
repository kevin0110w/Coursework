public abstract class AbstractShape {
  protected double length;
  protected double width;

  public AbstractShape(double length, double width){
    this.length = length;
    this.width = width;
  }
  public abstract double getArea();
  
}
