
public class StudentListSorted {
	public Student[] studList;
	public int count;
	public static final int MAX_STUDENT = 35;
	
	public StudentListSorted() {
		this.studList = new Student[MAX_STUDENT];
		this.count = 0;
	}
	public StudentListSorted(StudentListSorted stList) {
		this.studList = new Student[MAX_STUDENT];
		for (int i=0; i<stList.count; i++) {
			this.studList[i] = new Student(stList.studList[i]);
		}
		this.count = 0;
	}
	
	public int getCount() {
		return this.count;
	}
	public void add(Student st) {
		if (count < studList.length) {
			int spot = binarySearchPlace(studList, st.getName(), count);
			if (spot != -1) {
				count++;
				shiftToTheRight(studList ,spot, count);
				studList[spot] = st;
			}
		}
	}	
	public Student getStudent(String name) {
		int i = binarySearchIndex(studList, name, count-1);
		if (i == -1) {
			return null;
		}
		else {
			return studList[i];
		}
	}
	public Student del(String name) {
		int i = binarySearchIndex(studList, name, count-1);
		if (i == -1) {
			return null;
		}
		Student st = studList[i];
		count--;
		shiftToTheLeft(studList, i, count);
		return st;
	}
	
	public static int binarySearchIndex(Student[] sorted, String name, int length) {       /// מחזיר את המיקום של הסטודנט עם השם במערך
        int x=0;
        for (int i=0, j=length-1, y=((length-1)/2); x==0;){
            if (sorted[y].getName().compareTo(name) == 0){
                return y;   
            }
            else if (sorted[y].getName().compareTo(name) > 0){
                j=(y-1); 
                y=((i+j)/2);
            }
            else if (sorted[y].getName().compareTo(name) < 0){
                i=(y+1); 
                y=((i+j)/2);
            }
            if (i==y){
                if (sorted[j].getName().compareTo(name) == 0){
                    return j;
                }
                else if (sorted[i].getName().compareTo(name) == 0){
                    return i;
                }
                else {
                	x++;
                }
            }
        }
		 return -1; 
	 }
	public static int binarySearchPlace(Student[] sorted, String name, int length) {      /// מחזיר את המיקום בו הסטודנט עם השם צריך להיכנס
		int x = 0;
		if (sorted[0] == null){
    		return 0;
    	}
		for (int i=0, j=length-1, y=((length-1)/2); x==0;){
			if (sorted[y].getName().compareTo(name) > 0){
                j=(y); 
                y=((i+j)/2);
            }
            else if (sorted[y].getName().compareTo(name) < 0){
                i=(y); 
                y=((i+j)/2);
            }
			if ((i == y)){
                if (sorted[i].getName().compareTo(name) > 0) {
                	return i;
                }
                else if (sorted[j].getName().compareTo(name) < 0){
                	return j+1;
                }
                else {
                	x++;
                }
            }
			else if (i == (j-1)){
                if ((sorted[i].getName().compareTo(name) < 0) && (sorted[j].getName().compareTo(name) > 0)) {
                	return j;
                }
                else if (sorted[j].getName().compareTo(name) < 0){
                	return j+1;
                }
                else {
                	x++;
                }
            }
        }
		return -1;
	 }
	
	public void shiftToTheRight(Student[] arr, int start, int finish) {
		Student temp1 = arr[start], temp2 = null;
		for (int i=start+1; i<finish; i++) {
			temp2 = arr[i];
			arr[i] = temp1;
			temp1 = temp2;
		}
	}
	public void shiftToTheLeft(Student[] arr ,int start, int finish) {
		Student temp1 = arr[finish], temp2 = null;
		for (int i=(finish-1); i<finish; i++) {
			temp2 = arr[i];
			arr[i] = temp1;
			temp1 = temp2;
		}
	}

	public String toString() {
		for (int i=0; i<count; i++) {
			System.out.println(studList[i].getName()+", "+studList[i].getPhonNum());
		}
		return "";
	}
	
}
