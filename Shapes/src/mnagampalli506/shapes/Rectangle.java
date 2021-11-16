package mnagampalli506.shapes;

import java.awt.Color;

/**
 * @author Manasvini Nagampalli
 * @version 01
 * This is the Circle class which contains methods that calculate the area, circumference, diameter and checks
 * whether a given point exists within the circle. Additionally, it can create a border when instrcuted by the user.
 */
import processing.core.PApplet;

public class Rectangle extends Shape {
	private int x1;
	private double width;
	private double height;
	
	


	/**
	 * Creates a default instance of a Rectangle object with all dimensions set to
	 * zero.
	 */

	public Rectangle() {
		super(0, 0);
		width = 0;
		height = 0;
	}

	/**
	 * Creates a new instance of a Rectangle object with the left and right edges of
	 * the rectangle at x and x + width. The top and bottom edges are at y and y +
	 * height.
	 * 
	 * @param x      double value of the starting x coordinate of the rectangle
	 * @param y      double value of the starting y coordinate of the rectangle
	 * @param width  double value of the width of the rectangle
	 * @param height double value of the height of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	/**
	 * Calculates the value of getPerimeter() of the rectangle
	 * 
	 * @return getPerimeter() as a double
	 */

	public double getPerimeter() {
		double perimeter = 2 * (width + height);
		return perimeter;
	}

	/**
	 * Calculates and returns the area of the rectangle as a double return
	 * 
	 * @return area Returns the double value of the area of the rectangle
	 */
	public double getArea() {

		double area = (width) * (height);
		return area;
	}

	/**
	 * Draws the rectangle to the given Processing PApplet
	 * 
	 * @param marker The drawing surface on which the rectangle will be rendered
	 * @pre the Rectangle will be drawn based on the attributes set on the given
	 *      PApplet.
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float) x, (float) y,  (float) width,  (float) height);
		marker.fill(0,0,0);
		marker.rect(((float) x + x1),  ((float) y + x1), ((float) width - 2 * x1),
				((float) height - 2 * x1));

	}

	/**
	 * Calculates and returns the diagonal of the rectangle as a double
	 * @return diagonal returns the double value of the diagonal of the rectangle
	 */
	public double getDiagonal() {
		double diagonal = Math.sqrt(Math.pow(width, 2.0) + Math.pow(height, 2.0));

		return diagonal;

	}

	/**
	 * Checks whether a given point is within the boundaries of the shape
	 * 
	 * @param x1 the x coordinate of the point
	 * @param y1 the y coordinate of the point
	 * @return true If the point is within the boundaries of the shape
	 */
	public boolean isPointInside(double x1, double y1) {
		double endX = x+width;
		double endY = y+height;
		if (x1 >= x && endX >= x1 && y <= y1 && endY >= y1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Makes a border around the rectangle
	 * 
	 * @param n takes an integer value that increments the value of x
	 */
	public void makeBorder(int n) {
		double endX = x+width;
		double endY = y+height;
		if ((endX - 2 * x1) - (x + x1) > 30 || (endY - 2 * x1) - (y + x1) > 30) {
			x1 = x1 + n;

		} else {
			x1 = 0;
		}

	}

	/**
	 * Sets the x value
	 * 
	 * @param x the x coordinate of the shape
	 */
	public void setX(double x) {
		this.x = x;

	}

	/**
	 * Sets the y value
	 * 
	 * @param y the y coordinate of the shape
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Changes the scale factor of the shape which results in shrinking/stretching
	 * the shape
	 * 
	 * @param n takes an integer value that increments the value of the scale factor
	 *          of the shapes
	 */

	public void scale(float n) {
		factor = factor + n;
	}

	/**
	 * Sets the stroke colour of the shape
	 * 
	 * @param c The stroke colour of the shape
	 */
	public void setStrokeColor(Color c) {
		strokecolor = c;
	}

	/**
	 * Sets the fill colour of the shape
	 * 
	 * @param c The fill colour of the shape
	 */
	public void setFillColor(Color c) {
		fillcolor = c;
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
	 * @return returns x coordinate of the rectangle's midpoint 
	 */
	
	public double getCenterX() {
		
		return x+ width/2;
	}

	/**
	 * @return returns y coordinate of the rectangle's midpoint 
	 */
	public double getCenterY() {
		
		return y+ height/2;
	}
	

}
