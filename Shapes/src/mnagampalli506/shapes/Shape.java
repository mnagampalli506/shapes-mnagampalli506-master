/**
 * @author: Manasvini Nagampalli			
 * @version: 01
 * */
package mnagampalli506.shapes;

import java.awt.Color;	

import processing.core.PApplet;

public abstract class Shape {
	// FIELDS
	protected double x, y;
	protected Color strokecolor;
	protected Color fillcolor;
	protected float factor;

	// CONSTRUCTORS
	/**
	 * Creates an instance of a shape with a starting x and y value
	 * 
	 * @param x It is a double value that is assigned to the x value
	 * @param y It is a double value that is assigned to the y value
	 */

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;

	}

	/***
	 * sets the initial value of the scale factor and colour of the shape
	 */
	public Shape() {
		factor = 1;
		strokecolor = Color.black;

	}

	// METHODS
	/**
	 * This method draws a shape and gives it a stroke and fill colour
	 * 
	 * @param marker This is the PApplet surface that the shape is drawn on
	 * @pre marker The Shape will be drawn based on the attributes set on the given
	 *      PApplet.
	 */

	public void draw(PApplet marker) {
		if (strokecolor != null) {
			marker.stroke(strokecolor.getRed(), strokecolor.getGreen(), strokecolor.getBlue());
		}
		if ( fillcolor != null) {
			
			marker.fill(fillcolor.getRed(), fillcolor.getGreen(),fillcolor.getBlue());
		}
	}

	/**
	 * This method moves the shape up,down,right and left
	 * 
	 * @param x1 The increment by which the x position of the shape is moved
	 * @param y1 The increment by which the y position of the shape is moved
	 */
	public void move(double x1, double y1) {
		x += x1;
		y += y1;

	}

	/**
	 * Method calculates the getPerimeter() of the shape
	 * 
	 * @return getPerimeter() of the shape
	 */
	public abstract double getPerimeter();

	/**
	 * Method calculates the area of the shape
	 * 
	 * @return the double value of the area of the shape
	 */
	public abstract double getArea();

	/**
	 * Calculates the x-coordinate of the midpoint of the shape
	 * 
	 * @return centerX of the shape
	 */

	public abstract double getCenterX();

	/**
	 * Calculates the y-coordinate of the midpoint of the shape
	 * 
	 * @return centerY value
	 */

	public abstract double getCenterY();

	/**
	 * Sets the x coordinate
	 * 
	 * @param x a double x coordinate
	 */
	public void setX(double x) {
		this.x = x;

	}

	/**
	 * Sets the y coordinate
	 * 
	 * @param y a double y coordinate
	 */

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Checks whether a given point is within the boundaries of the shape
	 * 
	 * @param x the x coordinate of the point
	 * @param y the y coordinate of the point
	 * @return true If the point is within the boundaries of the shape
	 */
	public abstract boolean isPointInside(double x, double y);

	/**
	 * Creates a border around the shape
	 * 
	 * @param n takes an integer value that increments the value of x
	 */

	public abstract void makeBorder(int n);

	/**
	 * Changes the scale factor of the shape which results in shrinking/stretching
	 * the shape
	 * 
	 * @param n takes an integer value that increments the value of the scale factor
	 *          of the shaps
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
	 * gets the x coordinate
	 * @return returns the x coordinate
	 */
	public double getX() {
		return x;
		
	}
	/**
	 * gets the y coordinate
	 * @return returns the y coordinate
	 */
	public double getY() {
		return y;
		
	}
}
