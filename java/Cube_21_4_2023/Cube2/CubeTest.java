package Cube2;

import java.util.Scanner;

public class CubeTest {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		//סוגי בנייה
		Cube a = new Cube();
		Cube b = new Cube(13, "Black");
		Cube c = new Cube(a);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//פעולות של קוביה
		System.out.println(a.getvolume());
		System.out.println(a.getSurfaceArea());
		System.out.println();
		
		System.out.println(a.isBigger(b));
		System.out.println(b.isBigger(a));
		System.out.println(a.isBigger(c));
		System.out.println();
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println();
		
		print(arrOfCubes(b, 10));
		Cube d = scanCubeValus();
		System.out.println(d);
		System.out.println();
		
		// מגדל קוביות
		Cube e = new Cube(18, "red");
		Cube f = new Cube(21, "yellow");
		Cube g = new Cube(23, "White");
		
		CubeTower x = new CubeTower(7);
		System.out.println(x.isTowerEmpty());
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(e);
		x.add(f);
		x.add(g);
		print(x.getTower(), x.getAmountOfCubes());
		System.out.println();
		
		// פעולות על מגדל קוביות
		System.out.println(x.takeOff());
		System.out.println(x.isColorInTower("Black"));
		System.out.println(x.isColorInTower("red"));
		System.out.println(x.isTowerEmpty());
		System.out.println(x.isTowerFull());
		for (int i=0; i<5; i++) {
			x.add(b);
		}
		System.out.println(x.isTowerFull());
		System.out.println();
		
		CubeTower h = x.buildOneOfEachColorTower();
		print(h.getTower(), h.getAmountOfCubes());
		System.out.println();
		
		CubeTower i = buildCubeTower();
		System.out.println();
		print(i.getTower(), i.getAmountOfCubes());
		System.out.println();
		
		CubeTower j = buildOneOfEachColorTower(i);
		print(j.getTower(), j.getAmountOfCubes());
		System.out.println();
		
		towerSort(j);
		print(j.getTower(), j.getAmountOfCubes());
		System.out.println();
		
		h.towerSort();
		print(h.getTower(), h.getAmountOfCubes());
		System.out.println();
	}
	
	public static void print(Cube[] c) {
		for (int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
	}
	public static void print(Cube[] c, int count) {
		for (int i=0; i<count; i++) {
			System.out.println(c[i]);
		}
	}

	public static Cube[] arrOfCubes(Cube c, int x) {
		Cube[] cubes = new Cube[x];
		cubes[0] = new Cube(c);
		for (int i=1; i<x; i++) {
			cubes[i] = new Cube((c.getSideLength()+i), c.getColor());
		}
		return cubes;
	}
	
	public static Cube scanCubeValus() {
		Cube c = new Cube();
		System.out.print("Enter side length:");
		c.setSideLength(scn.nextInt());
		System.out.print("Enter color:");
		c.setColor(scn.next());
		return c;
	}
	
	public static CubeTower buildCubeTower() {
		System.out.print("Enter max tower hight:");
		CubeTower c = new CubeTower(scn.nextInt());
		int x=0;
		while (x!=3) {
			System.out.print("If you want to add press 1. If you want to take off press 2. If you want to stop building press 3.");
			x = scn.nextInt();
			if (x == 1) {
				c.add(scanCubeValus());
			}
			else if (x == 2) {
				c.takeOff();
			}
			print(c.getTower(), c.getAmountOfCubes());
		}
		return c;
	}
	
	public static CubeTower buildOneOfEachColorTower(CubeTower a) {
		CubeTower c = new CubeTower(a.getAmountOfCubes());
		int x = a.getAmountOfCubes();
		Cube temp;
		boolean is = false;
		for (int i=0; i<x; i++) {
			temp = a.takeOff();
			for (int j=0; j<c.getAmountOfCubes(); j++) {
				if ((temp.getColor()).equals(c.getTower()[j].getColor())) {
					is = true;
				}
			}
			if (!is) {
				c.add(temp);
			}
			is = false;
		}
		return c;
	}

	public static void towerSort(CubeTower a) {
		for (int i=0; i<a.amountOfCubes; i++) {
			int minIndex = i;
			for (int j=i+1; j<a.amountOfCubes; j++) {
				if (a.getTower()[j].getSideLength() < a.getTower()[minIndex].getSideLength()) {
					minIndex = j;
				}
			}
			swap(a.getTower(), i, minIndex);
		}
	}
	public static void swap(Cube[] arr, int i, int j) {
		Cube temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
