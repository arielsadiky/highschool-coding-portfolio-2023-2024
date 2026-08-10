
public class StudentMain {

	public static void main(String[] args) {
		Student a = new Student();
		System.out.println(a);
		
		a.addGrade(78, "Science");
		print(a.getSubjects());
		print(a.getSubjectsGrads());
		System.out.println();
		
		System.out.println("Average: "+a.getAverageOfGrads());
		System.out.println("TwoHighestGradsAverage: "+a.getTwoHighestGradsAverage());
		System.out.print("three best grades: ");
		print(a.getThreeBestGrads());
		System.out.println("a.getMedian(): "+a.getMedian());
		a.isAboutToFail();
		System.out.println();
		
		Student b = new Student();
		Student c = new Student();
		Student d = new Student();
		Student e = new Student();
		Student[] list = {a, b, c, d, e};
		print(list);
		System.out.println("BestStudent: "+BestStudent(list));
		System.out.println("maxGradeInSubject: "+maxGradeInSubject(list, "Science"));
		System.out.println("minGradeInSubject: "+minGradeInSubject(list, "Science"));
		System.out.println("subjectWithBigestGradeDifference: "+subjectWithBigestGradeDifference(list, "Science"));
		System.out.print("schoolGrades: ");
		print(schoolGrades(list));
		System.out.println();
		
		print(studentsInSubject(list, "Science"));
		System.out.println();
		System.out.print(bestStudentInSub(list, "Science"));
		
	}
	public static void print(int[] grads){
        for (int i=0; i<grads.length; i++){
        	System.out.print(grads[i]+", ");
        } 
        System.out.println();
	}
	public static void print(String[] sbj){
        for (int i=0; i<sbj.length; i++){
        	System.out.print(sbj[i]+", ");
        } 
        System.out.println();
	}
	public static void print(Student[] list){
        for (int i=0; i<list.length; i++){
        	System.out.println(list[i]+" ");
        } 
	}
	
	public static String BestStudent(Student[] list){
		double max = list[0].getAverageOfGrads();
		int x = 0;
		for (int i=0; i<list.length; i++){
        	if (list[i].getAverageOfGrads() > max) {
        		max = list[i].getAverageOfGrads();
        		x=i;
        	}
        } 
        return list[x].getName();
	}
	public static int maxGradeInSubject(Student[] list, String sbjct){
		int max = -1, x = -1;
		for (int i=0; i<list.length; i++) {
			x = list[i].hasSubject(sbjct);
			if ((x != -1) && (list[i].getSubjectsGradsAt(x)>max)) {
				max = list[i].getSubjectsGradsAt(x);
			}
			x = -1;
		}
        return max;
	}
	public static int minGradeInSubject(Student[] list, String sbjct){
		int min = 101, x = -1;
		for (int i=0; i<list.length; i++) {
			x = list[i].hasSubject(sbjct);
			if ((x != -1) && (list[i].getSubjectsGradsAt(x)<min)) {
				min = list[i].getSubjectsGradsAt(x);
			}
			x = -1;
		}
        return min;
	}
	public static String subjectWithBigestGradeDifference(Student[] list, String sbjct){
		String[] av = list[0].getAvailableSubjects();
		int[] difference = new int[av.length];
		for (int i=0; i<av.length; i++) {
			if ((maxGradeInSubject(list, av[i]) != -1) && (minGradeInSubject(list, av[i]) != 101)) {
				difference[i] = ((maxGradeInSubject(list, av[i]))-(minGradeInSubject(list, av[i])));
			}
		}
		int max = 0, x=-1;
		for (int i=0; i<av.length; i++) {
			if (difference[i]>max) {
				max = difference[i];
				x = i;
			}
		}
        return av[x];
	}
	public static int[] schoolGrades(Student[] list){
		int[] count = new int[6];
		for (int i=0; i<count.length; i++) {
			count[i] = 0;
		}
		for (int i=0; i<list.length; i++) {
			for (int j=0; j<list[i].getSubjectsGradsLength(); j++) {
				if (list[i].getSubjectsGradsAt(j)<=54) {
					count[0]++;
				}
				else if ((list[i].getSubjectsGradsAt(j)>54) && (list[i].getSubjectsGradsAt(j)<=64)) {
					count[1]++;
				}
				else if ((list[i].getSubjectsGradsAt(j)>64) && (list[i].getSubjectsGradsAt(j)<=74)) {
					count[2]++;
				}
				else if ((list[i].getSubjectsGradsAt(j)>74) && (list[i].getSubjectsGradsAt(j)<=84)) {
					count[3]++;
				}
				else if ((list[i].getSubjectsGradsAt(j)>84) && (list[i].getSubjectsGradsAt(j)<=94)) {
					count[4]++;
				}
				else if ((list[i].getSubjectsGradsAt(j)>94) && (list[i].getSubjectsGradsAt(j)<=100)) {
					count[5]++;
				}
				
			}
		}
        return count;
	}
	public static Student[] studentsInSubject(Student[] list, String sbjct){
        int count = 0;
		for (int i=0; i<list.length; i++){
        	for (int j=0; j<list[i].getSubjectsLength(); j++) {
        		if (list[i].getSubjectsAt(j).equals(sbjct)) {
        			count++;
        		}
        	}
        } 
		Student[] StudInSub = new Student[count];
		for (int i=0, x=0; i<list.length; i++){
        	for (int j=0; j<list[i].getSubjectsLength(); j++) {
        		if (list[i].getSubjectsAt(j).equals(sbjct)) {
        			StudInSub[x] = list[i];
        			x++;
        		}
        	}
        } 
		return StudInSub;
	}
	public static Student bestStudentInSub(Student[] list, String sbjct){
		Student[] studInSub = studentsInSubject(list,sbjct);
		int max = -1, x = -1;
		for (int i=0; i<studInSub.length; i++) {
			for (int j=0; j<studInSub[i].getSubjectsLength(); j++) {
        		if ((studInSub[i].getSubjectsAt(j).equals(sbjct)) && (studInSub[i].getSubjectsGradsAt(j) > max)) {
        			max = studInSub[i].getSubjectsGradsAt(j);
        			x=i;
        		}
        	}
		}
		return studInSub[x];
	}
	
	
}
