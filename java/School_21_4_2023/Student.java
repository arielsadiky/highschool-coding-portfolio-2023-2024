
public class Student {
	private static int counter = 0;
	private int id;
	private String name;
	private String phonNum;
	private Parent parent;
	
 	public Student(String name, String phonNum, Parent parent) {
		this.name= name;
		this.phonNum= phonNum;
		this.parent= parent;
		counter++;
		this.id = counter;
		
	}
 	public Student(Student st) {
		this.name= st.getName();
		this.phonNum= st.getName();
		this.parent= st.getParent();
		counter++;
		this.id = counter;
		
	}
	
 	public int getId() {
 		return this.id;
 	}
 	public String getName() {
		return this.name;
	}
 	public String getPhonNum() {
		return this.phonNum;
	} 	
	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}
	public Parent getParent() {
		return this.parent;
	}
	public static int getCounter() {
		return counter;
	}
	
	public String toString() {
		return this.id+", "+this.name+", "+this.phonNum+", Parent: "+this.parent;
	}
}
