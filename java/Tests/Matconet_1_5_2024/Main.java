package Matconet_1_5_2024;

public class Main {

	public static void main(String[] args) {
		System.out.println(numNoN(13341234, 3));

	}
	
	public static int numNoN(int num, int n) {
		int x=0;
		while (num>0) {
			if ((num%10) != n) {
				x = x*10 +(num%10);
			}
			num = num/10;
		}
		while (x>0) {
			num = num*10 + (x%10);
			x = x/10;
		}
		return num;
	}

}
