package Cube1;

public class Cube {
	public int sideLength;
	public String color;
	
	public Cube() {
		this.sideLength = 10;
		this.color = "White";
	}
	public Cube(int length, String color) {
		this.sideLength = length;
		this.color = color;
	}
	public Cube(Cube c) {
		this.sideLength = c.getSideLength();
		this.color = c.getColor();
	}
	
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getvolume() {
		return (this.sideLength*this.sideLength*this.sideLength);
	}
	public int getSurfaceArea() {
		return (this.sideLength*this.sideLength*6);
	}
	public boolean isBigger(Cube c) {
		if (this.sideLength > c.getSideLength()) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean equals(Cube c) {
		if (this.sideLength != c.getSideLength()) {
			return false;
		}
		else if (!color.equals(c.getColor())) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public String toString() {
		return "sideLength: "+this.sideLength+", color: "+this.color;
	}
	
}
