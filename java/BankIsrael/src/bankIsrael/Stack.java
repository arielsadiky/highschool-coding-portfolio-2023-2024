package bankIsrael;

public class Stack<T> {
	private Node<T> stack;
	
	public Stack(){
		this.stack = null;
	}
	
	public boolean isEmpty(){
		return (this.stack == null);
	}
	public T top(){
		return this.stack.getValue();
	}
	public void push(T x){
		this.stack = new Node<T>(x, this.stack);
	}
	public T pop() { 
		T temp = this.stack.getValue();
		this.stack = this.stack.getNext();
		return temp;
	}

	public String toString() {
		if (this.isEmpty()) return "[]";
		return "["+this.stack+"]";
	}
	
}