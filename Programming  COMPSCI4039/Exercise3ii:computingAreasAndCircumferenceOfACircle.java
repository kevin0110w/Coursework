/*
Write a method that computes the area of a circle when you pass it the circle’s radius (area = pi * radius * radius). Write a main method that demonstrates your method by calling it and printing out the result for two different radius values

Methods within methods. Methods can call other methods. Building on the area of a circle example (above), write a second method (in the same program) that computes the circumference (call it compCircumference) of a circle (circumference = 2 * pi * radius). Write a third method called summariseCircle which is passed a radius and computes and displays the area (using compArea) and the circumference (using the circumference method). I.e. your main will call summariseCircle and it will call compArea and compCircumference.
*/

public class Lab3Ex2 {
	public static void main(String[] args) {
	    double r = 5.6;
	    summariseCircle(r);
	  //  double area = compArea(r);
	  //  System.out.println(area);
	  //  r = 1.2;
	  //  area = compArea(r);
	 //   System.out.println(area);
	}
	
	public static double compArea(double r) {
		double pi = 3.14125;
		double area = pi * r * r;
		return area;
	}
	
	public static double compCircumference(double r) {
		double pi = 3.14125;
		double circumference = 2 * pi * r;
		return circumference;
	}
	
	public static void summariseCircle(double r) {
		double areaCircle = compArea(r);
		System.out.println(areaCircle);
		double circumferenceCircle = compCircumference(r);
		System.out.println(circumferenceCircle);
	}

}
