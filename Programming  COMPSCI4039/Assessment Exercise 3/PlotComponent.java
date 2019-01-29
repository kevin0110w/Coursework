import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class PlotComponent extends JComponent {
	private ArrayList<Double> xaxis = new ArrayList<Double>();
	private ArrayList<Double> yaxis = new ArrayList<Double>();
	private ArrayList<Points> points = new ArrayList<Points>(); //arraylist of point objects
	private ArrayList<String>columnHeaders = new ArrayList<String>();
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		 // Plotting the coordinates
		for(Points p: points) {	
			{ 
				g2.setColor(Color.BLACK); // set to black initially to draw shape / outline in black
				double r = p.getRadius();
				double x = calculateXCoordinate(p.getX(), r); // calculate relative horizontal position
				double y = calculateYCoordinate(p.getY(), r); // calculate relative vertical position
				Ellipse2D.Double e = new Ellipse2D.Double(x,y,r,r); //generate a dot shape object
				g2.draw(e);
				g2.setPaint(Color.red); 
				g2.fill(e); // next fill each dot red
			}
			g2.setColor(Color.BLACK); 
			g2.drawLine((int) (this.getWidth()*0.1), (int) (this.getHeight()*0.9), (int) (this.getWidth()*0.9), (int) (this.getHeight()*0.9)); //drawing the x-axis
			g2.drawLine((int) (this.getWidth()*0.1), (int) (this.getHeight()*0.1), (int) (this.getWidth()*0.1), (int) (this.getHeight()*0.9)); //drawing the y-axis
			double yaxisPosition = yaxis.get(0); // set y axis tick label to start at lowest value of a chosen column
			double yaxisJump = returnJump(yaxis); // calculate numerical values for each jump along y axis
			double tickGap = 0.1; // distance between each tick label
			double xaxisPosition = xaxis.get(0); // set starting x-axis value as lowest in the chosen column
			double xaxisJump = returnJump(xaxis); // calculate numerical values for each jump along y axis
			for (int i = 0 ; i <  9; i++) {
				g2.drawLine((int) (this.getWidth()*0.09), (int) (this.getHeight() * tickGap), (int) (this.getWidth()*0.1),  (int) (this.getHeight() * tickGap));// drawing ticks along y axis ticks
				g2.drawString("" + String.format("%.2f", yaxisPosition), (int) ((this.getWidth()*0.09)-55), (int) (this.getHeight() - this.getHeight()* tickGap + 3)); //  drawing numerical labels along y axis
				g2.drawLine((int) (this.getWidth()*tickGap), (int) (this.getHeight() - (this.getHeight() * 0.09)), (int) (this.getWidth()*tickGap),  (int) (this.getHeight() - (this.getHeight() * 0.1))); // draw ticks along x axis
				g2.drawString("" + String.format("%.2f", xaxisPosition), (int) (this.getWidth() * tickGap) - 12, (int) (this.getHeight() - (this.getHeight() * 0.07))); // drawing numerical labels along axis ticks
				yaxisPosition = yaxisPosition + yaxisJump;
				xaxisPosition = xaxisPosition + xaxisJump;
				tickGap = tickGap + 0.1; // to calculate distance between labels
			}	
			g2.setStroke(new BasicStroke(2)); // set drawing pencil thickness 
			g2.drawString(columnHeaders.get(1), ((int) (this.getWidth()*0.09)-75), (int) (this.getHeight() - (this.getHeight() *0.95))); // y-axis label
			g2.drawString(columnHeaders.get(0), (int) ((int) this.getWidth() /2), (int) (this.getHeight() - (this.getHeight() *0.03)));   // x-axis label
		}
	}
	// add the point to the arraylist containing point objects
	public void addPoint(Points p) {
		this.points.add(p); 
	}
	
	// calculate relative horizontal position, need to subtract by half of the radius size to get middle of dot to appear at the x point
	public double calculateXCoordinate(double x_value, double radius) {
		double x = ((x_value * (this.getWidth() * 0.8)) + (this.getWidth() * 0.1)) - (radius/2);
		return x;
	}
	
	// calculate relative vertical position, need to add by half of the radius size to get middle of dot to appear at the x point
	public double calculateYCoordinate(double y_value, double radius) {
		double y = ((y_value * (this.getHeight()*.8)) + (this.getHeight()*0.1)) + (radius/2);
		y = this.getHeight() - y; // based on origin (0,0) starting from bottom left corner
		return y;
	}
	/*
	 * Clear the arraylists that are associated with the display of a set of points so that they aren't lingering when selecting different x/y values
	 * (i.e. the arraylists used to calculate tick labels along both axis, axis headers, list of points).
	 */
	public void clear() {
		points.clear();
		xaxis.clear();
		yaxis.clear();
		columnHeaders.clear();
	}
	// add number to the list that's used to calculate ticks along x axis
	public void addxaxis(double value) {
		this.xaxis.add(value);
	}
	// add number to the list that's used to calculate ticks along y axis
	public void addyaxis(double value) {
		this.yaxis.add(value);
	}

	// calculates the number (jump) between ticks to be displayed on the side of each tick
	public double returnJump(ArrayList<Double> axis) {
		return (axis.get(1) - axis.get(0))/8;
	}
	// add string to a list that'll be used to label axis
	public void addHeader(String header) {
		this.columnHeaders.add(header);
	}
}
