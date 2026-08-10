package QueueAndNode_9_2_2024_fixed;

import java.util.Random;

public class ExamGrade {
	private String id;
	private int grade;
	private int weight;
	private static Random rnd = new Random();
	
	public ExamGrade() {
		String str = "";
		for (int i=0; i<1; i++) str += (1+rnd.nextInt(9));
		this.id = str;
		this.grade = rnd.nextInt(101);
		this.weight = rnd.nextInt(101);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "ExamGrade [id=" + id + ", grade=" + grade + ", weight=" + weight + "]";
	}
	
}
