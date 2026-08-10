package train;

public class Locomotive {
	private int serialNum;
	private int productionYear;
	
	public Locomotive(int serialNum, int productionYear) {
		this.serialNum = serialNum;;
		this.productionYear = productionYear;
	}

	public int getSerialNum() {
		return this.serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public int getProductionYear() {
		return this.productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}


	public String toString() {
		return "{serialNum=" + serialNum + ", productionYear=" + productionYear + "}";
	}
	
}
