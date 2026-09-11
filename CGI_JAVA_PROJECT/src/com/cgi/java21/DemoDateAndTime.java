/**
 * 
 */
package com.cgi.java21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 
 */
public class DemoDateAndTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayCurrentDate8to17();
	}
	
	// new Date & time package in java 11
	private static void displayCurrentDate8to17() {
		
		// Date class 
		Date currentDate=new Date();
		
		// now 
		
		LocalDate localDate=LocalDate.now();
		LocalTime localTime=LocalTime.now();
		LocalDateTime localDateTime=LocalDateTime.now();
		
	    System.out.println("Before Java 8/11---" +currentDate);
	    System.out.println("form Java 8/11-->" +localTime);
	    System.out.println("from java 8/11--->" +localDateTime);
	    System.out.println("form java 8/11--->" +localDate);
	    
	    //<<<<<<<<<<--- other methods--->>>>>>>>>>>>
	    
	    System.out.println("local get year--->" +localDate.getYear());
	    System.out.println("local get Month-->" +localDate.getMonth());
	    
	}		

}
