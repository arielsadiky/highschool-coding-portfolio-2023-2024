package Game;

public class DiceNode {
	private Dice value;
	private DiceNode next;
	
	public DiceNode(Dice value) {
		this.value = value;
		this.next = null;
	}
	public DiceNode(Dice value, DiceNode next) {
		this.value = value;
		this.next = next;
	}
	
	public Dice getValue() {
		return value;
	}
	public DiceNode getNext() {
		return this.next;
	}
	public boolean hasNext() {
		return this.next != null;
	}
	public void setValue(Dice value) {
		this.value = value;
	}
	public void setNext(DiceNode next) {
		this.next = next;
	}
	
	public String toString() {
		if (this.next == null) return this.value + "";
		return this.value + ", " + this.next;
	}
}
