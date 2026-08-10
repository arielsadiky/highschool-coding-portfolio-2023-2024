
public class MainStudentListSorted {
	
	public static void main(String[] args) {
		Parent p1 = new Parent("Cohen Alon", "054-3782793");
		Parent p2 = new Parent("Lev Oren", "058-3726093");
		Parent p3 = new Parent("Arzi Sharon", "050-3002173");
		
		Student st1 = new Student("Cohen Roy", "054-9745285", p1);
		Student st2 = new Student("Cohen Ben", "054-9000285", p1);
		Student st3 = new Student("Lev Rinat", "054-3725285", p2);
		Student st4 = new Student("Arzi Shiri", "054-9794203", p3);
		
		StudentListSorted a = new StudentListSorted();
		a.add(st1);
		a.add(st2);
		a.add(st3);
		a.add(st4);
		System.out.println(a.getCount());
		System.out.println(a);
		StudentListSorted b = new StudentListSorted(a);
		System.out.println(b);
		/*System.out.println(a.getStudent(st2.getName()));
		System.out.println();
		System.out.println(a.del(st1.getName()));
		System.out.println();
		System.out.println(a);*/
		
		
	}
}
