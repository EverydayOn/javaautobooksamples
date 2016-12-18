package com.everydayon;

/**
* 554.	Reverse words of the given input string
	Example: java ReverseWord “I Love Java”   
                Java Love I

 * Reverse words
 * 
 * @author jagadesh munta
 *
 */

public class ReverseWords {
	
	public static void main(String [] args) {
		String input = null;
		if (args.length>0){
			input = args[0];
		}
		else {
			input = "I Love Java";
		}
		System.out.println(input + "-->");
		System.out.println(reverseWords(input));	
	}
	
	/**
	 * Reverse words
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		String [] words = s.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for (int i=words.length-1; i>=0; i--) {
			if (i!= 0) {
				sb.append(words[i]+" ");
			} else {
				sb.append(words[i]);
			}
		}
		return sb.toString();
	}

}

