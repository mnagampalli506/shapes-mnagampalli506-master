package mnagampalli506.shapes;

import processing.core.PApplet;

public class RegularPolygon extends Shape {
	private int numSides;
	private double sideLength;
	private int b;

	/**
	 * Constructs a regular polygon by setting the basic dimensions to 3 sides and 
	 * side length of 100
	 */
	public RegularPolygon() {
		super(200, 200);
		numSides = 3;
		sideLength = 100;
	}
	/**
	 * It constructs a polygon with the given centre x,y coordinates, number of sides and side length 
	 * @param x the centre x coordinate of the polygon
	 * @param y the centre y coordinate of the polygon
	 * @param numSides the polygon has
	 * @param sideLength the side length of all the sides of the polygon
	 */

	public RegularPolygon(int x, int y, int numSides, double sideLength) {
		super(x, y);
		this.numSides = numSides;
		this.sideLength = sideLength;
	}
	/**
	 * sets the x value to the x coordinate of the shape
	 * @param x x coordinate of the shape
	 */
	public void setX(double x) {
		this.x = x;

	}
	/**
	 * Sets the y value
	 * @param y the y coordinate of the shape
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	 /**
	  * calculates the getPerimeter() of the polygon
	  * @return getPerimeter() returns the perimeter of the polygon 
	  */
	public double getPerimeter() {
		double perimeter= numSides * sideLength;
		return perimeter;
	}
	/**
	 * Calculates and returns the area of the regular polygon as a double
	 * @return area returns the area of the regular polygon
	 */
	public double getArea() {
		double area = 0.5 * numSides * Math.pow(calcR(), 2) * Math.sin((2 * Math.PI) / numSides);
		return area;
	}
	/**
	 * gets the centre x coordinate of the regular polygon
	 * @return x coordinate of the regular polygon
	 */

	public double getCenterX() {

		return x;
	}
	/**
	 * gets the centre y coordinate of the regular polygon
	 * @return y coordinate of the regular polygon
	 */
	public double getCenterY() {

		return y;
	}
	/**
	 * Determines whether the point x,y is contained inside this regular polygon
	 * @return true returns a boolean value which indicates whether a given point is
	 *         within the regular polygon
	 * @param x1 a double x coordinate
	 * @param y1 a double y coordinate
	 */
	public boolean isPointInside(double x1, double y1) {
		double endX = x+calcR();
		double endY = y+calcR();
		
		if (x1 >= x && endX >= x1 && y <= y1 && endY >= y1) {
			return true;
		} else {
			return false;
		}
		
	}
	/**
	 * Creates a border around the regular polygon
	 * @param n takes an integer value that increments the value of x
	 */
	public void makeBorder(int n) {
		 b = 0;
		double endX = 2 * x;
		double endY = 2 * y;
		if ((endX - 2 * b) - (x + b) > 90 || (endY - 2 * b) - (y + b) > 90) {
			b = b + n;

		} else {
			b = 0;
		}

	}
	/**
	 * Calculates the radius of the inscribed circle 
	 * @return the radius of the inscribed circle in the regular polygon
	 */
	public double calcr() {
		double angle = 1 / Math.tan(Math.PI / numSides);
		double r = 0.5 * sideLength * angle;
		return r;
	}
	
	/**
	 * Calculates the radius of the circumscribed circle 
	 * @return the radius of the inscribed circle in the regular polygon
	 */
	public double calcR() {
		double angle = 1 / Math.sin(Math.PI / numSides);
		double R = 0.5 * sideLength * angle;
		return R;
	}
	/**
	 * Calculates the the vertexAngle of the polygon
	 * @return vertexAngle
	 */
	public double calcVertexAngle() {
		double vertexAngle = ((numSides - 2) / numSides) * 180;
		return vertexAngle;

	}
	/**
	 * @return numSides returns the numSides of the regular polygon
	 */
	public int getNumSides() {
		return numSides;
	}
	/**
	 * 
	 * @return sideLength returns the sideLength of the regular polygon
	 */
	public double getSideLength() {
		return sideLength;
	}
	
	/**
	 * Draws the regular to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the Line.
	 * @pre The Regular Polygon will be drawn based on the attributes set on the given
	 *      PApplet.
	 * @post draws on the PApplet
	 */

	public void draw(PApplet drawer) {

		int n = 1;
		double x1;
		double y1;
		double x2;
		double y2;

		while (n <= numSides) {

			x1 = getNthPointX(n - 1);
			y1 = getNthPointY(n - 1);

			if (n == numSides) {
				drawer.line((float) getNthPointX(0), (float) getNthPointY(0), (float) x1, (float) y1);
				drawer.line((float) getNthPointX(0)-b, (float) getNthPointY(0)-b, (float) x1-b, (float) y1-b);
			} else {

				x2 = getNthPointX(n);
				y2 = getNthPointY(n);
				drawer.line((float) x1, (float) y1, (float) x2, (float) y2);
				drawer.fill(255,0,0);
				drawer.line((float) x1-b, (float) y1-b, (float) x2-b, (float) y2-b);

			}

			n++;
		}
	}

	/**
	 * Calculates the starting x coordinate of the nth side of the polygon
	 * @param i the nth side of the polygon (where 0 is the starting side)
	 * @return x the x coordinate of the nth line of the polygon
	 */

	private double getNthPointY(int i) {
		return getCenterY() + (0.5 * calcR() * Math.sin(2 * Math.PI * i / numSides));
	}

	/**
	 * Calculates the starting x coordinate of the nth side of the polygon
	 * @param i the nth side of the polygon (where 0 is the starting side)
	 * @return x the x coordinate of the nth line of the polygon
	 */
	private double getNthPointX(int i) {

		return getCenterX() + (0.5 * calcR() * Math.cos(2 * Math.PI * i / numSides));
	}
	/**
	 * Draws the circumscribed and inscribed circles around the regular polygon to the given Processing PApplet.
	 * 
	 * @param drawer The Processing PApplet on which to draw the Line.
	 * @pre The circles will be drawn based on the attributes set on the given
	 *      PApplet.
	 * @post draws on the PApplet
	 */
	public void drawBoundingCircles(PApplet drawer) {
		drawer.noFill();
		drawer.circle((float) getCenterX(), (float) getCenterY(), (float) calcr());
		drawer.noFill();
		drawer.circle((float) getCenterX(), (float) getCenterY(), (float) calcR());

	}
}
