
public class Parent {
	public String name;
	public String cellNum;
	
	public Parent(String name, String cellNum) {
		this.name= name;
		this.cellNum= cellNum;
	}
	public String getName() {
		return name;
	}
	public String getCellNum() {
		return cellNum;
	}
	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}
	
	public String toString() {
		return this.name+", "+this.cellNum;
	}
}
