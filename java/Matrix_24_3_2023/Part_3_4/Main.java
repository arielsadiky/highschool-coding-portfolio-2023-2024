package Part_3_4;

import java.util.Random;
import java.util.Scanner;   

public class Main {

	public static void main(String[] args) {
		bingo(buildRandBingoCard(), buildRandBingoCard());
		
		farthestCityFrom(buildRandDistansChart(), 3);
		farthestCityFromEachCity(buildRandDistansChart());
		System.out.println(nearestCityToAll(buildRandDistansChart()));
		
		printMatrix(countNumOfEachSectionAndSumOfProfit(buildRandSouperMarketData(10)));
		printMatrix(countSumOfProfitInCashRegister(buildRandSouperMarketData(10)));
		mostProfitableDepartment(buildRandSouperMarketData(10));
		
		//printMatrix(buildAirPollutionChart(20));
		System.out.println(avregPollutionInMonth(buildAirPollutionChart(50), 3));
		printMatrix(cityAirPollutionChart(buildAirPollutionChart(10), 56));
		
		int[][] sudoku = {{3,4,2,1},
						  {2,1,3,4},
						  {1,2,4,3},
						  {4,3,1,2}
						};
		
		System.out.println(isSudoku(sudoku));
		
		
		System.out.println(isNumOnChart(buildRandNumChart(4,4), 123));
		
		int[][] magicTable = {{ 1, 4, 2, 3},
				  			  { 8, 7, 6, 5},
				  			  { 9,10,11,12},
				  			  {16,15,14,13}};
		
		System.out.println(isMagicTable(magicTable));
		printMatrix(buildMagicTable(9));
		
		//printMatrix(buildTheGameOfLifeBord(5,6));
		theGameOfLife(5,6);
		
		
		
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
	
	public static int[][] buildRandBingoCard() {
		Random rnd = new Random();
		int[][] matrix = new int[5][5];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = rnd.nextInt(100);
			}
		}
		return matrix;
	}
	public static void bingo(int[][] p1, int[][] p2) {
		printMatrix(p1);
		printMatrix(p2);
		Random rnd = new Random();
		boolean noWinner = true;
		int num, x = 0;
		while (noWinner) {
			num = rnd.nextInt(100);
			System.out.print(num +", ");
			if (x == 10) {
				System.out.println();
				x=0;
			}
			bingoMarkNumOnCard(p1, num);
			bingoMarkNumOnCard(p2, num);
			if (bingoDidPlayerWin(p1)) {
				noWinner = false;
				System.out.println();
				System.out.println();
				printMatrix(p1);
				System.out.println("player 1 wone!!!");
			}
			if (bingoDidPlayerWin(p2)) {
				noWinner = false;
				System.out.println();
				System.out.println();
				printMatrix(p2);
				System.out.println("player 2 wone!!!");
			}
		x++;
		}
	}
	public static void bingoMarkNumOnCard(int[][] p, int num) {
		for (int i=0; i<p.length; i++) {
			for (int j=0; j<p[i].length; j++) {
				if (p[i][j] == num) {
					p[i][j] = -1;
				}
			}
		}
	}	
	public static boolean bingoDidPlayerWin(int[][] p) {
		return (bingoCheckRows(p) || bingoCheckColumns(p) || bingoCheckFirstDiagonal(p) || bingoCheckSecondtDiagonal(p));
	}
	public static boolean bingoCheckRows(int[][] p) {
		for (int i=0; i<p.length; i++) {
			if (p[i][0] == -1) {
				for (int j=0; j<p[i].length; j++) {
					if (p[i][j] != -1) {
						j+=p[i].length;
					}
					if ((j == p[i].length-1) && (p[i][j] == -1)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean bingoCheckColumns(int[][] p) {
		for (int j=0; j<p[0].length; j++) {
			if (p[0][j] == -1) {
				for (int i=0; i<p.length; i++) {
					if (p[i][j] != -1) {
						i+=p[i].length;
					}
					if ((i == p.length-1) && (p[i][j] == -1)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean bingoCheckFirstDiagonal(int[][] p) {
		for (int i=0, j=0; i<p.length; i++, j++) {
			if (p[i][j] != -1) {
				return false;
			}
		}
		return true;
	}
	public static boolean bingoCheckSecondtDiagonal(int[][] p) {
		for (int i=0, j=(p[0].length-1); i<p.length; i++, j--) {
			if (p[i][j] != -1) {
				return false;
			}
		}
		return true;
	}
	
	public static int[][] buildRandDistansChart() {
		Random rnd = new Random();
		int[][] matrix = new int[5][5];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<=i; j++) {
				if (j == i) {
					matrix[i][j] = 0;
				}
				else {
					matrix[i][j] = 1+rnd.nextInt(49);
					matrix[j][i] = matrix[i][j];
				}
			}
		}
		return matrix;
	}
	public static void farthestCityFrom(int[][] chart, int city) {
		printMatrix(chart);
		if (city > chart.length-1) {
			System.out.print("city not found");
			return;
		}
		int max = 0, x = 0;
		for (int i=0; i<chart.length; i++) {
			if (chart[city][i] > max) {
				max = chart[city][i];
				x=i;
			}
		}
		System.out.println("city "+x+" is the farthest city from city "+city+" and is "+max+" kilomiters away");
	}
	public static void farthestCityFromEachCity(int[][] chart) {
		for (int i=0; i<chart.length; i++) {
			farthestCityFrom(chart, i);
		}
	}
	public static int nearestCityToAll(int[][] chart) {
		printMatrix(chart);
		int sum = 0, min = 250, city = -1;
		for (int i=0; i<chart.length; i++) {
			for (int j=0; j<chart[i].length; j++) {
				sum += chart[i][j];
			}
			if (sum<min) {
				min = sum;
				city = i;
			}
			sum = 0;
		}
		return city;
	}
	
	public static int[][] buildRandSouperMarketData(int amount) {
		Random rnd = new Random();
		int[][] matrix = new int[3][amount];
		
		for (int j=0; j<matrix[0].length; j++) {
			matrix[0][j] = 1+rnd.nextInt(7);
		}
		for (int j=0; j<matrix[0].length; j++) {
			matrix[1][j] = 1+rnd.nextInt(45);
		}
		for (int j=0; j<matrix[0].length; j++) {
			matrix[2][j] = 1+rnd.nextInt(10);
		}
		return matrix;
	}
	public static int[][] countNumOfEachSectionAndSumOfProfit(int[][] chart) {
		printMatrix(chart);
		int[][] countAndSum = new int[2][10];
		for (int i=0; i<countAndSum.length; i++) {
			for (int j=0; j<countAndSum[0].length; j++) {
				countAndSum[i][j] = 0;
			}
		}
		for (int j=0; j<chart[0].length; j++) {
			countAndSum[0][chart[2][j]-1]++;
			countAndSum[1][chart[2][j]-1]+=chart[1][j];
		}
		return countAndSum;
	}
	public static int[][] countSumOfProfitInCashRegister(int[][] chart) {
		printMatrix(chart);
		int[][] profit = new int[2][7];
		for (int j=0; j<profit[0].length; j++) {
			profit[0][j] = j+1;
			profit[1][j] = 0;
		}
		for (int j=0; j<chart[0].length; j++) {
			profit[1][chart[0][j]-1]+=chart[1][j];
		}
		return profit;
	}
	public static void mostProfitableDepartment(int[][] chart) {
		int[][] profit = countNumOfEachSectionAndSumOfProfit(chart);
		printMatrix(profit);
		int x = 0;
		for (int j=0; j<profit[0].length; j++) {
			if (profit[1][j]>profit[1][x]) {
				x=j;
			}
		}
		System.out.println("most profitable department is department "+(x+1));
	}
	
	public static int[][] buildAirPollutionChart(int amount) {
		Random rnd = new Random();
		int[][] matrix = new int[amount+1][13];
		
		for (int j=0; j<matrix[0].length; j++) {
			matrix[0][j] = j;
		}
		for (int i=0; i<matrix.length; i++) {
			matrix[i][0] = i;
		}
		for (int i=1; i<matrix.length; i++) {
			for (int j=1; j<matrix[0].length; j++) {
				matrix[i][j] = 2+rnd.nextInt(13);
			}
		}
		return matrix;
	}
	public static double avregPollutionInMonth(int[][] chart, int month) {
		printMatrix(chart);
		if ((month)>12 || (month)<1) {
			System.out.println("month doesn't exist");
			return -1;
		}
		double sum = 0;
		for (int i=1; i<chart.length; i++) {
			sum+=chart[i][month];
		}
		return sum/(chart.length-1);
	}
	public static int[][] cityAirPollutionChart(int[][] chart, int city) {
		printMatrix(chart);
		int[][] cityPollotion = new int[2][13];
		for (int j=0; j<cityPollotion[0].length; j++) {
			cityPollotion[0][j] = j;
		}
		cityPollotion[1][0] = city;
		if (city<1 || city>(chart.length-1)) {
			return cityPollotion;
		}
		for (int j=0; j<cityPollotion[0].length; j++) {
			cityPollotion[1][j] = chart[city][j];
		}
		return cityPollotion;
	}
	
	public static boolean isSudoku(int[][] sudoku) {
		int[] nums = new int[sudoku[0].length];
		for (int i=0; i<nums.length; i++) {
			nums[i] = i+1;
		}
		return (areAllNumsInColumns(sudoku, nums) && areAllNumsInRows(sudoku, nums)
				&& areAllNumsInSection(sudoku, nums));
	}
	public static boolean areAllNumsInColumns(int[][] sudoku, int[] nums) {
		for (int j=0; j<sudoku[0].length; j++) {
			for (int i=0; i<nums.length; i++) {
				if (!isNumInColumns(sudoku, j, nums[i])) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isNumInColumns(int[][] sudoku, int j, int num) {
		for (int i=0; i<sudoku[j].length; i++) {
			if (sudoku[i][j] == num) {
				return true;
			}
		}
		return false;
	}
	public static boolean areAllNumsInRows(int[][] sudoku, int[] nums) {
		for (int i=0; i<sudoku.length; i++) {
			for (int j=0; j<nums.length; j++) {
				if (!isNumInRow(sudoku, i, nums[j])) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isNumInRow(int[][] sudoku, int i, int num) {
		for (int j=0; j<sudoku[i].length; j++) {
			if (sudoku[i][j] == num) {
				return true;
			}
		}
		return false;
	}
	public static boolean areAllNumsInSection(int[][] sudoku, int[] nums) {
		for (int i=0; i<sudoku.length; i+=2) {
			for (int j=0; j<sudoku[i].length; j+=2) {
				for (int x=0; x<nums.length; x++) {
					if (!areNumsInSection(sudoku, nums[x], i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean areNumsInSection(int[][] sudoku, int num, int i, int j) {
		for (int x=0; x<2; x++) {
			for (int y=0; y<2; y++) {
				if (sudoku[x+i][y+j] == num) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	public static int[][] buildRandNumChart(int rows, int columns) {
		Random rnd = new Random();
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = 1+rnd.nextInt(10);
			}
		}
		return matrix;
	}
	public static boolean isNumOnChart(int[][] chart, int num) {
		printMatrix(chart);
		int nl = 0, n = num;
		while (n>0) {
			nl++;
			n=n/10;
		}
		for (int i=0; i<chart.length; i++) {
			for (int j=0; j<chart[0].length; j++) {
				if (chart[i][j] == (num%10)) {
					if (isNumLeftToRight(chart, num, i, j, nl)
							|| isNumRightToLeft(chart, num, i, j, nl)
							|| isNumUpToDown(chart, num, i, j, nl)
							|| isNumDownToUp(chart, num, i, j, nl)
							|| isNumDayagonalUpLeft(chart, num, i, j, nl)
							|| isNumDayagonalUpRight(chart, num, i, j, nl)
							|| isNumDayagonalDownLeft(chart, num, i, j, nl)
							|| isNumDayagonalDownRight(chart, num, i, j, nl)) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	public static boolean isNumLeftToRight(int[][] chart, int num, int x, int y, int nl) {
		for (int j=y, n=num; (j<chart[0].length) && (n != 0); j++, n=(n/10)) {
			if (chart[x][j] != (n%10)) {
				return false;
			}
		}
		if ((y+nl-1)<chart[0].length) {
			return true;
		}
		return false;
	}
	public static boolean isNumRightToLeft(int[][] chart, int num, int x, int y, int nl) {
		for (int j=y, n=num; (j>=0) && (n != 0); j--, n=(n/10)) {
			if (chart[x][j] != (n%10)) {
				return false;
			}
		}
		if ((y-nl+1)>=0) {
			return true;
		}
		return false;
	}
	public static boolean isNumUpToDown(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, n=num; (i<chart.length) && (n != 0); i++, n=(n/10)) {
			if (chart[i][y] != (n%10)) {
				return false;
			}
		}
		if ((x+nl-1)<chart.length) {
			return true;
		}
		return false;
	}
	public static boolean isNumDownToUp(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, n=num; (i>=0) && (n != 0); i--, n=(n/10)) {
			if (chart[i][y] != (n%10)) {
				return false;
			}
		}
		if ((x-nl+1)>=0) {
			return true;
		}
		return false;
	}
	public static boolean isNumDayagonalUpLeft(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, j=y, n=num; (i>=0) && (j>=0) && (n != 0); i--, j--, n=(n/10)) {
			if (chart[i][j] != (n%10)) {
				return false;
			}
		}
		if (((x-nl+1)>=0) && ((y-nl+1)>=0)) {
			return true;
		}
		return false;
	}
	public static boolean isNumDayagonalUpRight(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, j=y, n=num; (i>=0) && (j<chart[0].length) && (n != 0); i--, j++, n=(n/10)) {
			if (chart[i][j] != (n%10)) {
				return false;
			}
		}
		if (((x-nl+1)>=0) && ((y+nl-1)<chart[0].length)) {
			return true;
		}
		return false;
	}
	public static boolean isNumDayagonalDownLeft(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, j=y, n=num; (i<chart.length) && (j>=0) && (n != 0); i++, j--, n=(n/10)) {
			if (chart[i][j] != (n%10)) {
				return false;
			}
		}
		if (((x+nl-1)<chart.length) && ((y-nl+1)>=0)) {
			return true;
		}
		return false;
	}
	public static boolean isNumDayagonalDownRight(int[][] chart, int num, int x, int y, int nl) {
		for (int i=x, j=y, n=num; (i<chart.length) && (j<chart[0].length) && (n != 0); i++, j++, n=(n/10)) {
			if (chart[i][j] != (n%10)) {
				return false;
			}
		}
		if (((x+nl-1)<chart.length) && ((y+nl-1)<chart[0].length)) {
			return true;
		}
		return false;
	}
	
	public static boolean isMagicTable(int[][] matrix) {
		printMatrix(matrix);
		if (matrix.length != matrix[0].length) {
			return false;
		}
		for (int i=0; i<(matrix.length*matrix.length); i++) {
			if (!isNumInMatrix(matrix, i+1)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isNumInMatrix(int[][] matrix, int num) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				if (matrix[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}
	public static int[][] buildMagicTable(int amount) {
		int[][] matrix = new int[amount][amount];
		for (int i=0, j=(matrix.length/2), n=1;  n<=(amount*amount); n++, i--, j--) {
			if (i<0) {
				i=(matrix.length-1);
			}
			if (j<0) {
				j=(matrix.length-1);
			}
			if (matrix[i][j] != 0) {
				i++;
				if (i>=matrix.length) {
					i=0;
				}
			}
			matrix[i][j]=n;
		}
		return matrix;
	}
	
	public static void theGameOfLife(int rows, int columns) {
		Scanner scn = new Scanner(System.in);
		char[][] gen = buildTheGameOfLifeBord(rows, columns);
		printMatrix(gen);
		char continu = 'a';
		while ((continu != 'y') && (continu != 'n')) {
			System.out.println("do you want next gen? y/n");
			continu =  scn.next().charAt(0);
		}
		while (continu == 'y') {
			gen = makeNextGen(gen);
			printMatrix(gen);
			System.out.println("do you want next gen? y/n");
			continu =  scn.next().charAt(0);
			while ((continu != 'y') && (continu != 'n')) {
				System.out.println("do you want next gen? y/n");
				continu =  scn.next().charAt(0);
			}
		}
		scn.close(); 
	}
	public static char[][] buildTheGameOfLifeBord(int rows, int columns) {
		Random rnd = new Random();
		char[][] matrix = new char[rows][columns];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = (char)(11035+rnd.nextInt(2));
			}
		}
		return matrix;
	}
	public static char[][] makeNextGen(char[][] gen) {
		char[][] newGen = new char[gen.length][gen[0].length];
		int neighbors = 0;
		for (int i=0; i<newGen.length; i++) {
			for (int j=0; j<newGen[0].length; j++) {
				neighbors = countNeighbor(gen, i, j);
				if ((neighbors >= 3) && (neighbors <=5)) {
					newGen[i][j] = (char)(11035);
				}
				else {
					newGen[i][j] = (char)(11036);
				}
			}
		}
		return newGen;
	}
	public static int countNeighbor(char[][] a, int x, int y) {
		int count = 0;
		for (int i=(x-1); i<=(x+1); i++) { 
			if (i<0) {
				i++;
			}
			for (int j=(y-1); j<=(y+1); j++) { 
				if (j<0) {
					j++;
				}
				if (a[i][j] == (char)(11035)) {
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
		if (a[x][y] == (char)(11035)) {
			count--;
		}
		return count;
	}
	
	
	
}
