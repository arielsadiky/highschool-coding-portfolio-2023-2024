package Part_1_2;

import java.util.Random;
import java.util.Scanner;   

public class Main {

	public static void main(String[] args) {
		int rows = 5, columns = 5, num = 8;
		
		printMatrix(buildRandMatrix(rows, columns));
		printMatrix(buildChessMatrix(rows, columns));
		printMatrix(buildMultiplicationTable(rows, columns));
		printMatrix(buildCheckerboardMatrix(rows, columns));
		printMatrix(buildDimondMatrix(num));
		printMatrix(buildPascalTriengle(num));
		
		isMatrixSorted(buildRandMatrix(rows, columns));
		squareGame(builSsquareGameBored(rows, columns), (char)(11035));
		
		System.out.println(isMatrixSymmetrical(builSsquareGameBored(rows, columns)));
		System.out.println(isMatrixSymmetrical(buildRandMatrix(rows, columns)));
		System.out.println(isMatrixSymmetrical(buildMultiplicationTable(rows, columns)));
		System.out.println(isMatrixSymmetrical(buildCheckerboardMatrix(rows, columns)));
		System.out.println(isMatrixSymmetrical(buildChessMatrix(rows, columns)));
		System.out.println(isMatrixSymmetrical(buildDimondMatrix(num)));
		
		printMatrix(switchSlants(buildRandMatrix(rows, columns)));
		printMatrix(switchSlants(buildMultiplicationTable(rows, columns)));
		printMatrix(switchSlants(buildCheckerboardMatrix(rows, columns)));
		printMatrix(switchSlants(buildChessMatrix(rows, columns)));
		printMatrix(switchSlants(buildDimondMatrix(num)));
		
		System.out.println(isMatrixSparse(buildSparseMatrix(rows, columns)));
		printMatrix(buildSparseMatrixFromArrs(6, buildArr(4), buildArr(4), buildArr(4)));
		
		printMatrix(buildPosDirectNeighborsMatrix(buildRandPosAndNegMatrix(rows, columns)));
		printMatrix(buildPosNeighborsMatrix(buildRandPosAndNegMatrix(rows, columns)));
		
		System.out.println(isLatinSquare(buildRandPosAndNegMatrix(rows, columns)));
		System.out.println(isRingInMatrix(buildRandPosAndNegMatrix(rows, columns), 1));
		printRing(buildRandPosAndNegMatrix(rows, columns), 0);
		
		int[][] matrix = buildRandPosAndNegMatrix(rows, columns);
		for (int i=0; i<=(matrix.length/2); i++) {
			printRing(matrix, i);
			System.out.println();
			if ((i==((matrix.length/2)-1)) && (matrix.length%2 == 0)) {
				i++;
			}
		}
		
		System.out.println(isMatrixBInMatrixA(buildRandPosAndNegMatrix(rows, columns), buildRandPosAndNegMatrix(2, 2)));
		System.out.println(isScandMatrixInMatrixA(buildRandPosAndNegMatrix(rows, columns)));
		
		
		
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if ((matrix[i][j] >= 0) && (matrix[i][j] <= 9)) {
					System.out.print("  "+matrix[i][j]);
				}
				/*else if ((matrix[i][j] > 99)||(matrix[i][j] < -9)) {
					System.out.print(" "+matrix[i][j]);
				}*/
				else {
					System.out.print(" "+matrix[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printMatrix(char[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printArr(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
	
	
	public static int[][] buildRandMatrix(int rows, int columns) {
		Random rnd = new Random();
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (i>j) {
					matrix[i][j] = j+rnd.nextInt(i-j+1);
				}
				else {
					matrix[i][j] = i+rnd.nextInt(j-i+1);
				}
			}
		}
		return matrix;
	}
	public static char[][] buildChessMatrix(int rows, int columns) {
		char[][] matrix = new char[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (i>j) {
					matrix[i][j] = (char)(i+9812);
				}
				else {
					matrix[i][j] = (char)(j+9812);
				}
			}
		}
		return matrix;
	}
	public static int[][] buildMultiplicationTable(int rows, int columns) {
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = (i+1)*(j+1);
			}
		}
		return matrix;
	}
	public static char[][] buildCheckerboardMatrix(int rows, int columns) {
		char[][] matrix = new char[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (i%2 == j%2) {
					matrix[i][j] = (char)(11035);
				}
				else {
					matrix[i][j] = (char)(11036);
				}	
			}
		}
		return matrix;
	}
	public static char[][] buildDimondMatrix(int num) {
		char[][] matrix = new char[num][num];
		int mid1 = (matrix.length/2), mid2 = (matrix.length/2);
		if ((matrix.length%2) == 0) {
			mid1--;
		}
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if ((j == mid1) || (j== mid2)) {
					matrix[i][j] = (char)(11035);
				}
				else {
					matrix[i][j] = (char)(11036);
				}	
			}
			if (i<(matrix.length/2) && ((mid1-1)>=0)) {
				mid1--;
				mid2++;
			}
			else if (i>=(matrix.length/2)){
				mid1++;
				mid2--;
			}
		}
		return matrix;
	}
	public static int[][] buildPascalTriengle(int rows) {
		int[][] matrix = new int[rows][];
		for (int i=0; i<matrix.length; i++) {
			matrix[i] = new int[i+1];
			matrix[i][0] =1;
			matrix[i][i] =1;
		}
		for (int i=2; i<matrix.length; i++) {
			for (int j=1; j<(matrix[i].length-1); j++) {
				matrix[i][j] = (matrix[i-1][j]+matrix[i-1][j-1]);
			}
		}
		return matrix;
	}
	
	public static void isMatrixSorted(int[][] matrix) {
		printMatrix(matrix);
		boolean rowSorted = isMatrixRowSorted(matrix), columnSorted = isMatrixCoulmnSorted(matrix);
		if (rowSorted && columnSorted) {
			System.out.println("Matrix completly sorted");
		}
		else if (rowSorted && !columnSorted) {
			System.out.println("Matrix row sorted");
		}
		else if (!rowSorted && columnSorted) {
			System.out.println("Matrix column sorted");
		}
		else {
			System.out.println("Matrix not sorted");
		}
	}
	public static boolean isMatrixRowSorted(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=1; j<matrix[i].length; j++) {
				if (matrix[i][j]<matrix[i][j-1]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isMatrixCoulmnSorted(int[][] matrix) {
		for (int j=0; j<matrix[0].length; j++) {
			for (int i=1; i<matrix.length; i++) {
				if (matrix[i][j]<matrix[i-1][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void squareGame(char[][] matrix, char player) {
		printMatrix(matrix);
		int points=0;
		for (int i=0; i<(matrix.length-1); i++) {
			for (int j=0; j<(matrix[0].length-1); j++) {
				if ((matrix[i][j] == player)&&(matrix[i][j+1] == player)&&(matrix[i+1][j] == player)&&(matrix[i+1][j+1] == player)) {
					points++;
				}
			}
		}
		System.out.println("points: "+points);
		System.out.println();
	}
	public static char[][] builSsquareGameBored(int rows, int columns) {
		Random rnd = new Random();
		char[][] matrix = new char[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = (char)(11034+rnd.nextInt(3));
			}
		}
		return matrix;
	}
	
	
	
	public static boolean isMatrixSymmetrical(int[][] matrix) {
		printMatrix(matrix);
		if (matrix.length != matrix[0].length) {
			return false;
		}
		for (int i=0; i<matrix.length; i++) {
			for (int j=1; j<matrix[0].length; j++) {
				if (matrix[i][j] != matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isMatrixSymmetrical(char[][] matrix) {
		printMatrix(matrix);
		if (matrix.length != matrix[0].length) {
			return false;
		}
		for (int i=0; i<matrix.length; i++) {
			for (int j=1; j<matrix[0].length; j++) {
				if (matrix[i][j] != matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[][] switchSlants(int[][] matrix) {
		printMatrix(matrix);
		int temp;
		for (int i=0, j=0; i<matrix.length; i++, j++) {
			temp = matrix[i][j];
			matrix[i][j] = matrix[i][matrix[0].length-j-1];
			matrix[i][matrix[0].length-j-1] = temp;
		}
		return matrix;
	}
	public static char[][] switchSlants(char[][] matrix) {
		printMatrix(matrix);
		char temp;
		for (int i=0, j=0; i<matrix.length; i++, j++) {
			temp = matrix[i][j];
			matrix[i][j] = matrix[i][matrix[0].length-j-1];
			matrix[i][matrix[0].length-j-1] = temp;
		}
		return matrix;
	}
	
	public static int[][] buildSparseMatrix(int rows, int columns) {
		Random rnd = new Random();
		int x;
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = 5-rnd.nextInt(10);
				x=9;
				while ((x>0) && (matrix[i][j] != 0)) {
					matrix[i][j] = 3-rnd.nextInt(6);
					x--;
				}
			}
		}
		return matrix;
	}
	public static boolean isMatrixSparse(int[][] matrix) {
		printMatrix(matrix);
		double countSum = 0;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					countSum++;
					if ((isMoreThanTwoInRow(matrix, i)) || (isMoreThanTwoInColumn(matrix, j))) {
						return false;
					}
				}
			}
		}
		if ((countSum/(matrix.length*matrix[0].length))>=0.2) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean isMoreThanTwoInRow(int[][] matrix, int i) {
		int j=0, count=0;
		while ((j<matrix[i].length)&&(count<=2)){
			if (matrix[i][j] != 0) {
				count++;
			}
			j++;
		}
		if (count>2) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isMoreThanTwoInColumn(int[][] matrix, int j) {
		int i=0, count=0;
		while ((i<matrix.length)&&(count<=2)){
			if (matrix[i][j] != 0) {
				count++;
			}
			i++;
		}
		if (count>2) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int[] buildArr(int length) {
		Random rnd = new Random();
		int[] arr = new int[length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = 1+rnd.nextInt(5);
			
		}
		return arr;
	}
	public static int[][] buildSparseMatrixFromArrs(int size, int[] nums, int[] rows, int[] columns) {
		printArr(nums);
		printArr(rows);
		printArr(columns);
		int[][] matrix = new int[size][size];
		for (int i=0; i<nums.length; i++) {
			matrix[rows[i]][columns[i]] = nums[i];
		}
		return matrix;
	}
	
	public static int[][] buildRandPosAndNegMatrix(int rows, int columns) {
		Random rnd = new Random();
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = rnd.nextInt(2);
				if (matrix[i][j] == 0) {
					//matrix[i][j] = 3-rnd.nextInt(6);
				}
			}
		}
		return matrix;
	}
	public static int[][] buildPosDirectNeighborsMatrix(int[][] a) {
		printMatrix(a);
		int count = 0;
		int[][] b = new int[a.length][a[0].length];
		for (int i=0; i<b.length; i++) {
			for (int j=0; j<b[0].length; j++) {
				count = 0;
				if ((i>0) && (a[i-1][j] > 0)) {
					count++;
				}
				if ((i<(b.length-1)) && (a[i+1][j] > 0)) {
					count++;
				}
				if ((j>0) && (a[i][j-1] > 0)) {
					count++;
				}
				if ((j<(b[0].length-1)) && (a[i][j+1] > 0)) {
					count++;
				}
				b[i][j] = count;
			}
		}
		return b;
	}
	public static int[][] buildPosNeighborsMatrix(int[][] a) {
		printMatrix(a);
		int count = 0;
		int[][] b = new int[a.length][a[0].length];
		for (int i=0; i<b.length; i++) {
			for (int j=0; j<b[0].length; j++) {
				count = buildPosNeighborsMatrixHelp(a, i, j);
				b[i][j] = count;
			}
		}
		return b;
	}
	public static int buildPosNeighborsMatrixHelp(int[][] a, int x, int y) {
		int count = 0;
		for (int i=(x-1); i<=(x+1); i++) { 
			if (i<0) {
				i++;
			}
			for (int j=(y-1); j<=(y+1); j++) { 
				if (j<0) {
					j++;
				}
				if (a[i][j] > 0) {
					count++;
				}
				if (j == (a[0].length-1)) {
					j++;
				}
			}
			if (i == (a.length-1)){
				i++;
			}
		}
		if (a[x][y] > 0) {
			count--;
		}
		return count;
	}
	
	public static boolean isLatinSquare(int[][] matrix) {
		printMatrix(matrix);
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (!isOnlyInRow(matrix, i, j)) {
					return false;
				}
				if (!isOnlyInCoulmn(matrix, i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isOnlyInRow(int[][] matrix, int x, int y) {
		for (int j=0; j<matrix[0].length; j++) {
			if ((matrix[x][j] == matrix[x][y]) && (j != y)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isOnlyInCoulmn(int[][] matrix, int x, int y) {
		for (int i=0; i<matrix.length; i++) {
			if ((matrix[i][y] == matrix[x][y]) && (i != x)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isRingInMatrix(int[][] matrix, int n) {
		printMatrix(matrix);
		if (matrix.length%2 == 0) {
			if (n<(matrix.length/2)) {
				return true;
			}
			return false;
		}
		else {
			if (n<=(matrix.length/2)) {
				return true;
			}
			return false;
		}
	}
	public static void printRing(int[][] matrix, int n) {
		if(!isRingInMatrix(matrix, n)) {
			System.out.print("Ring "+n+" not found...");
			return;
		}
		int x=((matrix.length/2)-n), y=((matrix[0].length/2)-n);
		if (matrix.length%2 == 0) {
			x--;
		}
		if (matrix[0].length%2 == 0) {
			y--;
		}
		for(int i=x; i<=(matrix.length/2)+n; i++) {
			for (int j=y; j<=(matrix[0].length/2)+n; j++) {
				if ((i==x) || (i==((matrix.length/2)+n))) {
					if ((matrix[i][j] >= 0) && (matrix[i][j] <= 9)) {
						System.out.print("  "+matrix[i][j]);
					}
					else {
						System.out.print(" "+matrix[i][j]);
					}
				}
				else {
					if ((j==y) || (j==((matrix[0].length/2)+n))) {
						if ((matrix[i][j] >= 0) && (matrix[i][j] <= 9)) {
							System.out.print("  "+matrix[i][j]);
						}
						else {
							System.out.print(" "+matrix[i][j]);
						}
					}
					else {
						System.out.print("   ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static boolean isMatrixBInMatrixA(int[][] a, int[][] b) {
		printMatrix(a);
		printMatrix(b);
		for (int i=0; i<=(a.length-b.length); i++) {
			for (int j=0; j<=(a[0].length-b[0].length); j++) {
				if (a[i][j] == b[0][0]) {
					if (isMatrixBInMatrixAHelp(a, b, i, j)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean isMatrixBInMatrixAHelp(int[][] a, int[][] b, int x, int y) {
		for (int i=0; i<b.length; i++) {
			for (int j=0; j<b[0].length; j++) {
				if (b[i][j] != a[i+x][j+y]) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isScandMatrixInMatrixA(int[][] matrix) {
		Scanner scn = new Scanner(System.in);
		int[][] scan = new int[2][2];
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				System.out.print("Enter valu: ");
				scan[i][j] = scn.nextInt();
			}
		}
		scn.close(); 
		return isMatrixBInMatrixA(matrix, scan);
	}
	
	

}
