package QueueNodeOOP_1_3_2024_fixed;

import java.util.Random;

public class Product {
	private static Random rnd = new Random();
	private String name;
	private double price;
	private int amount;
	
	public Product() {
		String str = "";
		for (int i=0; i<5; i++) str += (char)((int)('a')+rnd.nextInt((int)('z')-(int)('a')+1));
		this.name = str;
		this.price = ((double)(rnd.nextInt(5000))/100.0);
		this.amount = 1 + rnd.nextInt(5);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
}
