package com.everydayon;

/**
* 553.	Reverse echo or reverse the given input string.
Example: java ReverseEcho Programming is Fun if you get it! Else it is headache!!
    !!ehcadaeh si ti eslE !ti teg uoy fi nuF si gnimmargorP

 * Reverse a String with and without using inbuilt java funtions.
 * 
 * @author jagadeshmunta
 *
 */
public class ReverseEcho {
	
	public static void main(String [] args) {
		String input = "Programming is Fun if you get it! Else it is headache!!";
		System.out.println(input + "-->");
		System.out.println(reverse(input));
		System.out.println(inReverse(input));
	}
	
	/**
	 * Reverse a given string
	 * @param s
	 * @return
	 */
	public static String reverse(String s) {
		int n = s.length();
		char [] chars = new char[n];
		s.getChars(0, n, chars, 0);
		char t;
		for (int i=0; i< n/2; i++) {
			t = chars[i];
			chars[i] = chars[n-i-1];
			chars[n-i-1] = t;
		}
		return new String(chars);
	}
	
	/**
	 * Using inbuilt
	 * @param s
	 * @return
	 */
	public static String inReverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}

