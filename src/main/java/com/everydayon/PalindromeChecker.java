package com.everydayon;

/**
 * 563.	Write a program to do Palindrome Checker.
 * @author Jagadesh Babu Munta
 * 
 */
public class PalindromeChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "malayalam";

		if (args.length > 0) {

			input = args[0];

		}

		// characters

		char[] outchars = new char[input.length()];
		//char[] outchars = new char[100];
		input.getChars(0, input.length(), outchars, 0);
		char [] outchars1 = outchars.clone();
		// reverse
		System.out.println(input + "; reverse string is ...");
		for (int i = input.length()-1; i >= 0; i--) {
			outchars[input.length()-1-i] = outchars1[i];
		}
		String str = new String(outchars);
		//System.out.println("\n");
		System.out.println("\n" + str);
		if (input.equals(str)) {
			System.out.println(input + " is a palindrome");
		}
		else {
			System.out.println(input + " is not a palindrome");

		}

	}
}

