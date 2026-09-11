/**
 * 
 */
package com.cgi.java21;

/**
 * 
 */
public interface Calculator {
	
	public default double addition(int a, int b) {
		
		
		 return a+b;
	}
	public double substract(int a, int b);
	public double multiply(int a, int b);
	public double divide(int a, int b);

}
