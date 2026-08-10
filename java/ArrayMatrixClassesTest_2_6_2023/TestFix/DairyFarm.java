package TestFix;

import Test.Cow;

public class DairyFarm {
	
	public static final int MAX = 1000;
	private Cow[] cows;
	private int noOfCows;
	
	public DairyFarm() {
		this.cows = new Cow[MAX];
		this.noOfCows = 0;
	}
	
	public void add(Cow cow) {
		if (noOfCows < MAX) {
			cows[noOfCows] = cow;
			noOfCows++;
		}
	}
	public Cow delete() {
		if (noOfCows == 0) {
			return null;
		}
		int iold = 0;
		for (int i=0; i<noOfCows; i++) {
			if (cows[i].getBirth().before(cows[iold].getBirth())) {
				iold = i;
			}
		}
		Cow old = cows[iold];
		cows[iold] = cows[noOfCows-1];
		noOfCows--;
		return old;
	}

	
	public String toString() {
		for (int i=0; i<noOfCows; i++) {
			System.out.println(cows[i]);
		}
		return "amount: "+this.noOfCows;
	}

}
