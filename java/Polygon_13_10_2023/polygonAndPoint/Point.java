package polygonAndPoint;

import java.lang.Math;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {   //O(1)
		this.x = x;
		this.y = y;
	}
	public Point(Point p) {   //O(1)
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public double getX() {   //O(1)
		return this.x;
	}
	public double getY() {   //O(1)
		return this.y;
	}
	public void setX(double x) {   //O(1)
		this.x = x;
	}
	public void setY(double y) {   //O(1)
		this.y = y;
	}

	public void shiptPoint(double dx, double dy) {   //O(1)
		this.x += dx;
		this.y += dy;
	}
	public int quadrant() {   //O(1)
		if (this.x > 0  &&  this.y > 0) return 1;
		if (this.x < 0  &&  this.y > 0) return 2;
		if (this.x < 0  &&  this.y < 0) return 3;
		if (this.x > 0  &&  this.y < 0) return 4;
		else return 0;
	}
	public double distance00() {   //O(1)
		return Math.sqrt(Math.pow((this.x), 2)+Math.pow((this.y), 2));
	}
	public double distance(Point p) {   //O(1)
		return Math.sqrt(Math.pow((this.x-p.getX()), 2)+Math.pow((this.y-p.getY()), 2));
	}
	public boolean equals(Point p) {   //O(1)
		return (this.x == p.getX()) && (this.y == p.getY());
	}
	
	public String toString() {   //O(1)
		return "("+this.x+","+this.y+")";
	}
}
