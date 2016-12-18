package com.everydayon;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 569.	Write a program to demonstrate basic I/O.
 * @author Jagadesh Babu Munta
 *
 */
public class BasicIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char [] inputChars = new char [100];
		InputStreamReader reader = new InputStreamReader(System.in);
		System.out.print("1. Enter input (InputStreamReader):");
		try {
			int l = reader.read(inputChars);
			System.out.println("chars count="+l+","+String.valueOf(inputChars));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("2. Enter input (Scanner) (type 'end' to end) :");
		Scanner scan = new Scanner(System.in);
		while (! scan.hasNext("end")) {
			System.out.println(scan.next());
		}		

		// read from buffer
		System.out.print("3. Enter input (BufferedReader) :");
		readFromBuffer();
		
		// read from console
		System.out.print("4. Reading from Console...");
		readFromConsole();

		// read from file
		System.out.println("5. Reading file....");
		String fileName = System.console().readLine("Enter filename:");
		readFromFile(fileName);

		// write to file
		System.out.println("6. Write to file....");
		writeToFile(fileName);
		
	}

	public static void readFromBuffer() {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = r.readLine();
			System.out.println("Given line input="+line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Read from console
	 */
	public static void readFromConsole() {
		Console c = System.console();
		String username = c.readLine("Enter user name:");
		char [] userpwd1 = null;
		char [] userpwd2 = null;
		boolean matched = false;
		do {
			userpwd1 = c.readPassword("Enter password:");
			userpwd2 = c.readPassword("Enter password again:");
			matched = Arrays.equals(userpwd1, userpwd2);
			if (!matched) {
				System.out.println("Error:: Passwords didn't matched");
			}
		} while (!matched);
		System.out.println("Given Username:"+username +", password:"+String.valueOf(userpwd1));
		
	}
	
	/**
	 * Read from File
	 * @param fileName
	 */
	public static void readFromFile(String fileName) {
		File f = new File(fileName);
		
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(f));
			String line = r.readLine();
			while (line!=null) {
				System.out.println(line);
				line = r.readLine();
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			if (r!=null) { try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			} }
		}
		
	}

	/**
	 * Write to File
	 * @param fileName
	 */
	public static void writeToFile(String fileName) {
		File f = new File(fileName);
		BufferedReader r = null;
		PrintWriter out = null;
		try {
			r = new BufferedReader(new FileReader(f));
			out = new PrintWriter(new FileWriter(f+"_copy"));
			String line = null;
			while ((line = r.readLine())!=null) {
				//System.out.println(line);
				out.println(line);				
			}			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			if (r!=null) {try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			} }
			if (out!=null) {out.close(); }
		}
		
	}
	
}
