/**
 * Recursion.java 
 * User: jmunta
 */
package com.everydayon;

/**
 *552. Recursion - Print Fibonacci series for given count. (start with 0 and 1, then each next number is sum of previous 2 numbers)
 * Example: java Fibonacci  10
 *                 0 1 1 2 3 5 8 13 21 34

           Compute factorial of a given number (n!). Use Recursion.
Example: java Factorial 6
    	720
 * @author Jagadesh Babu Munta
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int f = 5;
		if (args.length>0) {
			f = Integer.parseInt(args[0]);
		}
		System.out.println(f+"! = "+factorial(f));
		
		System.out.println(f+"th finonacci number = "+fibonacci(f));
		
		printTower(f);

	}
	
	/*
	 *  Base : f(1) = 1
	 *  f! = fx(f-1)!
	 *  
	 * f! = fx(f-1)x(f-2)x(f-3)..x1
	 */
	public static int factorial(int f) {
		if (f==1) {
			return 1;
		} else {
			return f*factorial(f-1);
		}
		
	}
	
	/*
	 * F(0) = 0, F(1) = 1
	 *  F(n) = F(n-1)+F(n-2)
	 * 0 1 1 2 3 5 ... 
	 * 
	 */
	public static int fibonacci(int n) {
		if (n==0) {
			return 0;
		} else if (n==1) {
			return 1;
		} else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	public static void printTower(int n) {
		if (n==1) {
			System.out.println("*");
			return;
		} else {
			for (int i=0;i<n;i++) {
				System.out.print("*");				
			}
			System.out.println("");				
			printTower(n-1);
		}
	}

}

