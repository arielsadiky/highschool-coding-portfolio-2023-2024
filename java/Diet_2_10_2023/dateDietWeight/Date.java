package dateDietWeight;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
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
	
	public int numOfDays(Date d) {   // O(1)
		if (this.year > d.getYear()) {
			if (this.month < d.getMonth()){
				return (this.day-d.getDay()) + ((12-d.getMonth()+this.month)*30) + ((this.year-d.getYear()-1)*12*30); 
			}
			if(this.month == d.getMonth()) {
				return ((this.year-d.getYear())*12*30) + (this.day-d.getDay());
			}
			return ((this.year-d.getYear())*12*30) + ((this.month-d.getMonth())*30) + (this.day-d.getDay());
		}
		if(this.year == d.getYear()) {
			if (this.month < d.getMonth()){
				return (d.getDay()-this.day) + ((d.getMonth()-this.month)*30); 
			}
			if(this.month == d.getMonth()) {
				if (this.day > d.getDay()) return (this.day-d.getDay());
				if (this.day == d.getDay()) return 0;
				if (this.day < d.getDay()) return (d.getDay()-this.day);
			}
			return ((this.month-d.getMonth())*30) + (this.day-d.getDay());
		}
		if (this.month > d.getMonth()){
			return (d.getDay()-this.day) + ((12-this.month+d.getMonth())*30) + ((d.getYear()-this.year-1)*12*30); 
		}
		if(this.month == d.getMonth()) {
			return ((d.getYear()-this.year)*12*30) + (d.getDay()-this.day);
		}
		return ((d.getYear()-this.year)*12*30) + ((d.getMonth()-this.month)*30) + (d.getDay()-this.day);
		
	}


	public String toString() {
		return "<" + this.day + "," + this.month + "," + this.year + ">";
	}
}
