package HMO;

import postOffice.Queue;

public class Shift {
	private Queue<Patient> green;
	private Queue<Patient> blue;
	private Queue<Patient> red;
	private Queue<Patient> allTreated;
	private int whoIsNext;
	
	public Shift() {
		this.green = new Queue<Patient>();
		this.blue = new Queue<Patient>();
		this.red = new Queue<Patient>();
		this.allTreated = new Queue<Patient>();
		this.whoIsNext = 1;
	}

	public Queue<Patient> getGreen() {
		return green;
	}
	public Queue<Patient> getBlue() {
		return blue;
	}
	public Queue<Patient> getRed() {
		return red;
	}
	public Queue<Patient> getAllTreated() {
		return allTreated;
	}
	
	public void addToRightQueue(Patient patient, int n) {
		if (n == 1) this.green.insert(patient);
		else if (n == 2) this.blue.insert(patient);
		else if (n == 3) this.red.insert(patient);
	}
	public Patient next() {
		if (!red.isEmpty()) return red.head();
		if (whoIsNext != 1  &&  !blue.isEmpty()) return blue.head();
		if (!green.isEmpty()) return green.head();
		return null;
	}
	public void beingTreated() {
		if (!red.isEmpty()) allTreated.insert(red.remove());
		else if (whoIsNext != 1  &&  !blue.isEmpty()) {
			allTreated.insert(blue.remove());
			whoIsNext++;
		}
		else if (!green.isEmpty()) {
			allTreated.insert(green.remove());
			whoIsNext++;
		}
		if (whoIsNext == 4) whoIsNext = 1;
	}
	public void printPatients() {
		Queue<Patient> tempG = new Queue<Patient>();
		Queue<Patient> tempB = new Queue<Patient>();
		Queue<Patient> tempR = new Queue<Patient>();
		int n = this.whoIsNext;
		while (!red.isEmpty()) {
			System.out.println(red.head().getName());
			tempR.insert(red.remove());
		}
		while (!tempR.isEmpty()) red.insert(tempR.remove());
		while (!green.isEmpty() && !blue.isEmpty()) {
			if (n == 1) {
				System.out.println(green.head().getName());
				tempG.insert(green.remove());
			}
			else {
				System.out.println(blue.head().getName());
				tempB.insert(blue.remove());
			}
			n++;
			if (n == 4) n = 1;
		}
		while (!green.isEmpty()) {
			System.out.println(green.head().getName());
			tempG.insert(green.remove());
		}
		while (!blue.isEmpty()) {
			System.out.println(blue.head().getName());
			tempB.insert(blue.remove());
		}
		while (!tempG.isEmpty()) green.insert(tempG.remove());
		while (!tempB.isEmpty()) blue.insert(tempB.remove());
	}
	

	
	@Override
	public String toString() {
		return "Shift [green=" + green + ", blue=" + blue + ", red=" + red + ", allTreated=" + allTreated + "]";
	}
	
	
	
}
