package com.cgi.java21;

public class CalcClient {

    public static void main(String[] args) {
      
        System.out.println("----------------------------------------");
        System.out.println("China Calculator");
        System.out.println("----------------------------------------");
        
        ChinaCalculator cal = new ChinaCalculator();
        
        
        System.out.printf("China Addition       : %.0f%n", cal.addition(10, 10));
        System.out.printf("China Substraction   : %.0f%n", cal.substract(20, 10));
        System.out.printf("China Multiplication : %.0f%n", cal.multiply(10, 10));
        System.out.printf("China Divide         : %.3f%n", cal.divide(10, 20)); 

        
        System.out.println("\n----------------------------------------");
        System.out.println("Indian Calculator");
        System.out.println("----------------------------------------");
        
        IndianCalculator cal1 = new IndianCalculator();
        
        System.out.printf("Indian Addition      : %.0f%n", cal1.addition(10, 10));
        System.out.printf("Indian Substraction  : %.0f%n", cal1.substract(20, 10));
        System.out.printf("Indian Multiplication: %.0f%n", cal1.multiply(10, 10));
        System.out.printf("Indian Divide        : %.3f%n", cal1.divide(10, 20)); 
        System.out.println("----------------------------------------");
    }
}
