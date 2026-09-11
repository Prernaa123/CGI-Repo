/**
 * 
 */
package com.cgi.io;

import java.util.Scanner;

/**
 * 
 */
public class DemoIOScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the details ->");
		System.out.println("Enter the Name ->\n");
		String name= scanner.nextLine();
		System.out.println("Enter the age ->\n");
		int age= scanner.nextInt();
		System.out.println("Enter the salary ->\n");
		double salary= scanner.nextDouble();
		
		
		System.out.println("\nDetails of Employee --->");
		System.out.println("Name::"+name);
		System.out.println("Age::"+age);
		System.out.println("Salary::"+salary);
		

	}

}
