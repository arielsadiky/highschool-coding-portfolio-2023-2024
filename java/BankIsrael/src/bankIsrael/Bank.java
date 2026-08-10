package bankIsrael;

@SuppressWarnings("unchecked")
public class Bank {
	private int[] notesValuse;
	private Stack<Banknote>[] notes;
	private int[] numOfEach;
	
	
	public Bank() {
		this.notesValuse = new int[]{20, 50, 100, 200};
		this.notes = (Stack<Banknote>[]) new Object[] {new Stack<Banknote>(), new Stack<Banknote>(), new Stack<Banknote>(), new Stack<Banknote>()};
		this.numOfEach = new int[]{0, 0, 0, 0};
	}
	
	public int getNumOfNote(int value) {
		int i = 0;
		while (i <= this.notesValuse.length  &&  this.notesValuse[i] != value) i++;
		return numOfEach[i];
	}
	public int getSumOfNotes(int value) {
		int i = 0;
		while (i <= this.notesValuse.length  &&  this.notesValuse[i] != value) i++;
		return numOfEach[i]*value;
	}

	public boolean isNoteTypIn(int value) {
		for (int i = 0; i<this.notesValuse.length; i++) {
			if (this.notesValuse[i] == value) return true;
		}
		return false;
	}
	public void addNewNoteTyp(int value) {
		int[] temp1 = new int[this.notesValuse.length + 1];
		Stack<Banknote>[] temp2 = (Stack<Banknote>[]) new Object[this.notes.length + 1];
		int[] temp3 = new int[this.numOfEach.length + 1];
		
		for (int i = 0, j = 0; i<temp1.length && j<=i; i++, j++) {
			if (this.notesValuse[j] == value) { 
				temp1[i] = value;
				j--;
			}
			else temp1[i] = this.notesValuse[j];
		}
		for (int i = 0, j = 0; i<temp2.length && j<=i; i++, j++) {
			if (temp1[i] == value) {
				temp2[i] = new Stack<Banknote>();
				j--;
			}
			else temp2[i] = this.notes[j];
		}
		for (int i = 0, j = 0; i<temp3.length && j<=i; i++, j++) {
			if (temp1[i] == value) {
				temp3[i] = 0;
				j--;
			}
			else temp3[i] = this.numOfEach[j];
		}
		
		this.notesValuse = temp1;
		this.notes = temp2;
		this.numOfEach = temp3;
	}
	
	public void addNumNotes(int value, int num) {
		if (!isNoteTypIn(value)) this.addNewNoteTyp(value);
		int i=0;
		while (i <= this.notesValuse.length  &&  this.notesValuse[i] != value) i++;
		while (num>0) {
			this.notes[i].push(new Banknote(value));
		}
	}
	public Stack<Banknote> transferMoneyToCorporation(int requested){
		Stack<Banknote> corporation = new Stack<Banknote>();
		int leftToAdd = requested;
		for (int i = this.notesValuse.length-1; i >= 0; i--) {
			while (leftToAdd > 0  &&  !this.notes[i].isEmpty()  &&  this.notes[i].top().getValue() <= leftToAdd) {
				leftToAdd = leftToAdd-this.notes[i].top().getValue();
				corporation.push(this.notes[i].pop());
			}
		}
		
		
		return corporation;
	}


	public String toString() {
		String str = "Value: " + this.notes[0].top();
		for (int i=1; i<this.notes.length; i++) {
			str = str + ", " + this.notes[i].top();
		}
		str = str +"\nAmount: " + this.numOfEach[0];
		for (int i=1; i<this.numOfEach.length; i++) {
			str = str + ", " + this.numOfEach[i];
		}
		return str;
	}
	
	
	
}
