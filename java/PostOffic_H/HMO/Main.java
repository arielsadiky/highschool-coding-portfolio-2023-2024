package HMO;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		Shift s = new Shift();
		for (int i=0; i<10; i++) {
			s.addToRightQueue(new Patient(), rnd.nextInt(3)+1);
		}
		System.out.println(s);
		System.out.println();
		System.out.println();
		s.printPatients();
		System.out.println(s.next());
		s.beingTreated();
		s.beingTreated();
		System.out.println();
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println();
		s.printPatients();
		System.out.println(s.next());
		s.beingTreated();
		s.beingTreated();
		System.out.println();
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println();
		s.printPatients();
		System.out.println(s.next());
		s.beingTreated();
		s.beingTreated();
		System.out.println();
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println();
		s.printPatients();
		System.out.println(s.next());
		s.beingTreated();
		s.beingTreated();
		System.out.println();
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println();
		s.printPatients();
		System.out.println(s.next());
		

	}

}
