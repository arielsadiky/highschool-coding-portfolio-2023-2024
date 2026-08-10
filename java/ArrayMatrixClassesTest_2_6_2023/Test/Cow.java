package Test;

import java.util.Random;

public class Cow {
	
	static Random rnd = new Random();
	private String name;
	private String id;
	private Date birth;
	
	public Cow() {
		this.name = "" + (char)('A' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26));;
		this.id = "" + rnd.nextInt(1000);
		this.birth = new Date();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String toString() {
		return "Cow [ name = " + name + ",  id = " + id + ",  birth = " + birth + " ]";
	}
	
}
