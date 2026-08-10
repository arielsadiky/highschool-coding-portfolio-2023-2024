package postOffice;

public class Main {

	public static void main(String[] args) {
		Queues a = new Queues();
		System.out.println(a);
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		a.openNewPortholes();
		System.out.println(a);
		a.openNewPortholes();
		System.out.println(a);
		a.openNewPortholes();
		System.out.println(a);
		a.openNewPortholes();
		System.out.println(a);
		a.openNewPortholes();
		System.out.println(a);
		a.closeLastPortholes();
		a.addWaiter();
		a.addWaiter();
		a.addWaiter();
		System.out.println(a);
		a.closeLastPortholes();
		System.out.println(a);
		
	}

}
