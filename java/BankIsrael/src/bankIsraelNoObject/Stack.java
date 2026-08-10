package bankIsraelNoObject;

public class Stack {
	private Node stack;
	
	public Stack(){
		this.stack = null;
	}
	
	public boolean isEmpty(){
		return (this.stack == null);
	}
	public Banknote top(){
		return this.stack.getValue();
	}
	public void push(Banknote x){
		this.stack = new Node(x, this.stack);
	}
	public Banknote pop() { 
		Banknote temp = this.stack.getValue();
		this.stack = this.stack.getNext();
		return temp;
	}

	public String toString() {
		if (this.isEmpty()) return "[]";
		return "["+this.stack+"]";
	}
	
}