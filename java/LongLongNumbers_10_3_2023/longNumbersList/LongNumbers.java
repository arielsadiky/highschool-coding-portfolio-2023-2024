package longNumbersList;

public class LongNumbers {
	private Node<Integer> num1;
	private Node<Integer> num2;
	
	public LongNumbers(String num1, String num2) {
		this.num1 = null;
		for (int i=num1.length()-1; i>=0; i--) {
			this.num1 = new Node<Integer>((int)(num1.charAt(i))-48, this.num1);
		}
		this.num2 = null;
		for (int i=num2.length()-1; i>=0; i--) {
			this.num2 = new Node<Integer>((int)(num2.charAt(i))-48, this.num2);
		}
	}
	
	public Node<Integer> getNum1() {
		return this.num1;
	}
	public void setNum1(Node<Integer> num1) {
		this.num1 = num1;
	}
	public Node<Integer> getNum2() {
		return this.num2;
	}
	public void setNum2(Node<Integer> num2) {
		this.num2 = num2;
	}

	public Node<Integer> getBigerNum() {
		Node<Integer> p1 = this.num1;
		Node<Integer> p2 = this.num2;
		while (p1 != null  &&  p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		if (p1 == null  &&  p2 == null) {
			p1 = this.num1;
			p2 = this.num2;
			while (p1 != null  &&  p2 != null) {
				if (p1.getValue()>p2.getValue()) return this.num1;
				if (p1.getValue()<p2.getValue()) return this.num2;
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
		}
		if (p1 == null) return this.num2;
		return this.num1;
	}
	public Node<Integer> sumOfNums() {
		Node<Integer> p1 = this.buildReverseList(this.num1);
		Node<Integer> p2 = this.buildReverseList(this.num2);
		Node<Integer> sum = new Node<Integer>((p1.getValue() + p2.getValue())%10);
		int rest = ((p1.getValue() + p2.getValue())/10);
		p1 = p1.getNext();
		p2 = p2.getNext();
		while (p1 != null  &&   p2 != null) {
			sum = new Node<Integer>((p1.getValue() + p2.getValue() + rest)%10, sum);
			rest = ((p1.getValue() + p2.getValue() + rest)/10);
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		while (p1 != null) {
			sum = new Node<Integer>((p1.getValue() + rest)%10, sum);
			rest = ((p1.getValue() + rest)/10);
			p1 = p1.getNext();
		}
		while (p2 != null) {
			sum = new Node<Integer>((p2.getValue() + rest)%10, sum);
			rest = ((p2.getValue() + rest)/10);
			p2 = p2.getNext();
		}
		if (rest != 0) sum = new Node<Integer>(rest, sum);
		return sum;
	}
	public Node<Integer> buildReverseList(Node<Integer> lst){
        Node<Integer> p = null;
        while (lst != null){
            p = new Node<Integer>(lst.getValue(), p);
            lst = lst.getNext();
        }
        return p;
    }   
	
	public String toString() {
		return "num1=" + this.num1 + "\nnum2=" + this.num2 + "\n";
	}
}
