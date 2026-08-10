package polynomAndPolynomMember;

public class Main {

	public static void main(String[] args) {
		PolynomMember a = new PolynomMember(2, 4);
		PolynomMember b = new PolynomMember(-5, 2);
		PolynomMember c = new PolynomMember(7, 1);
		PolynomMember d = new PolynomMember(7, 0);
		PolynomMember e = new PolynomMember(0, 3);
		PolynomMember f = new PolynomMember(a);
		PolynomMember g = new PolynomMember(4, 3);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println();
		
		Polynom p = new Polynom();
		System.out.println(p);
		p.addPolynomMember(a);
		System.out.println(p);
		p.addPolynomMember(b);
		System.out.println(p);
		p.addPolynomMember(c);
		System.out.println(p);
		p.addPolynomMember(d);
		System.out.println(p);
		p.addPolynomMember(e);
		System.out.println(p);
		p.addPolynomMember(f);
		System.out.println(p);
		p.addPolynomMember(b);
		System.out.println(p);
		p.addPolynomMember(c);
		System.out.println(p);
		p.addPolynomMember(d);
		System.out.println(p);
		p.addPolynomMember(e);
		System.out.println(p);
		p.addPolynomMember(g);
		System.out.println(p);
		System.out.println();
		
		System.out.println(p.value(0));
		System.out.println(p.value(1));
		System.out.println(p.value(2));
		System.out.println(p.value(3));
		System.out.println();
		
		Polynom q = new Polynom();
		q.addPolynomMember(a);
		q.addPolynomMember(b);
		q.addPolynomMember(c);
		System.out.println(q);
		System.out.println();
		
		Polynom r = p.addPolynoms(q);
		System.out.println(r);
		System.out.println();
		
		Polynom w = new Polynom();
		w.addPolynomMember(b);
		w.addPolynomMember(c);
		System.out.println(w);
		
		Polynom[] arr1 = polynomArry(r);
		printPolynomArr(arr1);
		
		Polynom z = PolynomWithTheHighestPower(arr1);
		System.out.println(z);
		System.out.println();
		
		Polynom[] arr2 = {w, p, q, r};
		printPolynomArr(arr2);
		z = PolynomWithTheHighestPower(arr2);
		System.out.println(z);
		System.out.println();
		
		Node<Polynom> PolynomList = new Node<Polynom>(p, new Node<Polynom>(q, new Node<Polynom>(r)));
		System.out.println(PolynomList);
		System.out.println();
		Polynom sum = sumPolynomList(PolynomList);
		System.out.println(sum);
		
		
	}
	
	public static Polynom[] polynomArry(Polynom p) {   //O(n)
		int length = 0;
		Node<PolynomMember> q = p.getList();
		while (q != null) {
			length++;
			q = q.getNext();
		}
		q = p.getList();
		Polynom[] arr = new Polynom[length];
		for (int i=0; i<length; i++) {
			arr[i] = new Polynom(q, i);
		}
		return arr;
	}
	public static void printPolynomArr(Polynom[] p) {   //O(n)
		for (int i=0; i<p.length; i++) {
			System.out.println(p[i]);
		}
		System.out.println();
	}
	
	public static Polynom PolynomWithTheHighestPower(Polynom[] p) {   //O(n)
		int max = p[0].getList().getValue().getPower();
		Polynom HighestPower = p[0];
		for (int i=0; i<p.length; i++) {
			if (p[i].getList().getValue().getPower() > max) {
				max = p[i].getList().getValue().getPower();
				HighestPower = p[i];
			}
		}
		return HighestPower;
	}
	
	public static Polynom sumPolynomList(Node<Polynom> p) {   //O(n*m^2)
		Polynom sum = p.getValue();
		p = p.getNext();
		while (p != null) {
			sum = sum.addPolynoms(p.getValue());
			p = p.getNext();
		}
		return sum;
	}
	
	

}
