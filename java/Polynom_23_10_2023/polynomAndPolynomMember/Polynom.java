package polynomAndPolynomMember;

public class Polynom {
	private Node<PolynomMember> list;
	
	public Polynom() {   //O(1)
		this.list = null;
	}
	public Polynom(Node<PolynomMember> p) {   //O(n)
		this.list = new Node<PolynomMember>(p.getValue());
		Node<PolynomMember> q = this.list;
		p = p.getNext();
		while (p != null) {
			q.setNext(new Node<PolynomMember>(p.getValue()));
			q = q.getNext();
			p = p.getNext();
		}
	}
	public Polynom(Node<PolynomMember> p, int x) {   //O(n) או O(x)
		this.list = new Node<PolynomMember>(p.getValue());
		Node<PolynomMember> q = this.list;
		p = p.getNext();
		while (p != null  &&  x>0) {
			q.setNext(new Node<PolynomMember>(p.getValue()));
			q = q.getNext();
			p = p.getNext();
			x--;
		}
	}
	public Polynom(Polynom p) {   //O(n)
		this.list = new Node<PolynomMember>(p.getList().getValue());
		Node<PolynomMember> q = this.list;
		Node<PolynomMember> r = p.getList().getNext();
		while (r != null) {
			q.setNext(new Node<PolynomMember>(r.getValue()));
			q = q.getNext();
			r = r.getNext();
		}
	}
	public Node<PolynomMember> getList(){   //O(1)
		return this.list;
	}
	
	public void addPolynomMember(PolynomMember p){   //O(n)
		if (p == null) return;
		Node<PolynomMember> q = this.list;
		if (q == null  ||  p.getPower() > q.getValue().getPower()) {
			this.list = new Node<PolynomMember>(new PolynomMember(p), this.list);
			return;
		}
		if (p.getPower() == q.getValue().getPower()) {
			q.setValue(new PolynomMember(q.getValue().getCoefficient() + p.getCoefficient(), p.getPower()));
			return;
		}
		while (q.hasNext()) {
			if (p.getPower() == q.getNext().getValue().getPower()) {
				q.getNext().setValue(new PolynomMember(q.getNext().getValue().getCoefficient() + p.getCoefficient(), p.getPower()));
				return;
			}
			if (p.getPower() < q.getValue().getPower()  &&  p.getPower() > q.getNext().getValue().getPower()) {
				q.setNext(new Node<PolynomMember>(p, q.getNext()));
				return;
			}
			q = q.getNext();
		}
		q.setNext(new Node<PolynomMember>(new PolynomMember(p), q.getNext()));
	}
	public int value(int x) {   //O(1)
		return valueRec(this.list, x);
	} 
	public int valueRec(Node<PolynomMember> pos, int x) {   //O(1)
		if (pos == null) return 0;
		return pos.getValue().value(x) + valueRec(pos.getNext(), x);
	} 
	public Polynom addPolynoms(Polynom p){   //O(n^2)
		Polynom newPolynom = new Polynom();
		Node<PolynomMember> q = this.list;
		Node<PolynomMember> r = p.getList();
		while (q != null  &&  r != null) {
			newPolynom.addPolynomMember(new PolynomMember(q.getValue()));
			newPolynom.addPolynomMember(new PolynomMember(r.getValue()));
			q = q.getNext();
			r = r.getNext();
		}
		while (q != null) {
			newPolynom.addPolynomMember(new PolynomMember(q.getValue()));
			q = q.getNext();
		}
		while (r != null) {
			newPolynom.addPolynomMember(new PolynomMember(r.getValue()));
			r = r.getNext();
		}
		return newPolynom;
	}
	
	public String toString() {
		if (this.list == null) return "null";
		if (!this.list.hasNext()) return "[" + this.list.getValue().getCoefficient() + "x^" + this.list.getValue().getPower() + "]";
		return "[" + this.list.getValue().getCoefficient() + "x^" + this.list.getValue().getPower() + "" +this.list.getNext() + "]";
	}
}
