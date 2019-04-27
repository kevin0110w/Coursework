
public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return this.radius*this.radius*Math.PI;
	}
	
	public double getCircumference() {
		return (this.radius*2) * Math.PI;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
		}
	
	public String toString() {
		return "Circle[radius=" + radius + " + color=" + color + "]";
	}
	
}
