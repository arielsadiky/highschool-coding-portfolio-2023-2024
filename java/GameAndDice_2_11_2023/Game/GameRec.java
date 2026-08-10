package Game;

import java.util.Random;

public class GameRec {
	private DiceNode[] rolls;
	private int[] points;
	private static Random rnd = new Random();
	
	public GameRec(int numOfPleyers) {
		this.rolls = new DiceNode[numOfPleyers];
		this.points = new int[numOfPleyers];
	}
	
	public Dice rollDice() {
		return new Dice(1+rnd.nextInt(6), 1+rnd.nextInt(6));
	}
	public void turn(int playerNum, Dice roll) {
		if (playerNum >= rolls.length) return;
		if (roll.getNum1() == 6  &&  roll.getNum2() == 6) { 
			rolls[playerNum] = new DiceNode(roll, rolls[playerNum]);
			points[playerNum] = points[playerNum] + roll.getNum1() + roll.getNum2();
			roll = rollDice();
		}
		rolls[playerNum] = new DiceNode(roll, rolls[playerNum]);
		points[playerNum] = points[playerNum] + roll.getNum1() + roll.getNum2();
	}
	public int playerNumNext(int playerNum) {
		if (playerNum >= rolls.length-1) return 0;
		return playerNum+1;
	}
	public int getPlyerPoints(int playerNum) {
		if (playerNum >= rolls.length) return -1;
		return points[playerNum];
	}
	public int getPlyerDubleNum(int playerNum) {
		if (playerNum >= rolls.length) return -1;
		return getPlyerDubleNum(rolls[playerNum], 0);
	}
	public int getPlyerDubleNum(DiceNode p, int count) {
		if (p == null) return count;
		if (p.getValue().getNum1() == p.getValue().getNum2()) count++;
		return getPlyerDubleNum(p.getNext(), count);
	}
	public void printIncidenceOfRolls(int playerNum) {
		if (playerNum >= rolls.length) return;
		int[] count = new int[12];
		startUp(0, count);
		printIncidenceOfRolls(rolls[playerNum], count);
		System.out.println("player" + (playerNum+1) + ": ");
		print2to12(2, count);
		System.out.println();
		printCount(1, count);
		System.out.println();
	}
	public void printIncidenceOfRolls(DiceNode p, int[] count) {
		if (p == null) return;
		count[p.getValue().getNum1()+p.getValue().getNum2()-1]++;
		printIncidenceOfRolls(p.getNext(), count);
	}
	public void startUp(int i, int[] count) {
		if (i == count.length) return;
		count[i] = 0;
		startUp(i+1, count);
	}
	public void print2to12(int i, int[] count) {
		if (i == count.length+1) return;
		if (i<10) System.out.print("  "+(i));
		else System.out.print(" "+(i));
		print2to12(i+1, count);
	}
	public void printCount(int i, int[] count) {
		if (i == count.length) return;
		if (count[i]<10) System.out.print("  "+(count[i]));
		else System.out.print(" "+(count[i]));
		printCount(i+1, count);
	}

	public void printRolls(int i) {
		if (i == rolls.length) return;
		System.out.print("[" + rolls[i] + "], ");
		printRolls(i+1);
	}
	public void printPoints(int i) {
		if (i == points.length) return;
		System.out.print(points[i] + ", ");
		printPoints(i+1);
	}
	public String toString() {
		System.out.print("rolls: ");
		printRolls(0);
		System.out.println();
		System.out.print("points: ");
		printPoints(0);
		System.out.println();
		return "";
	}
}
