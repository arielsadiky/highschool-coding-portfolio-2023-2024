package QueueNodeOOP_1_3_2024_fixed;

import java.util.Random;

import QueueAndNode_9_2_2024.Queue;

public class Main {

	public static void main(String[] args) {
		// 1)
		Queue<Integer> q = new Queue<Integer>();
		q.insert(3);
		q.insert(9);
		q.insert(5);
		q.insert(1);
		q.insert(7);
		System.out.println(q);
		olaf(q, 3);
		System.out.println(q);
		System.out.println();
		
		// 2)
		ShoppingList s = new ShoppingList();
		System.out.println(s);
		s.budgetCut(100);
		System.out.println(s);
		System.out.println();
		
		// 3)
		Random rnd = new Random();
		Queue<Integer> n = new Queue<Integer>();
		for (int i=0; i<10; i++) {
			n.insert(1 + rnd.nextInt(6));
		}
		System.out.println(n);
		System.out.println(longestStreakPos(n));
		System.out.println(n);
		removeLongestStreak(n);
		System.out.println(n);
		System.out.println();
		
		// 4)
		Character[] c = new Character[rnd.nextInt(5) + 5];
		for (int i=0; i<c.length; i++) {
			if (rnd.nextInt(4) == 0) {
				c[i] = new Mage();
			}
			else if (rnd.nextInt(4) == 1) {
				c[i] = new HealingMage();
			}
			else if (rnd.nextInt(4) == 2) {
				c[i] = null;
			}
			else c[i] = new FireMage();
		}
		for (int i=0; i<c.length; i++) System.out.println(c[i]);
		System.out.println();
		for (int i=0; i<c.length; i++) { 
			if (c[i] == null) {
				System.out.println("null");
			}
			else System.out.println(c[i].getPowerLevel());
		
		}
		System.out.println();
		System.out.println(canDefatWizard(c, 40));
		System.out.println(canDefatWizard(c, 4000));
		System.out.println(missingDragons(c));
		
	}
	
	public static void moveAllToQueue(Queue<Integer> q1, Queue<Integer> q2) {
		while (!q1.isEmpty()) q2.insert(q1.remove());;
	}
	
	public static void olaf(Queue<Integer> q, int num) {
		Queue<Integer> temp = new Queue<Integer>();
		olaf(q, num, temp);
		moveAllToQueue(temp, q);
	}

	public static void olaf(Queue<Integer> q, int num, Queue<Integer> temp) {
		if (q.isEmpty()) return;
		int val = q.remove();
		if (num == 0) {
		    temp.insert(val);
		    olaf(q, 0, temp);
		}
		else {
		    olaf(q, num - 1, temp);
		    q.insert(val);
		}
	}
	
	public static int longestStreakPos(Queue<Integer> q){
        if (q.isEmpty()) return 0;
        Queue<Integer> temp = new Queue<Integer>();
        int i = 1;
        int pos = 2;
        int count = 1;
        int max = 1;
        int x = q.remove();
        while (!q.isEmpty()){
            if (x != q.head()){
                if (count > max){
                    i = pos - count;
                    max = count;
                }
                count = 1;
            }
            else  count++;
            temp.insert(x);
            x = q.remove();
            pos++;
        }
        if (count > max){
                i = pos - count;
                max = count;
        }
        while (!temp.isEmpty()) q.insert(temp.remove());
        q.insert(x);
        return i;
	}
	
	public static void removeLongestStreak(Queue<Integer> q){
	    if (q.isEmpty()) return;
	    int longestPos = longestStreakPos(q);
	    int count = 1;
	    Queue<Integer> temp = new Queue<Integer>();
	    while (count < longestPos  &&  !q.isEmpty()){
            count++;
            temp.insert(q.remove());
	    }
	    int num = q.head();
	    while (!q.isEmpty()  &&  q.head() == num) q.remove();
	    while (!q.isEmpty()) temp.insert(q.remove());
	    while (!temp.isEmpty()) q.insert(temp.remove());
	}

	public static boolean canDefatWizard(Character[] c, int wizardPower) {
		int powerSum = 0;
		for (int i=0; i<c.length; i++) {
			if (c[i] != null) {
				powerSum += c[i].getPowerLevel();
			}
		}
		return (powerSum > wizardPower);
	}
	
	public static int missingDragons(Character[] c) {
		int dragonAmount = 0;
		int emptySlots = 0;
		for (int i=0; i<c.length; i++) {
			if (c[i] == null) emptySlots++;
			else {
				if (c[i] instanceof FireMage) {
					if (((FireMage)(c[i])).hasDragon()) dragonAmount++;
				}
			}
		}
		int amountNeeded = (c.length - emptySlots)/3;
		if ((c.length - emptySlots)%3 != 0) amountNeeded++;
		if (amountNeeded < dragonAmount) return 0;
		return (amountNeeded - dragonAmount);
	}


}
