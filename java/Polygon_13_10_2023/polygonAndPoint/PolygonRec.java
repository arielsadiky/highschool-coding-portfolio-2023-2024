package polygonAndPoint;

public class PolygonRec {
	private Node<Point> points;
	
	public PolygonRec() {
		this.points = null;
	}
	public PolygonRec(Point p) {
		this.points = new Node<Point>(p);
	}
	public PolygonRec(PolygonRec p) {
		Node<Point> q = p.getPoints();
		this.points = new Node<Point>(q.getValue());
		this.PolygonRecHelp(q.getNext(), this.points);
	}
	public void PolygonRecHelp(Node<Point> q, Node<Point> r) {
		if (q == null) return;
		r.setNext(new Node<Point>(q.getValue()));
		this.PolygonRecHelp(q.getNext(), r.getNext());
	}
	
	public Node<Point> getPoints() {
		return this.points;
	}
	public void setPoints(Node<Point> p) {
		this.points = p;
	}
	public Node<Point> getLastRec(){
		return getLastRecHelp(this.points);
	}
	public Node<Point> getLastRecHelp(Node<Point> q){
		if (q == null) return null;
		if (!q.hasNext()) return q;
		return getLastRecHelp(q.getNext());
	}
	
	public boolean pointExistsRec(Point p) {
		return pointExistsRecHelp(this.points, p);
	}
	public boolean pointExistsRecHelp(Node<Point> q, Point p) {
		if (q == null) return false;
		if (q.getValue().equals(p)) return true;
		return pointExistsRecHelp(q.getNext(), p);
	}
	public void addPointLRec(Point p) {
		if (!pointExistsRec(p)) {
			this.getLastRec().setNext(new Node<Point>(p));
		}
	}
	public void addPointFRec(Point p) {
		if (!pointExistsRec(p)) {
			this.points = new Node<Point>(p, this.points);
		}
	}
	public void delPointRec(Point p) {
		if (points.getValue().equals(p)) { 
			points = points.getNext();
			return;
		}
		delPointRecHelp(this.points, p);
	}
	public void delPointRecHelp(Node<Point> q, Point p) {
		if (q == null  ||  !q.hasNext()) return;
		if (q.getNext().getValue().equals(p)) q.setNext(q.getNext().getNext());
		delPointRecHelp(q.getNext(), p);
	}
	public int edgesNumRec() {
		int count = edgesNumRecHelp(this.points);
		if (count == 2) return 1;
		if (count == 1) return 0;
		return count;
	}
	public int edgesNumRecHelp(Node<Point> q) {
		if (q == null) return 0;
		return 1 + edgesNumRecHelp(q.getNext());
	}
	public Point getPointRec(int pos) {
		return getPointRecHelp(pos, this.points);
	}
	public Point getPointRecHelp(int pos, Node<Point> q) {
		if (q == null) q = this.points;
		if (pos == 1) return q.getValue();
		pos--;
		return getPointRecHelp(pos, q.getNext());
	}
	public double edgesLengthRec() {  
		int edges = this.edgesNumRec();
		if (edges == 0) return 0;
		if (edges == 1) return this.points.getValue().distance(this.points.getNext().getValue());
		return edgesLengthRecHelp(this.points);
	}
	public double edgesLengthRecHelp(Node<Point> q) {   
		if (!q.hasNext()) return q.getValue().distance(this.points.getValue());
		return q.getValue().distance(q.getNext().getValue()) + edgesLengthRecHelp(q.getNext());
	}
	public Point near00Rec() {
		return near00RecHelp(this.points, this.points.getValue(), this.points.getValue().distance00());
	}
	public Point near00RecHelp(Node<Point> q, Point min, double distance) {
		if (q == null) return min;
		if (q.getValue().distance00() < distance) return near00RecHelp(q.getNext(), q.getValue(), q.getValue().distance00());
		return near00RecHelp(q.getNext(), min, distance);
	}
	public PolygonRec copyAndShiftPolygonRec(int dx, int dy) {
		Node<Point> q = this.points;
		Point p = new Point(q.getValue());
		p.shiptPoint(dx, dy);
		PolygonRec newPolygon = new PolygonRec(p);
		return copyAndShiftPolygonRecHelp(q, p, newPolygon, dx, dy);
	}
	public PolygonRec copyAndShiftPolygonRecHelp(Node<Point> q, Point p, PolygonRec newPolygon, int dx, int dy) {
		if (!q.hasNext()) return newPolygon;
		q = q.getNext();
		p = new Point(q.getValue());
		p.shiptPoint(dx, dy);
		newPolygon.addPointLRec(p);
		return copyAndShiftPolygonRecHelp(q, p, newPolygon, dx, dy);
	}
	public boolean equalsRec(PolygonRec p) {
		Node<Point> q = this.points;
		Node<Point> r = p.getPoints();
		return this.equalsRec(q, r, p);
	}
	public boolean equalsRec(Node<Point> q, Node<Point> r, PolygonRec p) {
		if (q == null) return false;
		if (q.getValue().equals(r.getValue())) return equalsRecHalp(q.getNext(), r.getNext(), p);
		return equalsRec(q.getNext(), r, p);
	}
	public boolean equalsRecHalp(Node<Point> q, Node<Point> r, PolygonRec p) {
		if (q == null) q = this.points;
		if (r == null) {
			if (!q.getValue().equals(p.getPoints().getValue())) return false;
			return true;
		}
		if (!q.getValue().equals(r.getValue())) return false;
		return this.equalsRecHalp(q.getNext(), r.getNext(), p);
	}
	
	public String toString() {
		return "PolygonRec [" + points + "]";
	}
	// O(1) סיבוכיות של הכל 
}
