package polygonAndPoint;

public class Polygon {
	private Node<Point> points;
	
	public Polygon() {   //O(1)
		this.points = null;
	}
	public Polygon(Point p) {   //O(1)
		this.points = new Node<Point>(p);
	}
	public Polygon(Polygon p) {   //O(n)
		Node<Point> q = p.getPoints();
		this.points = new Node<Point>(q.getValue());
		Node<Point> r = this.points;
		q = q.getNext();
		while (q != null) {
			r.setNext(new Node<Point>(q.getValue()));
			r = r.getNext();
			q = q.getNext();
		}
	}
	
	public Node<Point> getPoints() {   //O(1)
		return this.points;
	}
	public void setPoints(Node<Point> p) {   //O(1)
		this.points = p;
	}
	public Node<Point> getLast(){   //O(n)
		Node<Point> q = this.points;
		while (q.hasNext()) {
			q = q.getNext();
		}
		return q;
	}
	
	public boolean pointExists(Point p) {   //O(n)
		Node<Point> q = this.points;
		while (q != null) {
			if (q.getValue().equals(p)) {
				return true;
			}
			q = q.getNext();
		}
		return false;
	}
	public void addPontL(Point p) {   //O(2n) = O(n)
		if (!pointExists(p)) {
			this.getLast().setNext(new Node<Point>(p));
		}
	}
	public void addPontF(Point p) {   //O(n)
		if (!pointExists(p)) {
			this.points = new Node<Point>(p, this.points);
		}
	}
	public void delPoint(Point p) {   //O(n)
		if (points.getValue().equals(p)) { 
			points = points.getNext();
			return;
		}
		Node<Point> q = this.points;
		while (q.hasNext()) {
			if (q.getNext().getValue().equals(p)) {
				q.setNext(q.getNext().getNext());
				return;
			}
			q = q.getNext();
		}
	}
	public int pointNum() {   //O(n)
		Node<Point> q = this.points;
		int count = 0;
		while (q != null) {
			count++;
			q = q.getNext();
		}
		return count;
	}
	public int edgesNum() {   //O(n)
		int count = this.pointNum();
		if (count == 2) return 1;
		if (count == 1) return 0;
		return count;
	}
	public Point getPoint(int pos) {   //O(2n) = O(n)
		int pointNum = this.pointNum();
		while(pos > pointNum) {
			pos = pos-pointNum;
		}
		Node<Point> q = this.points;
		while (pos > 1) {
			q = q.getNext();
			pos--;
		}
		return q.getValue();
	}
	public double edgesLength() {   //O(2n) = O(n)
		Node<Point> q = this.points;
		int edges = this.edgesNum();
		if (edges == 0) return 0;
		if (edges == 1) return q.getValue().distance(q.getNext().getValue());
		double sum = 0;
		while (q.hasNext()) {
			sum += q.getValue().distance(q.getNext().getValue());
			q = q.getNext();
		}
		sum += q.getValue().distance(this.points.getValue());
		return sum;
	}
	public Point near00() {   //O(n)
		Node<Point> q = this.points;
		double distance = q.getValue().distance00();
		Point min = q.getValue();
		while (q != null) {
			if (q.getValue().distance00() < distance) {
				distance = q.getValue().distance00();
				min = q.getValue();
			}
			q = q.getNext();
		}
		return min;
	}
	public Polygon copyAndShiftPolygon(int dx, int dy) {   //O(n)
		Node<Point> q = this.points;
		Point p = new Point(q.getValue());
		p.shiptPoint(dx, dy);
		Polygon newPolygon = new Polygon(p);
		while (q.hasNext()) {
			q = q.getNext();
			p = new Point(q.getValue());
			p.shiptPoint(dx, dy);
			newPolygon.addPontL(p);
		}
		return newPolygon;
	}
	public boolean equals(Polygon p) {   //O(n+m) = O(n)
		Node<Point> q = this.points;
		Node<Point> r = p.getPoints();
		while(q != null && !q.getValue().equals(r.getValue())) {
			q = q.getNext();
		}
		if (q == null) return false;
		q = q.getNext();
		r = r.getNext();
		while(r != null) {
			if (q == null) q = this.points;
			if (!q.getValue().equals(r.getValue())) return false;
			q = q.getNext();
			r = r.getNext();
		}
		if (q == null) q = this.points;
		if (!q.getValue().equals(p.getPoints().getValue())) return false;
		return true;
	}
	
	public String toString() {   //O(1)
		return "Polygon [" + points + "]";
	}
}
