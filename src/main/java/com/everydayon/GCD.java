package com.everydayon;

/**
 * 562.	Write a program to calculate GCD.
 * @author Jagadesh Babu Munta
 *
 */
public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length<2) {
			System.out.println("Usage: java com.everydayon.GCD");
			return;
		}
		long gcd = gcd(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		System.out.println("GCD="+gcd);

	}
	
	public static long gcd(int a, int b) {
		if (b==0) {
			return a;
		}
		return gcd(b, a%b);
	}

}
