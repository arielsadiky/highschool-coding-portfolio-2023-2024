
public class StudentList {
	public Student[] studList;
	public int count;
	public static final int MAX_STUDENT = 35;
	
	public StudentList() {
		this.studList = new Student[MAX_STUDENT];
		this.count = 0;
	}
	
	public void add(Student st) {
		if (count < studList.length) {
			studList[count] = st;
			this.count++;
		}
	}
	public Student getStudent(String name) {
		for (int i=0; i<this.count; i++) {
			if (studList[i].getName().equals(name)) {
				return studList[i];
			}
		}
		return null;
	}
	public Student del(String name) {
		for (int i=0; i<this.count; i++) {
			if (studList[i].getName().equals(name)) {
				Student temp = studList[i];
				studList[i] = studList[count-1];
				count--;
				return temp;
			}
		}
		return null;
	}
	
	public String toString() {
		Student[] temp = new Student[this.count];
		for (int i=0; i<count; i++) {
			temp[i] = studList[i];
		}
		int x;
		Student tmp;
		for (int i=1; i<temp.length; i++) {
			if (temp[i-1].getName().compareTo(temp[i].getName()) > 0){
	            x=i;
	            while (x>0 && (temp[x-1].getName().compareTo(temp[x].getName()) > 0)){
	                tmp = temp[x];
	                temp[x] = temp[x-1];
	                temp[x-1] = tmp;
	                x--;
	            }
	        }
		}
		for (Student y : temp) {
			System.out.println(y.getName()+", "+y.getPhonNum());
		}
		return "";
	}
	
}
