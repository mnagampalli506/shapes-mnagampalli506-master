package fzhang.physicsshapedemo;
import mnagampalli506.shapes.*;	
import processing.core.PApplet;

import java.awt.Color;



public class PhysicsShape {

	private Shape s;
	private double vx, vy, gravity, friction;
	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 1;
		vy = 1;
		gravity = 0.25;
		friction = 0.95;
	}
	
	public void draw(PApplet surface) {
		s.draw(surface);
	}
	public boolean isPointInside(double x, double y) {
		return s.isPointInside(x, y);
	}

	public boolean doesIntersect(Line l) {
		//System.out.println(s.getY()+ (s.getCenterY()- s.getY())*2);
		Line l1 = new Line (s.getX(), s.getY(), s.getX(), s.getY()+ (s.getCenterY()- s.getY())*2);
		l1.setPoint2(s.getX(), s.getY()+ (s.getCenterY()- s.getY())*2);
		Line l2 = new Line (s.getX(), s.getY(), s.getX()+ (s.getCenterX()- s.getX())*2, s.getY());
		l2.setPoint2(s.getX()+ (s.getCenterX()- s.getX())*2, s.getY());
		Line l3 = new Line (s.getX(), s.getY()+ (s.getCenterY()- s.getY())*2, s.getX()+ (s.getCenterX()- s.getX())*2 , s.getY()+(s.getCenterY()- s.getY())*2);
		l3.setPoint2(s.getX()+ (s.getCenterX()- s.getX())*2 , s.getY()+(s.getCenterY()- s.getY())*2);
		Line l4 = new Line (s.getX()+ (s.getCenterX()-s.getX())*2, s.getY(), s.getX()+ (s.getCenterX()- s.getX())*2, s.getY()+ (s.getCenterY()- s.getY())*2);
		l4.setPoint2(s.getX()+ (s.getCenterX()- s.getX())*2, s.getY()+ (s.getCenterY()- s.getY())*2);
		if (l.intersects(l1)) {// || l.isPointInside(l2) || l.isPointInside(l3)  || l.isPointInside(l4) ) {
			return true;
		}
		return false;
		
		
	}
	public void act(Rectangle window) {
//		double x = s.getX();
//		x += vx;
//		s.setX(x);
//		double y = s.getY();
//		y += vy;
//		s.setY(y);
		
		//s.move(vx, vy);
		//s.translate(vx, vy);
//		vy+=gravity;
//		vx*=friction;
//		vy*=friction;
		
		s.move(vx, 0);
		if (!window.isPointInside(s.getX(), s.getY()) || !window.isPointInside(s.getX() + 20, s.getY() + 20)) {
			vx = -vx;
			s.move(vx, 0);
			//s.setStrokeColor(Color.BLACK);
		}
		s.move(0, vy);
		if (!window.isPointInside(s.getX(), s.getY()) || !window.isPointInside(s.getX() + 20, s.getY() + 20)) {
			vy = -vy;
			s.move(0, vy);
			//s.setStrokeColor(Color.BLACK);
		}
		vy+=gravity;
		vx*=friction;
		vy*=friction;
	}
	public void bounce() {
		vy = -vy;
		s.move(0, vy);
		vy*=0.95;
		vx*=friction;
		vy+=gravity;
		vy*=friction;
	}
	public void jumpRight() {
		vx+= 2;
		vy-= 3;
		s.move(vx, vy);
	}
	public void jumpLeft() {
		vx-= 2;
		vy-= 3;
		s.move(vx, vy);
	}
	public void accelerate (double ax, double ay) {
		vx+=ax;
		vy+=ay;
	}
	public void setColor(Color c) {
		//Color c = new Color (r,g,b);
		s.setStrokeColor(c);
	}
}
