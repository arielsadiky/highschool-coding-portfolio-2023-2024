package dateDietWeight;

public class Weight {
	private Date date;
	private int weight;
	
	public Weight(Date date, int weight) {
		this.date = date;
		this.weight = weight;
	}
	
	public Date getDate() {
		return this.date;
	}
	public int getWeight() {
		return this.weight;
	}

	public String toString() {
		return "(" + date + ": " + weight + "kg)";
	}
}
