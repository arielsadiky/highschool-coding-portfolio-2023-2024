package QueueAndNode_9_2_2024;

public class Queue<T> {
	private Node<T> first;
	private Node<T> last;
	
	public Queue() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	public T head() {
		return this.first.getValue();
	}
	public void insert(T value) {
		if (this.first == null) { 
			this.first = new Node<T>(value);
			this.last = this.first;
		}
		else{
			this.last.setNext(new Node<T>(value));
			this.last = this.last.getNext();
		}
	}
	public T remove() {
		T head = head();
		this.first = this.first.getNext();
		return head;
	}

	public String toString() {
		if (this.first == null) return "Queue []";
		return "Queue ["+ this.first + "]";
	}
	
}
