
public class Cylinder extends Circle {
	private double height;

	public Cylinder() {
		super();
		this.height = 1.0;
	}
	
	public Cylinder(double height) {
		super();
		this.height = height;
	}
	
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getVolume() {
		return super.getArea()*height;
	}
	
	@Override
	public double getArea() {
		return ((2*Math.PI * this.getRadius() * this.height) + (2*Math.PI + this.getRadius() * this.getRadius())); 
	}
	
	@Override
	public String toString() {
		return "Cylinder: subclass of " + super.toString()  // use Circle's toString()
        + " height=" + height;
	}
}
