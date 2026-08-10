package polynomAndPolynomMember;

import java.lang.Math;

public class PolynomMember{
	private int coefficient;
	private int power;
	
	public PolynomMember(int coefficient, int power){
		this.coefficient = coefficient;
		this.power = power;
	}
	public PolynomMember(PolynomMember p){
		this.coefficient = p.coefficient;
		this.power = p.power;
	}
	
	public int getCoefficient(){
		return this.coefficient;
	}
	public void setCoefficient(int coefficient){
		this.coefficient = coefficient;
	}
	public int getPower(){
		return this.power;
	}
	public void setPower(int power){
		this.power = power;
	}
	public int value(int x) {
		return (int)(Math.pow(x, this.power) * this.coefficient);
	} 
	
	public String toString() {
		if (this.coefficient == 0) return "";
		String str = "";
		if (this.coefficient > 0) str += "+";
		if (this.power == 0) return str + this.coefficient;
		if (this.power == 1) return str + this.coefficient + "x";
		return str + this.coefficient + "x^" + this.power;
	}
	
	//O(1) הכל 
}