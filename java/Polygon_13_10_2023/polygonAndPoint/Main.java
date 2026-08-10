package polygonAndPoint;

public class Main {

	public static void main(String[] args) {
		//Point
		Point a = new Point(1,2);
		Point b = new Point(-4,3);
		Point c = new Point(-2,-3);
		Point d = new Point(5,-7);
		Point e = new Point(a);
		
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		System.out.println("c: "+c);
		System.out.println("d: "+d);
		System.out.println("e: "+e);
		System.out.println();
		
		System.out.println("a&e equals: "+e.equals(a));
		e.shiptPoint(-2,6);
		System.out.println("e shiptPoint(-2,6): "+e);
		System.out.println("a quadrant: "+a.quadrant());
		System.out.println("b quadrant: "+b.quadrant());
		System.out.println("c quadrant: "+c.quadrant());
		System.out.println("d quadrant: "+d.quadrant());
		System.out.println("b distance00: "+b.distance00());
		System.out.println("c distance(d): "+c.distance(d));
		System.out.println("a&e equals: "+e.equals(a));
		System.out.println("=========================================\n\n");
		
		//Polygon
		Polygon h = new Polygon();
		Polygon g = new Polygon(b);
		
		System.out.println("h: "+h);
		System.out.println("g: "+g);
		System.out.println();
		
		g.addPontL(c);
		g.addPontL(d);
		System.out.println("g addPontL(c&d): "+g);
		g.addPontF(a);
		System.out.println("g addPontF(a): "+g);
		h = new Polygon(g);
		System.out.println("h (copy of g): "+h);
		Polygon f = h.copyAndShiftPolygon(1,1);
		System.out.println("f (h.copyAndShiftPolygon(1,1)): "+f);
		System.out.println("h&f equals: "+h.equals(f));
		System.out.println("h&g equals: "+h.equals(g));
		h.delPoint(d);
		System.out.println("h delPoint(d): "+h);
		h.delPoint(d);
		System.out.println("h delPoint(d), (d not in h): "+h);
		h.delPoint(a);
		System.out.println("h delPoint(a): "+h);
		h.addPontL(d);
		h.addPontL(a);
		System.out.println("h: "+h);
		System.out.println("g: "+g);
		System.out.println("h&g equals: "+h.equals(g));
		h.delPoint(d);
		System.out.println("h delPoint(d): "+h);
		System.out.println("h&g equals: "+h.equals(g));
		System.out.println("h edgesNum: "+h.edgesNum());
		System.out.println("h edgesLength: "+h.edgesLength());
		System.out.println("h near00: "+h.near00());
		System.out.println("h getPoint(2): "+h.getPoint(2));
		System.out.println("h getPoint(7): "+h.getPoint(7));
		System.out.println("=========================================\n\n");

		//PolygonRec
		PolygonRec i = new PolygonRec();
		PolygonRec j = new PolygonRec(b);
		
		System.out.println("i: "+i);
		System.out.println("j: "+j);
		System.out.println();
		
		j.addPointLRec(c);
		j.addPointLRec(d);
		System.out.println("j addPointL(c&d): "+j);
		j.addPointFRec(a);
		System.out.println("j addPointF(a): "+j);
		i = new PolygonRec(j);
		System.out.println("i (copy of j): "+i);
		PolygonRec k = i.copyAndShiftPolygonRec(1,1);
		System.out.println("k (h.copyAndShiftPolygon(1,1)): "+k);
		System.out.println("i&k equals: "+i.equalsRec(k));
		System.out.println("i&j equals: "+i.equalsRec(j));
		i.delPointRec(d);
		System.out.println("i delPoint(d): "+i);
		i.delPointRec(d);
		System.out.println("i delPoint(d), (d not in i): "+i);
		i.delPointRec(a);
		System.out.println("i delPoint(a): "+i);
		i.addPointLRec(d);
		i.addPointLRec(a);
		System.out.println("i: "+i);
		System.out.println("j: "+j);
		System.out.println("i&j equals: "+i.equalsRec(j));
		i.delPointRec(d);
		System.out.println("i delPoint(d): "+i);
		System.out.println("i&j equals: "+i.equalsRec(j));
		System.out.println("i edgesNum: "+i.edgesNumRec());
		System.out.println("i edgesLength: "+i.edgesLengthRec());
		System.out.println("i near00: "+i.near00Rec());
		System.out.println("i getPoint(2): "+i.getPointRec(2));
		System.out.println("i getPoint(7): "+i.getPointRec(7));
		System.out.println("=========================================\n\n");
		
		System.out.println("makeSquare(a, 5): "+makeSquare(a, 5));
		System.out.println("makeSquare(c, 3): "+makeSquare(c, 3));
	}
	
	public static PolygonRec makeSquare(Point p, double distance) {
		PolygonRec newPolygonRec = new PolygonRec(p);
		Point shifted = new Point(p);
		shifted.shiptPoint(distance, 0);
		newPolygonRec.addPointFRec(shifted);
		shifted = new Point(shifted);
		shifted.shiptPoint(0, -distance);
		newPolygonRec.addPointFRec(shifted);
		shifted = new Point(shifted);
		shifted.shiptPoint(-distance, 0);
		newPolygonRec.addPointFRec(shifted);
		return newPolygonRec;
	}

}
