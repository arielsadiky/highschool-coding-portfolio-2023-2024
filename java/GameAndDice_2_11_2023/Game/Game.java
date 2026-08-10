package Game;

import java.util.Random;

public class Game {
	private DiceNode[] rolls;
	private int[] points;
	private static Random rnd = new Random();
	
	public Game(int numOfPleyers) {
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
		DiceNode p = rolls[playerNum];
		int count = 0;
		while (p != null) {
			if (p.getValue().getNum1() == p.getValue().getNum2()) count++;
			p = p.getNext();
		}
		return count;
	}
	public void printIncidenceOfRolls(int playerNum) {
		if (playerNum >= rolls.length) return;
		int[] count = new int[12];
		for (int i=0; i<count.length; i++) {
			count[i] = 0;
		}
		DiceNode p = rolls[playerNum];
		while (p != null) {
			count[p.getValue().getNum1()+p.getValue().getNum2()-1]++;
			p = p.getNext();
		}
		System.out.println("player" + (playerNum+1) + ": ");
		for (int i=2; i<count.length+1; i++) {
			if (i<10) System.out.print("  "+(i));
			else System.out.print(" "+(i));
		}
		System.out.println();
		for (int i=1; i<count.length; i++) {
			if (count[i]<10) System.out.print("  "+(count[i]));
			else System.out.print(" "+(count[i]));
		}
		System.out.println();
	}

	public String toString() {
		System.out.print("rolls: ");
		for (int i=0; i<rolls.length; i++) {
			System.out.print("[" + rolls[i] + "], ");
		}
		System.out.println();
		System.out.print("points: ");
		for (int i=0; i<points.length; i++) {
			System.out.print(points[i] + ", ");
		}
		System.out.println();
		return "";
	}
}
