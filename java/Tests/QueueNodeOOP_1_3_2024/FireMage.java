package QueueNodeOOP_1_3_2024;

public class FireMage extends Mage{
	private boolean hasDragon;
	
	public FireMage() {
		super();
		this.hasDragon = (rnd.nextInt(2) == 0);
	}

	public boolean hasDragon() {
		return hasDragon;
	}
	public void setHasDragon(boolean hasDragon) {
		this.hasDragon = hasDragon;
	}
	
	public int getPowerLevel() {
		int power = super.getPowerLevel();
		if (this.hasDragon) return power*1.5;
		return power;
	}

	@Override
	public String toString() {
		return super.toString() + "FireMage [hasDragon=" + hasDragon + "]";
	}
	
}
