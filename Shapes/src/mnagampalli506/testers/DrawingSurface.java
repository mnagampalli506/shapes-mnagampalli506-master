package mnagampalli506.testers;

import java.awt.Color;	
/**@author Manasvini Nagampalli and John Shelby	
 * @version 01
 * Acts as the drawing surface
 * */
import java.awt.event.KeyEvent;
import mnagampalli506.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	Rectangle r;
	private Circle c;
	private Line l;
	private Line l2;
	private RegularPolygon rp;

	/** Creates a new instance of a rectangle and circle */
	public DrawingSurface() {
		r = new Rectangle(150, 80, 40, 16);
		c = new Circle(100, 60, 60);
		l = new Line(0, 0, 100, 100);
		l2 =new Line(100,100,100,0);
		rp = new RegularPolygon(200, 200, 8, 100);
		

	}

	/** Draws an instance of a circle and rectangle */

	public void draw() {
		background(255);// Clear the screen with a white background
		fill(255, 0, 0);

		if ( r!=null || l!=null ||  c!=null) {
			//stroke(0, 0, 0);
			//r.draw(this);
			//r.setFillColor(Color.BLUE);
			//c.draw(this);
			//l.draw(this);
			l2.draw(this);
			rp.draw(this);
			//rp.drawBoundingCircles(this);

		}

		fill(0);
		textSize(10);
		textAlign(CENTER);
		text(l.getIntersectionX(l2)+"\n"+l.getIntersectionY(l2)+"\n"+ l.intersects(l2)+ rp.isPointInside(100, 100), width / 2,
				10);
	}

	/** Creates a border every time the space bar key is pressed */
	public void keyPressed() {
		if (keyPressed) {

			if (keyCode == KeyEvent.VK_SPACE) {

				r.makeBorder(1);
				c.makeBorder(1);
				rp.makeBorder(1);

			}
			if (keyCode == KeyEvent.VK_M) {

				r.scale(1);
				c.scale(1);

			}

		}
	}

}
