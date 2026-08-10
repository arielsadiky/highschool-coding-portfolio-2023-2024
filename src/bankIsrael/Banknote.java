package bankIsrael;

public class Banknote {
	private int value;
	private int serialNum;
	private static int count = 100000;
	
	public Banknote(int value) {
		this.value = value;
		this.serialNum = count;
		count++;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSerialNum() {
		return serialNum;
	}


	public String toString() {
		return value + "₪";
	}
	
	
}
