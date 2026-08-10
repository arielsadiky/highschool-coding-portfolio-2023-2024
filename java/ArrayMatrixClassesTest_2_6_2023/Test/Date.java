package Test;

import java.util.Random;

public class Date {
	
	static Random rnd = new Random();
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this.day = 1 + rnd.nextInt(29);
		this.month = 1 + rnd.nextInt(11);
		this.year = 1950 + rnd.nextInt(70);
	}
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	public int getDay() {
		return this.day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return this.month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean after(Date other) {
		if (this.year > other.getYear()) {
			return true;
		}
		if (this.year = other.getYear()) {
			if (this.month > other.getMonth()) {
				return true;
			}
			if ((this.month == other.getMonth()) && (this.day > other.getDay())) {
				return true;
			}
		}
		return false;
	}
	public boolean before(Date other) {
		Date x = new Date(this.day, this.month, this.year);
		return other.after(x);
	}
	
	public String toString() {
        return this.day+"/"+this.month+"/"+this.year;
	}

	
}
