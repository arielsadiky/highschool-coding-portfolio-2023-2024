package train;

public class Carriage {
	private int serialNum;
	private int passengersNum;
	private static int MAX_PASSENGERS = 50;
	
	public Carriage(int serialNum, int passengersNum) {
		this.serialNum = serialNum;
		this.passengersNum = passengersNum;
	}
	
 	public int getSerialNum() {
		return this.serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public int getPassengersNum() {
		return this.passengersNum;
	}
	public void setPassengersNum(int passengersNum) {
		this.passengersNum = passengersNum;
	}
	public int getMax() {
		return MAX_PASSENGERS;
	}

	
	public String toString() {
		return "[serialNum=" + serialNum + ", passengersNum=" + passengersNum + "]";
	}
	
}
