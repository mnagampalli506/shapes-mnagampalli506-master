package mnagampalli506.shapes;

import java.awt.Color;

/**
 * @author: Manasvini Nagampalli			
 * @version: 01
 * */
import processing.core.PApplet;

public class Line extends Shape {

	public double x2;
	private double y2;

	/**
	 * Constructs a line from (x, y) to (x2, y2)
	 * 
	 * @param x  the x1 coordinate of the line
	 * @param y  the y1 coordinate of the line
	 * @param x2 the x2 coordinate of the line
	 * @param y2 the y2 coordinate of the line
	 */
	public Line(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;

	}

	/**
	 * Sets the starting x point of the line
	 * 
	 * @param x the x1 coordinate of the starting point of the line
	 */

	public void setX(double x) {
		this.x = x;

	}

	/**
	 * Sets the starting y point of the line
	 * 
	 * @param y the y coordinate of the starting point of the line
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Sets the ending point of the line
	 * 
	 * @param x2 the x2 coordinate of the starting point of the line
	 * @param y2 the y2 coordinate of the starting point of the line
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;

	}

	/**
	 * Draws the line to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the Line.
	 * @pre The Line will be drawn with attributes previously set on the given
	 *      PApplet.
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);
		drawer.line((float) x, (float) y, (float) x2, (float) y2);
	}

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
	 * Returns the x coordinate of the intersection point of this line and the other
	 * line (assuming they continue forever)
	 * 
	 * @param other A line that is passed to check for an intersection
	 * @return xCoordinate of the intersection
	 */
	public double getIntersectionX(Line other) {
		double divideByZeroError = 0XFFFFF;
		double x1=this.x;
		double y1=this.y;
		double x2 = this.x2;
		double y2=this.y2;
		double x3 = other.x;
		double x4 = other.x2;
		double y3 = other.y;
		double y4 = other.y2;
		double xCoordinate;
		double denominator = (((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4)));

		if (denominator == 0) {
			xCoordinate = divideByZeroError;
			
		} else {
			xCoordinate = ((x1 * y2 - y1 * x2) * (x3-x4)
					- (x3 * y4 - y3 * x4) * (x1 - x2)) / denominator;
		
		}
		return xCoordinate;

	}

	/**
	 * Returns the x coordinate of the intersection point of this line and the other
	 * line (assuming they continue forever)
	 * 
	 * @param other A line that is passed to check for an intersection
	 * @return yCoordinate of the intersection
	 */
	public double getIntersectionY(Line other) {
		double divideByZeroError = 0XFFFFF;
		double x1=this.x;
		double y1=this.y;
		double x2 = this.x2;
		double y2=this.y2;
		double x3 = other.x;
		double x4 = other.x2;
		double y3 = other.y;
		double y4 = other.y2;
		double yCoordinate;
		double denominator = (((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4)));

		if (denominator == 0) {
			yCoordinate = divideByZeroError;
			
		} else {
			yCoordinate = ((x1 * y2 - y1 * x2) * (y3-y4)
					- (x3 * y4 - y3 * x4) * (y1 - y2)) / denominator;
		
		}
		return yCoordinate;
		
	}

	/**
	 * @return true if this line segment and the segment other intersect each other
	 *         and false if it doesn't.
	 * @param other A line that is passed to check for an intersection
	 */
	public boolean intersects(Line other) {
		double x;
		double y;
		double divideByZeroError = 0xFFFFF;
		y = getIntersectionY(other);
		x = getIntersectionX(other);
		if (x == divideByZeroError || y == divideByZeroError) {
			return false;
		}
		// Now we know that the lines theoretically intersect, this
		// figures out if the x,y points is within the given line segment
		boolean firstLineContainsPoint = isPointInside(x, y);
		boolean secondLineContainsPoint = other.isPointInside(x, y);
		if (firstLineContainsPoint && secondLineContainsPoint) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the length of the line segment
	 */
	public double getPerimeter() {
		double perimeter = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
		return perimeter;

	}

	/**
	 * Checks whether a given point is within the boundaries of the shape
	 * 
	 * @param x the x coordinate of the point
	 * @param y the y coordinate of the point
	 * @return true If the point is within the boundaries of the shape
	 */

	public boolean isPointInside(double x, double y) {
		double roundOffError=0.01;
		Line firstSegment = new Line(this.x, this.y, x, y);
		Line secondSegment = new Line(x, y, x2, y2);
		double firstLength = firstSegment.getPerimeter();
		double secondLength = secondSegment.getPerimeter();
		double totalLength = this.getPerimeter();
		if (Math.abs((totalLength - firstLength - secondLength))<= roundOffError) {
			return true;
		} else {

			return false;
		}
	}

	public double getArea() {
		return 0;
	}

	/**
	 * @return returns midpoint X coordinate
	 */
	public double getCenterX() {
		return (x + x2) / 2;
	}

	/**
	 * @return returns center Y coordinate
	 */
	public double getCenterY() {
		return (y + y2) / 2;
	}

	/**
	 * Makes a border around the line
	 * 
	 * @param n takes an integer value that increments the value of x
	 */

	public void makeBorder(int n) {
		n = 0;

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

	public void moveBy(double x, double y) {
		super.move(x, y);
		x2 += x;
		y2 += y;
	}

}
