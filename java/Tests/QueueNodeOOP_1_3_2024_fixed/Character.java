package QueueNodeOOP_1_3_2024_fixed;

import java.util.Random;

public class Character {
	protected String name;
	protected int level;
	protected static Random rnd = new Random();
	
	public Character() {
		String str = "";
		for (int i=0; i<5; i++) str += (char)((int)('a')+rnd.nextInt((int)('z')-(int)('a')+1));
		this.name = str;
		this.level = rnd.nextInt(9) + 1;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public double getPowerLevel() {
		return this.level*5;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", level=" + level + "]";
	}

}
