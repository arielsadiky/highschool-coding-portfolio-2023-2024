package Cube2;

public class Cube {
	public int sideLength;
	public String color;
	public static int count = 1000;
	public int cubeId;
	
 	public Cube() {
		this.sideLength = 10;
		this.color = "White";
		count++;
		this.cubeId = count;
	}
	public Cube(int length, String color) {
		this.sideLength = length;
		this.color = color;
		count++;
		this.cubeId = count;
	}
	public Cube(Cube c) {
		this.sideLength = c.getSideLength();
		this.color = c.getColor();
		count++;
		this.cubeId = count;
	}
	
	public int getSideLength() {
		return this.sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCubeId() {
		return this.cubeId;
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
		return "sideLength: "+this.sideLength+", color: "+this.color+", cubeId: "+this.cubeId;
	}
	
}
