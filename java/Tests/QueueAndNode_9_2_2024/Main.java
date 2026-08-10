package QueueAndNode_9_2_2024;

public class Main {

	public static void main(String[] args) {
		// 1) b)
		MythGod[] gods = new MythGod[10];
		for (int i=0; i<gods.length; i++) gods[i] = new MythGod();
		gods[2] = null;
		gods[7] = null;
		for (int i=0; i<gods.length; i++) System.out.println(gods[i]);
		System.out.println();
		System.out.println();
		uniqueGreekGods(gods);
		
		// 2) a)
		System.out.println();
		System.out.println();
		System.out.println();
		Queue<Integer> q = new Queue<Integer>();
		for (int i=1; i<8; i++) q.insert(i);
		System.out.println(geshem(q, 4));
		System.out.println(q);
		/*
		// 3) a)
		System.out.println();
		System.out.println();
		System.out.println();
		Test t = new Test();
		t.addGrade(new ExamGrade());
		System.out.println(t);
		t.addGrade(new ExamGrade());
		System.out.println(t);
		t.addGrade(new ExamGrade());
		System.out.println(t);
		t.addGrade(new ExamGrade());
		System.out.println(t);
		t.addGrade(new ExamGrade());
		System.out.println(t);
		t.addGrade(new ExamGrade());
		System.out.println(t);
		*/
		// 4) a)
		System.out.println();
		System.out.println();
		System.out.println();
		Queue<Integer> Q = new Queue<Integer>();
		Q.insert(2);
		Q.insert(10);
		Q.insert(12);
		Q.insert(3);
		Q.insert(7);
		Q.insert(4);
		Q.insert(1);
		System.out.println(Q);
		System.out.println(putInPlace(Q, 9));
		System.out.println(Q);
		
		// 4) c)
		System.out.println();
		System.out.println();
		System.out.println();
		putAllInPlace(Q);
		System.out.println(Q);
		
		int[][] g = new int[4][5];
		for (int i=0; i<g.length; i++) {
	        for (int j=0; j<g[i].length; j++) {
	                g[i][j] =0;
	        } 
		}
		
		for (int i=0; i<g.length; i++) {
	        for (int j=0; j<g[i].length; j++) {
	                System.out.print(" "+g[i][j]);
	        }
	        System.out.println();
		}
		System.out.println();

		
		
	}
	
	public static void uniqueGreekGods(MythGod[] gods) {
		int[] powers = new int[10];
		for (int i=0; i<powers.length; i++) {
			powers[i] = -1;
		}
		for (int i=0; i<gods.length; i++) {
			if (gods[i] != null) {
				if (powers[gods[i].getForce()] != -1) {
					powers[gods[i].getForce()] = -2;
				}
				else powers[gods[i].getForce()] = i;
			}
		}
		for (int i=1; i<powers.length; i++) {
			if (powers[i] >= 0  &&  !gods[powers[i]].isRoman()) {
				System.out.println(gods[powers[i]]);
				// .getName()
			}
		}
	}

	public static int geshem(Queue<Integer> q, int k) {
		if (k == 0) return 0;
		int x = q.remove();
		int y = geshem(q, k-1);
		q.insert(x);
		return x+y;
	}
	
	public static int putInPlace(Queue<Integer> q, int num) {
		Queue<Integer> small = new Queue<Integer>();
		Queue<Integer> bigOrEqual = new Queue<Integer>();
		while (!q.isEmpty()) {
			if (q.head() < num) {
				small.insert(q.remove());
			}
			else bigOrEqual.insert(q.remove());
		}
		int count = 1;
		while (!small.isEmpty()) {
			q.insert(small.remove());
			count++;
		}
		q.insert(num);
		while (!bigOrEqual.isEmpty()) q.insert(bigOrEqual.remove());
		return count;
	}
	
	public static void putAllInPlace(Queue<Integer> q) {
		Queue<Integer> temp = new Queue<Integer>();
		while (!q.isEmpty()) {
			putInPlace(temp, q.remove());
		}
		while (!temp.isEmpty()) {
			q.insert(temp.remove());
		}
	}
}
