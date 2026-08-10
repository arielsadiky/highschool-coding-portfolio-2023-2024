import java.util.Random;

public class Student {

	static Random rnd = new Random();
	public static int count = 999;
	public int id;
	public String name;
	public String[] subjects;
	static String[] AvailableSubjects = {"Mathematics", "Science", "Art", "Music", "Spanish","English", "Geometry", "Geography", "History", "French", "Computer Science","Business","Drama", "Photography", "Chemistry", "Biology", "Zoology", "MarineBiology","Botany", "Earth Science","Geology"};
	public int[] subjectsGrads;
	
	public Student() {
		count++;
		this.id = count;
		this.name = "" + (char)('A' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26)) + (char)('a' + rnd.nextInt(26));
		
		int numOfSubjects = rnd.nextInt(8)+3;
		//System.out.println("num subj: "+numOfSubjects);
		int num = 0;
		boolean is = true;
		this.subjects = new String[numOfSubjects];
		for (int i=0; i<subjects.length; i++) {
			while (is) {
				is = false;
				num = rnd.nextInt(AvailableSubjects.length);
				for (int j=0; j<subjects.length; j++) {
					if (AvailableSubjects[num] == subjects[j]) {
						is = true;
					}
				}
			}
			subjects[i] = AvailableSubjects[num];
			is = true;
		}
		
		subjectsGrads = new int[numOfSubjects];
		for (int i=0; i<subjectsGrads.length; i++) {
			subjectsGrads[i] = rnd.nextInt(45)+56;
		}
		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public String[] getSubjects() {
		return this.subjects;
	}
	public int getSubjectsLength() {
		return this.subjects.length;
	}
	public String getSubjectsAt(int i) {
		return this.subjects[i];
	}
	public int[] getSubjectsGrads() {
		return this.subjectsGrads;
	}
	public int getSubjectsGradsLength() {
		return this.subjectsGrads.length;
	}
	public int getSubjectsGradsAt(int i) {
		return this.subjectsGrads[i];
	}
	public String[] getAvailableSubjects() {
		return AvailableSubjects;
	}
	
	
	public void addGrade(int grade, String sbjct) {
		int x=-1;
		for (int i=0; i<subjects.length; i++) {
			if (subjects[i] == sbjct) {
				x=i;
			}
		}
		if (x == -1) {
			if (subjects.length < 10) {
				addNewSubjectAndGrade(grade, sbjct);
			}
			else {
				x = findMinGrade();
				subjectsGrads[x] = grade;
				subjects[x] = sbjct;
				
			}
		}
		else {
			subjectsGrads[x] = grade;
		}
	}
	public double getAverageOfGrads() {
		double sum = 0;
		for (int i=0; i<subjectsGrads.length; i++) {
			sum+=subjectsGrads[i];
		}
		return (sum/this.subjectsGrads.length);
	}
	public double getTwoHighestGradsAverage() {
		double big1 = 0, big2 = 0;
		for (int i=0; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i] >= big1) {
				big2 = big1;
				big1 = subjectsGrads[i];
			}
			if ((subjectsGrads[i] < big1) && (subjectsGrads[i] > big2)) {
				big2 = subjectsGrads[i];
			}
		}
		return ((big1+big2)/2);
	}
	public int[] getThreeBestGrads() {
		int[] threeBest = new int[3];
		for (int i=0; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i] > threeBest[0]) {
				threeBest[2] = threeBest[1];
				threeBest[1] = threeBest[0];
				threeBest[0] = subjectsGrads[i];
			}
			else if (subjectsGrads[i] > threeBest[1]) {
				threeBest[2] = threeBest[1];
				threeBest[1] = subjectsGrads[i];
			}
			else if (subjectsGrads[i] > threeBest[2]){
				threeBest[2] = subjectsGrads[i];
			}
		}
		return threeBest;
	}
	public double getMedian() {
		sort();
		for (int i=0; i<subjectsGrads.length; i++){
        	System.out.print(subjectsGrads[i]+", ");
        } 
		System.out.println();
		if ((subjectsGrads.length%2) == 1) {
			return (subjectsGrads[(subjectsGrads.length)/2]);
		}
		else {
			double i = (subjectsGrads[(subjectsGrads.length/2)]), j = (subjectsGrads[((subjectsGrads.length)/2)-1]);
			return ((i+j)/2);
		}
	}
	public void isAboutToFail() {
		if (isDownSorted()) {
			System.out.println("student is about to fail");
		}
		else {
			System.out.println("student is doing fine");
		}
	}
	
	
	public void addNewSubjectAndGrade(int grade, String sbjct) {
		String[] temp1 = new String[subjects.length+1];
		for (int i=0; i<subjects.length; i++) {
			temp1[i] = subjects[i];
		}
		temp1[subjects.length] = sbjct;
		this.subjects = temp1;
		
		int[] temp2 = new int[subjectsGrads.length+1];
		for (int i=0; i<subjectsGrads.length; i++) {
			temp2[i] = subjectsGrads[i];
		}
		temp2[subjectsGrads.length] = grade;
		this.subjectsGrads = temp2;
	}
	public int findMinGrade() {
		int min=subjectsGrads[0], x=0;
		for (int i=0; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i] < min) {
				min = subjectsGrads[i];
				x=i;
			}
		}
		return x;
	}
	public int findMaxGrade() {
		int max=subjectsGrads[0], x=0;
		for (int i=0; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i] > max) {
				max = subjectsGrads[i];
				x=i;
			}
		}
		return x;
	}
	public int hasSubject(String sbjct) {
		int x=-1;
		for (int i=0; i<subjects.length; i++) {
			if (subjects[i].equals(sbjct)) {
				x=i;
			}
		}
		return x;
	}
	public void sort() {
		int x, tmp;
		String temp;
		for (int i=1; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i-1] > subjectsGrads[i]){
	            x=i;
	            while (x>0 && (subjectsGrads[x-1] > subjectsGrads[x])){
	                tmp = subjectsGrads[x];
	                subjectsGrads[x] = subjectsGrads[x-1];
	                subjectsGrads[x-1] = tmp;
	                temp = subjects[x];
	                subjects[x] = subjects[x-1];
	                subjects[x-1] = temp;
	                x--;
	            }
	        }
		}
	}
	public boolean isDownSorted() {
		for (int i=1; i<subjectsGrads.length; i++) {
			if (subjectsGrads[i-1] < subjectsGrads[i]){
	           return false;
	        }
		}
		return true;
	}
	
	
	public String toString() {
		System.out.println("id: "+this.id);
		System.out.println("name: "+this.name);
		System.out.println("amount of sub: "+subjects.length);
		for (int i=0; i<subjects.length; i++) {
			System.out.print(subjects[i]+", ");
		}
		System.out.println();
		for (int i=0; i<subjectsGrads.length; i++) {
			System.out.print(subjectsGrads[i]+", ");
		}
		System.out.println();
		return "";
	}
	
}