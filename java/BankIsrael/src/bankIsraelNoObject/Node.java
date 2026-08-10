package bankIsraelNoObject;

public class Node {
	private Banknote value;
	private Node next;
	
	public Node(Banknote value) {
		this.value = value;
		this.next = null;
	}
	public Node(Banknote value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public Banknote getValue() {
		return value;
	}
	public Node getNext() {
		return this.next;
	}
	public boolean hasNext() {
		return this.next != null;
	}
	public void setValue(Banknote value) {
		this.value = value;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		if (this.value == null) return "";
		if (this.next == null) return "" + this.value;
		return this.value + "," + this.next;
	}
	
}
