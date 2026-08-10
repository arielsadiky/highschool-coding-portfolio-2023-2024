package Bead;

public class MainBead {

	public static void main(String[] args) {
		// סוגי בניות
		Bead b1 = new Bead("red");
		Bead b2 = new Bead("green");
		b2.setNextBead(b1);
		Bead b3 = new Bead("green", b2);
		Bead b4= new Bead("blue", new Bead ("black"));
		b4.setNextBead(b3);
		
		// שרשרת לא מעגלית
		Bead b11 = new Bead("green");
		Bead b12 = new Bead("yellow", b11);
		Bead b13 = new Bead("red", b12);
		Bead b14 = new Bead("green", b13);
		Bead b15 = new Bead("yellow", b14);
		
		Bead b16 = new Bead("green");
		Bead b17 = new Bead("yellow", b16);
		Bead b18 = new Bead("red", b17);
		Bead b19 = new Bead("green", b18);
		Bead b20 = new Bead("yellow", b19);
				
		// שרשרת מעגלית
		Bead b6 = new Bead("white");
		Bead b7 = new Bead("green", b6);
		Bead b8 = new Bead("yellow", b7);
		Bead b9 = new Bead("blue", b8);
		Bead b10 = new Bead("orenge", b9);
		b6.setNextBead(b10);
		
		// ריצה על שרשרת לא מעגלית
		Bead p = b15;
		while (p != null) {
			p = p.getNextBead();
		}
		
		// ריצה על שרשרת מעגלית
		p = b10;
		while (p != b10) {
			p = p.getNextBead();
		}
		
		// פעולות על חרוזים
		
		// חיבור שרשראות
		print(mergeRegularToRegular(b15, b20));
		printCircal(mergeRegularToCircular(b20, b10));
		print(mergeCircularToRegular(buildRoundChain(), buildChain()));
		printCircal(mergeCircularToCircular(b10, buildRoundChain()));
		System.out.println();
		
		// יצירת שרשראות צבע אחד
		print(buildChainOneColor1(7, "yellow"));
		printCircal(buildRoundChainOneColor1(5, "green"));
		print(buildChainOneColor2(4, "red"));
		printCircal(buildRoundChainOneColor2(3, "blue"));
		System.out.println();
		
		// ספירת כמות חרוזים בשרשרת
		System.out.println(countNumBeads(buildChain()));
		System.out.println(countNumRoundBeads(buildRoundChain()));
		System.out.println();
		
		// מחיקת אי זוגיים
		print(buildChain());
		print(delOdd(buildChain()));
		System.out.println();
		printCircal(buildRoundChain());
		printCircal(delOddRound(buildRoundChain()));
		
		// מחיקת זוגיים
		print(buildChain());
		print(delEven(buildChain()));
		System.out.println();
		printCircal(buildRoundChain());
		printCircal(delEvenRound(buildRoundChain()));
		
	}
	
	public static void print(Bead b) {
		Bead p = b;
		while (p != null) {
			System.out.println(p);
			p = p.getNextBead();
		}
		System.out.println();
	}
	public static void printCircal(Bead b1) {
		Bead p = b1;
		while (p.getNextBead() != b1) {
			System.out.println(p);
			p = p.getNextBead();
		}
		System.out.println(p);
		System.out.println();
	}

	public static Bead buildChain() {
		Bead b11 = new Bead("red");
		Bead b12 = new Bead("orenge", b11);
		Bead b13 = new Bead("yellow", b12);
		Bead b14 = new Bead("green", b13);
		Bead b15 = new Bead("blue", b14);
		Bead b16 = new Bead("red", b15);
		Bead b17 = new Bead("orenge", b16);
		Bead b18 = new Bead("yellow", b17);
		Bead b19 = new Bead("green", b18);
		Bead b20 = new Bead("green", b19);
		return b20;
	}
	public static Bead buildRoundChain() {
		Bead b11 = new Bead("red");
		Bead b12 = new Bead("orenge", b11);
		Bead b13 = new Bead("yellow", b12);
		Bead b14 = new Bead("green", b13);
		Bead b15 = new Bead("blue", b14);
		Bead b16 = new Bead("red", b15);
		Bead b17 = new Bead("orenge", b16);
		Bead b18 = new Bead("yellow", b17);
		Bead b19 = new Bead("green", b18);
		Bead b20 = new Bead("green", b19);
		b11.setNextBead(b20);
		return b20;
	}
	
	public static Bead mergeRegularToRegular(Bead b1, Bead b2) {
		Bead p = b1;
		while (p.getNextBead() != null) {
			p = p.getNextBead();
		}
		p.setNextBead(b2);
		return b1;
	}
	public static Bead mergeRegularToCircular(Bead b1, Bead b2) {
		Bead p = b1;
		while (p.getNextBead() != null) {
			p = p.getNextBead();
		}
		p.setNextBead(b2);
		p = p.getNextBead();
		while (p.getNextBead() != b2) {
			p = p.getNextBead();
		}
		p.setNextBead(b1);
		return b1;
	}
	public static Bead mergeCircularToRegular(Bead b1, Bead b2) {
		Bead p = b1;
		while (p.getNextBead() != b1) {
			p = p.getNextBead();
		}
		p.setNextBead(b2);
		return b1;
	}
	public static Bead mergeCircularToCircular(Bead b1, Bead b2) {
		Bead p = b1;
		while (p.getNextBead() != b1) {
			p = p.getNextBead();
		}
		p.setNextBead(b2);
		p = p.getNextBead();
		while (p.getNextBead() != b2) {
			p = p.getNextBead();
		}
		p.setNextBead(b1);
		return b1;
	}

	public static Bead buildChainOneColor1(int amount, String color) {
		Bead b = null;
		while (amount>0) {
			b = new Bead(color, b);
			amount--;
		}
		return b;
	}
	public static Bead buildRoundChainOneColor1(int amount, String color) {
		Bead b = new Bead(color);
		amount--;
		Bead first = b;
		while (amount>0) {
			b = new Bead(color, b);
			amount--;
		}
		first.setNextBead(b);
		return b;
	}

	public static Bead buildChainOneColor2(int amount, String color) {
		if (amount == 0) {
			return null;
		}
		Bead b = new Bead(color);
		amount--;
		Bead temp = b;
		for (int i=0; i<amount; i++) {
			temp.setNextBead(new Bead(color));
			temp = temp.getNextBead();
		}
		return b;
	}
	public static Bead buildRoundChainOneColor2(int amount, String color) {
		if (amount == 0) {
			return null;
		}
		Bead b = new Bead(color);
		amount--;
		Bead temp = b;
		for (int i=0; i<amount; i++) {
			temp.setNextBead(new Bead(color));
			temp = temp.getNextBead();
		}
		temp.setNextBead(b);
		return b;
	}
	
	public static int countNumBeads(Bead b) {
		int count = 1;
		Bead p = b;
		while (p.getNextBead() != null) {
			count++;
			p = p.getNextBead();
		}
		return count;
	}
	public static int countNumRoundBeads(Bead b) {
		int count = 1;
		Bead p = b;
		while (p.getNextBead() != b) {
			count++;
			p = p.getNextBead();
		}
		return count;
	}
	
	public static Bead delOdd(Bead b) {
		b = b.getNextBead();
		Bead p = b;
		while((p.getNextBead() != null) && (p.getNextBead().getNextBead() != null)) {
			p.setNextBead(p.getNextBead().getNextBead());
			p = p.getNextBead();
		}
		if ((p.getNextBead() != null) && (p.getNextBead().getNextBead() == null)) {
			p.setNextBead(null);
		}
		return b;
	}
	public static Bead delOddRound(Bead b) {
		Bead p = b.getNextBead();
		while((p.getNextBead() != b) && (p.getNextBead().getNextBead() != b)) {
			p.setNextBead(p.getNextBead().getNextBead());
			p = p.getNextBead();
		}
		p.setNextBead(b.getNextBead());
		return p.getNextBead();
	}
	
	public static Bead delEven(Bead b) {
		Bead p = b;
		while((p.getNextBead() != null) && (p.getNextBead().getNextBead() != null)) {
			p.setNextBead(p.getNextBead().getNextBead());
			p = p.getNextBead();
		}
		if ((p.getNextBead() != null) && (p.getNextBead().getNextBead() == null)) {
			p.setNextBead(null);
		}
		return b;
	}
	public static Bead delEvenRound(Bead b) {
		Bead p = b;
		while((p.getNextBead() != b) && (p.getNextBead().getNextBead() != b)) {
			p.setNextBead(p.getNextBead().getNextBead());
			p = p.getNextBead();
		}
		p.setNextBead(b);
		return p.getNextBead();
	}
	
}	
