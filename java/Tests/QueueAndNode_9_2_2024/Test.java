package QueueAndNode_9_2_2024;

public class Test {
	private Node<ExamGrade> grades;
	
	public Test() {
		this.grades = null;
	}
	
	public Node<ExamGrade> getGrades() {
		return grades;
	}
	public void setGrades(Node<ExamGrade> grades) {
		this.grades = grades;
	}
	
	public void addGrade(ExamGrade g) {
		Node<ExamGrade> p = this.grades;
		boolean fixed = false;
		while (!fixed && p.hasNext()) {
			if (g.getId().equals(p.getValue().getId())) {
				if (g.getGrade() > p.getValue().getGrade()) {
					p.getValue().setGrade(g.getGrade());
				}
				else if (g.getGrade() < p.getValue().getGrade()) {
					g.setWeight(g.getWeight()/2);
					p.getValue().setWeight(p.getValue().getWeight()/2);
					p.setNext(new Node<ExamGrade>(g, p.getNext()));
				}
				fixed = true;
			}
			p = p.getNext();
		}
		if (!fixed) {
			if (g.getId().equals(p.getValue().getId())) {
				if (g.getGrade() > p.getValue().getGrade()) {
					p.getValue().setGrade(g.getGrade());
				}
				else if (g.getGrade() < p.getValue().getGrade()) {
					g.setWeight(g.getWeight()/2);
					p.getValue().setWeight(p.getValue().getWeight()/2);
					p.setNext(new Node<ExamGrade>(g));
				}
			}
			else p.setNext(new Node<ExamGrade>(g));
		}
	}

	@Override
	public String toString() {
		return "Test [grades=" + grades + "]";
	}
	
	
}
