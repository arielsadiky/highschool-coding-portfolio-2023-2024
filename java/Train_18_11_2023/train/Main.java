package train;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		Carriage c1 = new Carriage(1, 5+rnd.nextInt(46));
		Carriage c2 = new Carriage(2, 5+rnd.nextInt(46));
		Carriage c3 = new Carriage(3, 5+rnd.nextInt(46));
		Carriage c4 = new Carriage(4, 5+rnd.nextInt(46));
		Carriage c5 = new Carriage(5, 5+rnd.nextInt(46));
		Carriage c6 = new Carriage(6, 5+rnd.nextInt(46));
		Carriage c7 = new Carriage(7, 5+rnd.nextInt(46));
		Carriage c8 = new Carriage(8, 5+rnd.nextInt(46));
		System.out.println("c1: "+c1);
		System.out.println("c2: "+c2);
		System.out.println("c3: "+c3);
		System.out.println("c4: "+c4);
		System.out.println("c5: "+c5);
		System.out.println("c6: "+c6);
		System.out.println("c7: "+c7);
		System.out.println("c8: "+c8);
		System.out.println();
		
		Stack<Carriage> s1 = new Stack<Carriage>();
		s1.push(c1); s1.push(c2); s1.push(c3); s1.push(c4);
		System.out.println("s1: "+s1);
		System.out.println();
		
		Locomotive l1 = new Locomotive(400, 1900+rnd.nextInt(124));
		Locomotive l2 = new Locomotive(401, 1900+rnd.nextInt(124));
		System.out.println("l1: "+l1);
		System.out.println("l2: "+l2);
		System.out.println();
		
		Train t1 = new Train(l1);
		Train t2 = new Train(l2, s1);
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
		System.out.println();
		
		t2.addCarriage(c5); System.out.println("t2: "+t2);
		t2.addCarriage(c6); System.out.println("t2: "+t2);
		t2.addCarriage(c7); System.out.println("t2: "+t2);
		t2.addCarriage(c8); System.out.println("t2: "+t2);
		System.out.println();
		
		System.out.println(t2.takeOutCarriage(3)); System.out.println("t2: "+t2);
		System.out.println(t2.takeOutCarriage(8)); System.out.println("t2: "+t2);
		System.out.println(t2.takeOutCarriage(1)); System.out.println("t2: "+t2);
		System.out.println();
		
		System.out.println(t2.reduceCarriages(l1)); System.out.println("t2: "+t2);
		
	}

}
