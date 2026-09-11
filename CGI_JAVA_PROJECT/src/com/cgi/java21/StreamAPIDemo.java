/**
 * 
 */
package com.cgi.java21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 */
public class StreamAPIDemo {

	/**
	 * @param args
	 */
static List<Integer> inList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);	public static void main(String[] args) {
		// TODO Auto-generated method stub

		beforeJava8to11();
		formJava8to11();
	}
	
	 // Traditional way to put the logic of code 
	
		// before Java 8 //11 
		// even number in the Exisitng list
		private static void beforeJava8to11() {
			
		   // another List put the even numbers 
			List<Integer> evenList=new ArrayList<Integer>();
			
			 for(int i:inList) {
				 
				 if(i%2==0) {
			 
					  evenList.add(i);
				 }
			 }
			 
			 System.out.println("Even Number List-->" +evenList);
			
		}
		
		
		// Implment the same method using Stream with lambda function 
		
		 private static void formJava8to11() {
			 
			 
	      System.out.println( 		  
	      "Even Number List-->" +inList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));		  
	    		  
		 }

}
