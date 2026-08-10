package Bead;

public class Bead {
	public String color;
	public Bead nextBead;
	
	public Bead(String color) {
		this.color = color;
		this.nextBead = null;
	}
	public Bead(String color, Bead nextBead) {
		this.color = color;
		this.nextBead = nextBead;
	}
	
	public String getColor() {
		return color;
	}
	public Bead getNextBead() {
		return this.nextBead;
	}
	public void setNextBead(Bead nextBead) {
		this.nextBead = nextBead;
	}
	
	public String toString() {
		return "color: "+color;
	}
}
