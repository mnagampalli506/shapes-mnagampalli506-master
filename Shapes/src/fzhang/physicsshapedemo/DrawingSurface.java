package fzhang.physicsshapedemo;

import mnagampalli506.shapes.*;
import processing.core.PApplet;
import java.awt.Color;


public class DrawingSurface extends PApplet {
	private PhysicsShape shape;
	private Line l1, l2, l3, l4, l5;

	public DrawingSurface() {
		shape = new PhysicsShape(new Rectangle(0, 0, 20, 20));
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		background(255);
		//draw
		l1 = new Line (width/15, height/2.0, width*1/5, height/2.0);
		l1.setPoint2(width*1/5, height/2.0);
		l2 = new Line (width*4/15, height/3.0, width*7/15, height/3.0);
		l2.setPoint2(width*7/15, height/3.0);
		l3 = new Line (width*6/15, height*3/5.0, width/2, height*3/5.0);
		l3.setPoint2(width/2, height*3/5.0);
		l4 = new Line (width*9/16, height*6/7.0, width*13/16, height*6/7.0); 
		l4.setPoint2(width*13/16, height*6/7.0);
		l5 = new Line (width*7/8, height*7/10.0, width, height*7/10.0); 
		l5.setPoint2(width, height*7/10.0);
		
		l1.setStrokeColor(new Color (150, 0, 150));
		//l2.setStroke(2);
		l2.setStrokeColor(new Color (0, 150, 0));
		//l3.setStroke(2);
		l3.setStrokeColor(new Color (150, 0, 0));
		//l4.setStroke(2);
		l4.setStrokeColor(new Color (0, 0, 150));
		//l5.setStroke(2);
		l5.setStrokeColor(new Color (233, 115, 35));
		
		l1.draw(this);	
		l2.draw(this);
		l3.draw(this);
		l4.draw(this); 
		l5.draw(this);
		shape.draw(this);
		
		//modify
		shape.act(new Rectangle (0,0, width, height));
		if (shape.doesIntersect(l3) || shape.doesIntersect(l1) ){// || shape.doesIntersect(l3) || shape.doesIntersect(l4) || shape.doesIntersect(l5)) {
//			if (shape.doesIntersect(l1)) {
//				shape.setColor(150, 0, 150);
//			}
//			else if (shape.doesIntersect(l2)) {
//				shape.setColor(0, 150, 0);
//			}
//			else if (shape.doesIntersect(l3)) {
//				shape.setColor(150, 0, 0);
//			}
//			else if (shape.doesIntersect(l4)) {
//				shape.setColor(0, 0, 150);
//			}
//			else if (shape.doesIntersect(l5)) {
//				shape.setColor(233, 115, 35);
//			}
			//shape.bounce();
			shape.setColor(Color.BLUE);
		}
		
	}
	
	public void mouseDragged() {
		//if (shape.isPointInside(mouseX, mouseY)) {
			shape.accelerate((mouseX-pmouseX)/2.0, (mouseY-pmouseY)/2.0);
		//}
	}
	
	public void keyPressed() { 
		if (key == CODED) {
			if (keyCode == RIGHT)
				shape.jumpRight();
			if (keyCode == LEFT)
				shape.jumpLeft();
		}
	}
	
}


