package bankIsraelNoObject;

public class Main {

	public static void main(String[] args) {
		Bank b1 = new Bank();
		System.out.println(b1);
		System.out.println(b1.isNoteTypIn(200));
		System.out.println(b1.isNoteTypIn(70));
		b1.addNewNoteTyp(10);
		System.out.println(b1);
		b1.addNewNoteTyp(1000);
		System.out.println(b1);
		b1.addNewNoteTyp(60);
		System.out.println(b1);
		b1.addNumNotes(10, 5);
		System.out.println(b1);
		b1.addNumNotes(200, 4);
		System.out.println(b1);
		b1.addNumNotes(1000, 6);
		System.out.println(b1);
		b1.addNumNotes(10, 5);
		System.out.println(b1);
		b1.addNumNotes(20, 4);
		System.out.println(b1);
		b1.addNumNotes(50, 4);
		System.out.println(b1);
		b1.addNumNotes(100, 6);
		System.out.println(b1);
		System.out.println(b1.transferMoneyToCorporation(2380));
		System.out.println(b1);

	}

}
