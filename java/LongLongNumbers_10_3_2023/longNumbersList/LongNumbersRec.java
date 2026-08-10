package longNumbersList;

public class LongNumbersRec {
	private Node<Integer> num1;
	private Node<Integer> num2;
	
	public LongNumbersRec(String num1, String num2) {
		this.num1 = stringToList(num1, num1.length()-1, null);
		this.num2 = stringToList(num2, num2.length()-1, null);
	}
	public Node<Integer> stringToList(String n, int i, Node<Integer> num) {
		if (i < 0) return num;
		num = new Node<Integer>((int)(n.charAt(i))-48, num);
		return stringToList(n, i-1, num);
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
		Node<Integer> b = longerNum(this.num1, this.num2);
		if (b == null) return biggerNum(this.num1, this.num2);
		return b;
	}
	public Node<Integer> longerNum(Node<Integer> p1, Node<Integer> p2) {
		if (p1 == null  &&  p2 == null) return null;
		if (p1 == null  &&  p2 != null) return this.num2;
		if (p1 != null  &&  p2 == null) return this.num1;
		return longerNum(p1.getNext(), p2.getNext());
	}
	public Node<Integer> biggerNum(Node<Integer> p1, Node<Integer> p2) {
		if (p1 == null  ||  p2 == null) return this.num1;
		if (p1.getValue()>p2.getValue()) return this.num1;
		if (p1.getValue()<p2.getValue()) return this.num2;
		return biggerNum(p1.getNext(), p2.getNext());
	}
	
	public Node<Integer> sumOfNums() {
		Node<Integer> p1 = this.buildReverseList(this.num1, null);
		Node<Integer> p2 = this.buildReverseList(this.num2, null);
		return addNums(p1.getNext(), p2.getNext(), new Node<Integer>((p1.getValue() + p2.getValue())%10), ((p1.getValue() + p2.getValue())/10));
	}
	public Node<Integer> buildReverseList(Node<Integer> lst, Node<Integer> p){
        if (lst == null) return p;
		return buildReverseList(lst.getNext(), new Node<Integer>(lst.getValue(), p));
    }   
	public Node<Integer> addNums(Node<Integer> p1, Node<Integer> p2, Node<Integer> sum, int rest) {
		if (p1 == null  &&  p2 == null) { 
			if (rest != 0) return new Node<Integer>(rest, sum);
			return sum;
		}
		if (p2 == null) return addNums(p1, sum, rest);
		if (p1 == null) return addNums(p2, sum, rest);
		return addNums(p1.getNext(), p2.getNext(), new Node<Integer>((p1.getValue() + p2.getValue() + rest)%10, sum), ((p1.getValue() + p2.getValue() + rest)/10));
	}
	public Node<Integer> addNums(Node<Integer> p, Node<Integer> sum, int rest) {
		if (p == null) { 
			if (rest != 0) return new Node<Integer>(rest, sum);
			return sum;
		}
		return addNums(p.getNext(), new Node<Integer>((p.getValue() + rest)%10, sum), ((p.getValue() + rest)/10));
	}
	
	public String toString() {
		return "num1=" + this.num1 + "\nnum2=" + this.num2 + "\n";
	}
}

