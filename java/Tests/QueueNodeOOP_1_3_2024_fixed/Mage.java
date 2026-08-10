package QueueNodeOOP_1_3_2024_fixed;

import java.util.Arrays;

public class Mage extends Character{
	protected String[] spells;
	
	public Mage() {
		super();
		this.spells = new String[rnd.nextInt(9) + 1];
		String str;
		for (int i=0; i<spells.length; i++) {
			str = "";
			for (int j=0; j<7; j++) str += (char)((int)('a')+rnd.nextInt((int)('z')-(int)('a')+1));
			spells[i] = str;
		}
	}
	
	public String[] getSpells() {
		return spells;
	}
	public void setSpells(String[] spells) {
		this.spells = spells;
	}

	public double getPowerLevel() {
		return (super.getPowerLevel() + 15*this.spells.length);
	}

	@Override
	public String toString() {
		return super.toString() + "Mage [spells=" + Arrays.toString(spells) + "]";
	}
	
}
