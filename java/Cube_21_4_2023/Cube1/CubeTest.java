package Cube1;

import java.util.Scanner;   

public class CubeTest {

	public static void main(String[] args) {
		Cube a = new Cube();
		Cube b = new Cube(13, "Black");
		Cube c = new Cube(a);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(a.getvolume());
		System.out.println(a.getSurfaceArea());
		
		System.out.println(a.isBigger(b));
		System.out.println(b.isBigger(a));
		System.out.println(a.isBigger(c));
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		
		print(arrOfCubes(b, 1));
		Cube d = scanCubeValus();
		System.out.println(d);
		print(arrOfCubes(d, 10));
	}
	
	public static void print(Cube[] c) {
		for (int i=0; i<c.length; i++) {
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
		Scanner scn = new Scanner(System.in);
		Cube c = new Cube();
		System.out.print("Enter side length:");
		c.setSideLength(scn.nextInt());
		System.out.print("Enter color:");
		c.setColor(scn.next());
		scn.close();
		return c;
	}
}
