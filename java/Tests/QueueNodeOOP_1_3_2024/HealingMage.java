package QueueNodeOOP_1_3_2024;

import java.util.Arrays;

public class HealingMage extends Mage{
	private Character[] supported;
	
	public HealingMage() {
		super();
		this.supported = new Character[rnd.nextInt(9) + 1];
		for (int i=0; i<supported.length; i++) {
			if (rnd.nextInt(2) == 0) {
				this.supported[i] = new Mage();
			}
			else this.supported[i] = new FireMage();
		}
	}
	
	public Character[] getSupported() {
		return supported;
	}
	public void setSupported(Character[] supported) {
		this.supported = supported;
	}

	public int getPowerLevel() {
		int power = super.getPowerLevel();
		for (int i=0; i<supported.length; i++) {
			power += (0.25*supported[i].getPowerLevel());
		}
		return power;
	}

	@Override
	public String toString() {
		return super.toString() + "HealingMage [supported=" + Arrays.toString(supported) + "]";
	}
	
}
