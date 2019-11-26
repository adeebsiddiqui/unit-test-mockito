package com.ad;

public class MathApp1 {

	private Calc calc;
	
	public Calc getCalc() {
		return calc;
	}
	
	public void setCalc(Calc calc) {
		this.calc = calc;
	}
	
	public double add (double x, double y) {
		return calc.add(x, y);
	}
	
	public double divide (double x, double y) {
		return calc.divide(x, y);
	}
}
