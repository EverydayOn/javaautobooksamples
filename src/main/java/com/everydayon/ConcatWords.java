package com.everydayon;

/**
 * 558.	Write a program to efficiently concatenate given multiple strings into a single string.
	Example: java CatString “Hello” “I know” “Java”
	Hello I know Java
	
 * 
 * @author jagadeshmunta
 *
 */
public class ConcatWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length<0) {
			System.out.println("Please enter words to get a single string");
			return;
		}
		
		System.out.println(concat(args));	

	}
	
	public static String concat(String... words) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<words.length; i++) {
			sb.append(words[i]);
		}
		return sb.toString();
	}
	

}

