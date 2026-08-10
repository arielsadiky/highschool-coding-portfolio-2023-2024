package QueueAndNode_9_2_2024;

import java.util.Random;

public class MythGod {
	private String name;
	private boolean isRoman;
	private int force;
	private static Random rnd = new Random();
	
	public MythGod() {
		String str = "";
		for (int i=0; i<5; i++) str += (char)((int)('a')+rnd.nextInt((int)('z')-(int)('a')+1));
		this.name = str;
		this.isRoman = (rnd.nextInt(2) == 0);
		this.force = rnd.nextInt(9) + 1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRoman() {
		return this.isRoman;
	}

	public void setRoman(boolean isRoman) {
		this.isRoman = isRoman;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	@Override
	public String toString() {
		return "MythGod [name=" + name + ", isRoman=" + isRoman + ", force=" + force + "]";
	}
	

	
}
