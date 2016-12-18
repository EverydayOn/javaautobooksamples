package com.everydayon;

/**
 * 559.	Write a program to compute initials from your full name.
	Example: java NameInitial “Jagadesh Munta”
	Initial is “JM”

 * compute initials from your full name.
 * 	Example: java NameInitial “Jagadesh Munta”
 *  Initial is “JM”
 *  
 * @author jagadeshmunta
 *
 */
public class NameInitials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "Jagadesh Munta";
		
		if (args.length>0){
			input = args[0];
		}
		System.out.println(input + "-->");
		System.out.println(getInitials(input));	

	}
	
	/**
	 * Get name initials
	 * 
	 * @param name
	 * @return
	 */
	public static String getInitials(String name) {
		String s = name.trim().toUpperCase();
		char [] chars = s.toCharArray();
		int beginIndex = s.lastIndexOf(' ');
		return chars[0]+""+chars[beginIndex+1];
	}

}

