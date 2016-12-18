package com.everydayon;

/**
*556.	Write a program to find how many times a given letter is there in a given string
	Example: java LetterFind “Java is a cross platform” a
	‘a’ found at 4 places.

 * Find how many times a given letter is there in a given string
 * @author jagadeshmunta
 *
 */
public class FindLetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Java is a cross platform";
		String letter = "a";
		if (args.length==2){
			input = args[0];
			letter = args[1];
		}
		char c = (char) letter.getBytes()[0];
		
		System.out.println(input + "-->");
		System.out.println("'"+c +"'"+ " found at "+findLetter(input,c) + "places.");	

	}
	
	/**
	 * Return the number of times character appeared in a string
	 * 
	 * @param orig
	 * @param c
	 * @return
	 */
	public static int findLetter(String orig, char c) {
		int n = orig.length();
		int count = 0;
		char [] chars = new char[n];
		orig.getChars(0, n, chars, 0);
		for (int i=0; i<n; i++) {
			if (chars[i] == c) {
				count++;
			}
		}
		return count;
	}

}

