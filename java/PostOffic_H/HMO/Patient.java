package HMO;

import java.util.Random;

public class Patient {
	private String name;
	public static Random rnd = new Random();
	
	public Patient() {
		String str = "";
		for (int i=0; i<7; i++) str += (char)((int)('a')+rnd.nextInt((int)('z')-(int)('a')+1));
		this.name = str;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "   " + name;
	}
}
