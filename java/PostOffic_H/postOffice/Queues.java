package postOffice;

@SuppressWarnings("unchecked")
public class Queues {
	private Queue<Integer>[] portholes;
	private Queue<Integer> allWaiters;
	private int nextWaiter;
	private int numOpenPortholes;
	
	public Queues() {
		this.portholes = new Queue[10];
		for (int i=0; i<this.portholes.length; i++) this.portholes[i] = new Queue<Integer>();
		this.allWaiters = new Queue<Integer>();
		this.numOpenPortholes = 0;
		this.nextWaiter = 1;
	}
	
	public void openNewPortholes() {
		this.numOpenPortholes++;
		fixQueues();
	}
	public void closeLastPortholes() {
		this.numOpenPortholes--;
		fixQueues();
	}
	public void addWaiter() {
		this.allWaiters.insert(nextWaiter);
		this.nextWaiter++;
		fixQueues();
	}
	public void fixQueues() {
		for (int i=0; i<numOpenPortholes; i++) while (!this.portholes[i].isEmpty()) this.portholes[i].remove();
		Queue<Integer> temp = new Queue<Integer>();
		int i = 0; 
		while (!this.allWaiters.isEmpty()) {
			temp.insert(this.allWaiters.head());
			this.portholes[i].insert(this.allWaiters.remove());
			i++;
			if (i == numOpenPortholes) i=0;
		}
		while (!temp.isEmpty()) this.allWaiters.insert(temp.remove());
	}
	public Queue<Integer> getPortholes(int num) {
		if (num > numOpenPortholes) return null;
		return this.portholes[num-1];
	}

	
	public String toString() {
		if (numOpenPortholes == 0) return "all close";
		String st = "";
		for (int i=0; i<numOpenPortholes; i++) {
			st = st + "porthole" + (i+1) + ": " + this.portholes[i] + "\n";
		}
		return st;
	}
	
	
}
