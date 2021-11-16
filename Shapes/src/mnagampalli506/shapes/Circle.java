package mnagampalli506.shapes;

import java.awt.Color;

/**
 * @author Manasvini Nagampalli	
 * @version 01
 * This is the Circle class which contains methods that calculate the area, circumference, diameter and checks
 * whether a given point exists within the circle. Additionally, it can create a border when instructed by the user.
 */
import processing.core.PApplet;

public class Circle extends Shape{
	private double radius;
	private final double PI = Math.PI;
	private int x1;
	

	/**
	 * Creates a default instance of a Rectangle object with all dimensions set to
	 * zero.
	 */

	public Circle() {
		super(0,0);
		radius = 0;
		
	}

	/**
	 * Creates a new instance of a Circle object with the coordinates of the center
	 * and with a radius.
	 * 
	 * @param x the centerX point
	 * @param y the centerY point
	 * @param radius the radius of the circle
	 */
	public Circle(double x, double y, double radius) {
		super(x,y);
		this.radius = radius;
	}

	/**
	 * sets the x value to the x coordinate of the circle
	 * @param x x coordinate of the circle
	 */
	public void setX(double x) {
		this.x = x;

	}
	/**
	 * Sets the y value
	 * @param y the y coordinate of the circle
	 */
	public void setY(double y) {
		this.y = y;
	}
	

	/**
	 * Calculates and returns the area of the circle as a double
	 * 
	 * @return area returns the area of the circle
	 */
	public double getArea() {
		double area = PI * radius * radius;
		return area;
	}

	/**
	 * Determines whether the point x,y is contained inside this circle
	 * 
	 * @return true returns a boolean value which indicates whether a given point is
	 *         within the circle
	 * @param x a double x coordinate
	 * @param y a double y coordinate
	 */
	public boolean isPointInside(double x, double y) {
		double displacement = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (displacement - x > radius || displacement - y > radius) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Sets the stroke colour of the circle
	 * @param c The stroke colour of the circle
	 */
	public void setStrokeColor(Color c) {
		strokecolor = c;
	}
	/**
	 * Sets the fill colour of the circle
	 * @param c The fill colour of the circle
	 */
	public void setFillColor(Color c) {
		fillcolor = c;
	}

	/**
	 * Draws the rectangle to the given Processing PApplet.
	 * 
	 * @param drawingSurface The Processing PApplet on which to draw the Line.
	 * @pre The Circle will be drawn based on the attributes set on the given
	 *      PApplet.
	 */
	public void draw(PApplet drawingSurface) {
		super.draw(drawingSurface);
		drawingSurface.circle((float) x,(float) y,(float) radius);
		drawingSurface.fill(250,0,0);
		drawingSurface.circle((float) x,(float) y, (float) radius - x1);
		
	}

	/**
	 * Calculates and returns the diameter of the circle as a double
	 * 
	 * @return returns the double value of the diameter
	 */
	public double getDiagonal() {
		double diamter = 2 * radius;

		return diamter;

	}
	/**
	 * 
	 * @return returns the x coordinate
	 */
	public double getX() {
		return x;
		
	}
	/**
	 * 
	 * @return returns the y coordinate
	 */
	public double getY() {
		return y;
		
	}
	/**
	 * Creates a border around the circle
	 * 
	 * @param n takes an integer value that increments the value of x
	 */
	public void makeBorder(int n) {
		double endX = x + radius;
		double endY = y + radius;

		if ((endX - 2 * x1) - (x + x1) > 30 || (endY - 2 * x1) - (y + x1) > 30) {
			x1 = x1 + n;

		} else {
			x1 = 0;
		}

	}
	/**
	 * gets the centre x coordinate of the circle
	 * @return x coordinate of the circle
	 */
	public double getCenterX() {

		return x;
	}
	/**
	 * gets the y coordinate of the circle
	 * @return y y coordinate of the circle
	 */
	
	public double getCenterY() {

		return y;
	}
	/**
	 * Changes the scale factor of the circle which results in shrinking/stretching the circle
	 * @param n takes an integer value that increments the value of the scale factor of the circle
	 */

	public void scale(float n) {
		factor = factor + n;

	}
	
	/**
	 * calculates the getPerimeter() of the circle 
	 * @return getPerimeter() 
	 */
	public double getPerimeter() {

		return ((double) 2 * (PI * radius));
	}

}
