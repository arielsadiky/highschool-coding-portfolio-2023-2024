package bankIsraelNoObject;

public class Bank {
	private int[] notesValuse;
	private Stack[] notes;
	private int[] numOfEach;
	
	public Bank() {
		this.notesValuse = new int[]{20, 50, 100, 200};
		this.notes = new Stack[] {new Stack(), new Stack(), new Stack(), new Stack()};
		this.numOfEach = new int[]{0, 0, 0, 0};
	}
	
	public int getNumOfNote(int value) {
		int i = 0;
		while (i <= this.notesValuse.length  &&  this.notesValuse[i] != value) i++;
		return numOfEach[i];
	}
	public int getSumOfNotes(int value) {
		return getNumOfNote(value)*value;
	}

	public boolean isNoteTypIn(int value) {
		for (int i = 0; i<this.notesValuse.length; i++) {
			if (this.notesValuse[i] == value) return true;
		}
		return false;
	}
	public void addNewNoteTyp(int value) {
		int[] temp1 = new int[this.notesValuse.length + 1];
		Stack[] temp2 = new Stack[this.notes.length + 1];
		int[] temp3 = new int[this.numOfEach.length + 1];
		
		System.out.println(temp1.length);
		if (this.notesValuse[0] > value) {
			temp1[0] = value;
			temp2[0] = new Stack();
			temp3[0] = 0;
			for (int i = 1; i<temp1.length; i++) {
				temp1[i] = this.notesValuse[i-1];
				temp2[i] = this.notes[i-1];
				temp3[i] = this.numOfEach[i-1];
			}
		}
		else {
			temp1[0] = this.notesValuse[0];
			temp2[0] = this.notes[0];
			temp3[0] = this.numOfEach[0];
			for (int i = 1, j = 1; i<temp1.length  &&  j<temp1.length-1; i++, j++) {
				if (temp1[i-1] < value  &&  this.notesValuse[j] > value) { 
					temp1[i] = value;
					temp2[i] = new Stack();
					temp3[i] = 0;
					j--;
				}
				else { 
					temp1[i] = this.notesValuse[j];
					temp2[i] = this.notes[j];
					temp3[i] = this.numOfEach[j];
				}
			}
			if (temp1[temp1.length-1] == 0) {
				temp1[temp1.length-1] = value;
				temp2[temp2.length-1] = new Stack();
				temp3[temp3.length-1] = 0;
			}
		}
		this.notesValuse = temp1;
		this.notes = temp2;
		this.numOfEach = temp3;
	}
	public void addNumNotes(int value, int num) {
		if (!isNoteTypIn(value)) this.addNewNoteTyp(value);
		int i=0;
		while (i <= this.notesValuse.length  &&  this.notesValuse[i] != value) i++;
		System.out.println(i);
		while (num>0) {
			this.notes[i].push(new Banknote(value));
			num--;
			this.numOfEach[i]++;
		}
	}
	public Stack transferMoneyToCorporation(int requested){
		Stack corporation = new Stack();
		int leftToAdd = requested;
		for (int i = this.notesValuse.length-1; i >= 0; i--) {
			while (leftToAdd > 0  &&  !this.notes[i].isEmpty()  &&  this.notes[i].top().getValue() <= leftToAdd) {
				leftToAdd = leftToAdd-this.notes[i].top().getValue();
				corporation.push(this.notes[i].pop());
				this.numOfEach[i]--;
			}
		}
		return corporation;
	}

	public String toString() {
		String str = "Value: " + this.notesValuse[0] + "₪";
		for (int i=1; i<this.notesValuse.length; i++) {
			str = str + ", " + this.notesValuse[i] + "₪";
		}
		str = str +"\nAmount: " + this.numOfEach[0];
		for (int i=1; i<this.numOfEach.length; i++) {
			str = str + ", " + this.numOfEach[i];
		}
		return str;
	}
	
	
	
}
