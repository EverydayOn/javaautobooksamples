package com.everydayon;

/**
* 561.	Write Anagram checker. See details and algorithm at URL http://www.codemiles.com/java/java-anagram-t5455.html
Two words or phrases in English are anagrams if their letters, rearranged, are the same. We assume that upper and lower case are indistinguishable, and punctuation and spaces don't count.

Example: java com.everydayon.Anagram "The eyes" "they see"
  Anagram: true
Example: java com.everydayon.Anagram "Funny" "fun"
  Anagram: false

 * See details and algorithm at URL http://www.codemiles.com/java/java-anagram-t5455.html
 * Two words or phrases in English are anagrams if their letters, rearranged, are the same. We assume that upper and lower case are indistinguishable, and punctuation and spaces don't count.
 * Example: java com.everydayon.Anagram "The eyes" "they see"
 * Anagram: true
 * Example: java com.everydayon.Anagram "Funny" "fun"
 * Anagram: false
 *
 * @author jagadeshmunta
 *
 */
public class AnagramChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input1 = "The Eyes";
		String input2 = "They See";
		if (args.length==2){
			input1 = args[0];
			input2 = args[1];
		}
		System.out.println(input1 +" "+ input2 + "-->");
		System.out.println("Anagram: "+isAnagram(input1, input2));	
		

	}
	
	/**
	 * Check if given 2 strings are anagram
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isAnagram(String one, String two) {
		boolean isA = false;
		char [] oneChars = one.trim().toLowerCase().toCharArray();
		String twoS = two.trim().toLowerCase();
		int j = 0;
		for (int i=0; i<oneChars.length; i++) {
			if (oneChars[i]==' ') {
				continue;
			}
			if (twoS.indexOf(oneChars[i])== -1) {
				return false;
			} 
			j++;	
		}
		char[] twoChars = twoS.toCharArray();
		int j1=0;
		for (int i=0; i<twoChars.length; i++) {
			if (twoChars[i]==' ') {
				continue;
			}
			j1++;
		}
		if (j== j1) {
			isA = true;
		}
		return isA;
		
	}

}

