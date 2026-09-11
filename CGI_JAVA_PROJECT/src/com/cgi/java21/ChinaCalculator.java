/**
 * 
 */
package com.cgi.java21;

/**
 * 
 */
public class ChinaCalculator implements Calculator {

	/*
	@Override
	public double addition(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
*/
	
	@Override
	public double substract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b+2;
	}

	@Override
	public double multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a*b+2;
	}

	@Override
	public double divide(int a, int b) {
		// TODO Auto-generated method stub
		return a/b+2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
