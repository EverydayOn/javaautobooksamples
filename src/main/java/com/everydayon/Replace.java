package com.everydayon;

/**
* 555.	Write a program to replace a given from word to a word in a string
	Example: java Replace “I love Java” “love” “and”
	I and Java

 * @author jagadeshmunta
 *
 */
public class Replace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "I Love Java";
		String from = "Love";
		String to = "and";
		if (args.length==3){
			input = args[0];
			from = args[1];
			to = args[2];
		}
		
		System.out.println(input + "-->");
		System.out.println(replace(input,from,to));	

	}
	
	/**
	 * Return new string after replacing the original with to at from word.
	 * @param orig
	 * @param from
	 * @param to
	 * @return
	 */
	public static String replace(String orig, String from, String to) {
		String [] words = orig.split(" ");
		StringBuilder sb = new StringBuilder();
		String w = null;
		for (int i=0; i<words.length; i++) {
			if (words[i].equals(from)) {
				w = to;
			} else {
				w = words[i];
			}
			if (i!=words.length-1) {
				sb.append(w+" ");
			} else {
				sb.append(w);
			}
			
		}
		return sb.toString();
	}

}

