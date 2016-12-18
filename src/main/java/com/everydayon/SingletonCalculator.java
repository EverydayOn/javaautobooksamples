package com.everydayon;

import java.io.ObjectStreamException;

/**
 * 568.	Write a singleton class.
 *
 * @author Jagadesh Babu Munta
 *
 */
public class SingletonCalculator implements java.io.Serializable {
	
	/*
	 * 1. Create a constant singleton object
	 */
	private static final SingletonCalculator SINGLETON_CALCULATOR = new SingletonCalculator();
	private static SingletonCalculator scal = null;
	
	/*
	 * 2. Make default constructor as private so that no object created
	 *   NOTE: This step is mandatory.
	 *   If you create a single object with in constructor (like in 2nd way as below), 
	 *   then it will be in infinite loop as parent's default constructor is called.  
	 */    
	private SingletonCalculator() {	}

	/*
	 * 3. Return the singleton object instance
	 */
	public static SingletonCalculator getInstance() {
		return SINGLETON_CALCULATOR;
	}
	
	/*
	 * 4. To avoid spurious objects and to preserve the singleton property
	 */
	public Object readResolve() throws ObjectStreamException {
		return SINGLETON_CALCULATOR;
	}

	// 2nd way.  to get the singleton instance
	public static synchronized SingletonCalculator getSingleInstance() {
		if (scal==null) {
			scal = new SingletonCalculator();
		}
		return scal;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*** Singleton instance ***");
		System.out.println(" -- 1st way -- ");
		for (int i=0;i<10;i++) {
			System.out.println(SingletonCalculator.getInstance());
		}
		System.out.println(" -- 2nd way -- ");
		for (int i=0;i<10;i++) {
			System.out.println(SingletonCalculator.getSingleInstance());
		}
	}

}

