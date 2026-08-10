package TestFix;

import Test.Cow;

public class Main {

	public static void main(String[] args) {
		// q1
		int[] a = {1,2,4,-1,2,5,3,7,-1,6,4,8,-1,2};
		int[] b = {1,2,4,-1,2,5,3,7,-1,6,4,8,-1,2,-1,2,5,3,7,-1,6};
		int[] c = {1,2,3,-1,6,4,8,-1,2,-1,3,6,-1,1,2,5};
		System.out.println(second(a));
		System.out.println(second(b));
		System.out.println(second(c));
		 
		// q2
		int[][] d = {{ 1, 2, 3, 4},
					 { 5, 6, 7, 8},
					 {-9, 9,-2,-4},
					 {-1,-3,-7,-6}};
		printMatrix(d);
		transpose(d);
		printMatrix(d);
		
		// q3 - a,b
		Date e = new Date();
		Date f = new Date();
		System.out.println(e);
		System.out.println(f);
		System.out.println(e.after(f));
		System.out.println(e.before(f));
		System.out.println(f.after(e));
		System.out.println(f.before(e));
		
		// q3 - c,d,e
		DairyFarm g = new DairyFarm();
		System.out.println(g);
		Cow k = new Cow();
		Cow l = new Cow();
		Cow m = new Cow();
		Cow n = new Cow();
		Cow o = new Cow();
		Cow p = new Cow();
		g.add(k);
		g.add(l);
		g.add(m);
		g.add(n);
		g.add(o);
		g.add(p);
		System.out.println(g);
		System.out.println();
		System.out.println(g.delete());
		System.out.println(g.delete());
		System.out.println();
		System.out.println(g);
		System.out.println();
		System.out.println(g.delete());
		System.out.println(g.delete());
		System.out.println(g.delete());
		System.out.println(g.delete());
		System.out.println(g.delete());
		System.out.println();
		System.out.println(g);
		
		
	}
	
	public static int maxNum(int[] arr) {
		int count = 0, max = 0, imax = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == -1) {
				if (count > max) {
					max = count;
					imax = i-max;
				}
				else if (count == max) {
					int x=imax, y=i-max;
					while ((arr[x] == arr[y]) && (arr[x] != -1)) {
						x++;
						y++;
					}
					if (arr[y] > arr[x]) {
						imax = i-max;
					}
				}
				count = 0;
			}
			else {
				count++;
			}
		}
		int num = 0;
		for (int i=imax; arr[i] != -1; i++) {
			num = num*10;
			num+=arr[i];
		}
		return num;
	}
	public static int second(int[] arr) {
		int num = 0, max1 = 0, max2 = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == -1) {
				if (num > max1) {
					max2 = max1;
					max1 = num;
				}
				else if (num > max2) {
					max2 = num;
				}
				num = 0;
			}
			else{
				num = num*10;
				num+=arr[i];
			}
		}
		if (num > max1) {
			max2 = max1;
			max1 = num;
		}
		else if (num > max2) {
			max2 = num;
		}
		return max2;
	}
	
	public static void transpose(int[][] matrix) {
		int temp;
		for (int i=0; i<matrix.length; i++) {
			for (int j=i+1; j<matrix[i].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if ((matrix[i][j] >= 0) && (matrix[i][j] <= 9)) {
					System.out.print("  "+matrix[i][j]);
				}
				else {
					System.out.print(" "+matrix[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
