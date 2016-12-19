package com.everydayon;

/**
* 560.	Print prime numbers between 2 given numbers and also total number of primes found.Also write if those given numbers also prime or not.  See primes at http://primes.utm.edu/
Example: java com.everydayon.PrimeNumber 2 500
Prime numbers...
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127 131 137 139 149 151 157 1
63 167 173 179 181 191 193 197 199 211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313 317 331 3
37 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439 443 449 457 461 463 467 479 487 491 499
Total number of primes found=95

 Is 2 prime?true

 Is 500 prime?false

 * @author Jagadesh Babu Munta
 *
 */
public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("\nTotal number of primes found="+printPrimes(Integer.parseInt(args[0])));
		System.out.println("\nTotal number of primes found="+printPrimes(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		System.out.println("\n Is "+args[0] +" prime?"+isPrime(Integer.parseInt(args[0])));
		System.out.println("\n Is "+args[1] +" prime?"+isPrime(Integer.parseInt(args[1])));
	}

	/*
	 * Print primes within a given number
	 */
	public static int printPrimes(int end) {
		System.out.println("Prime numbers...");
		int count = 0;
		boolean prime = false;
		 for (int i=2;i<end;i++) {
			 prime = true;
			 for (int j=2;j<i;j++) {
				 if (i%j==0) {
					 prime = false;
				 }
			 }
			 
			 if (prime) {
				 System.out.print(i+" ");
				 count++;
			 }
		 }
		 return count;
	}

	/*
	 * Print primes with between 2 numbers
	 */
	public static int printPrimes(int start, int end) {
		System.out.println("Prime numbers...");
		int count = 0;
		boolean prime = false;
		 for (int i=start;i<end;i++) {
			 prime = true;
			 for (int j=2;j<i;j++) {
				 if (i%j==0) {
					 prime = false;
				 }
			 }
			 
			 if (prime) {
				 System.out.print(i+" ");
				 count++;
			 }
		 }
		 return count;
	}
	
	/*
	 * Check if a given number is prime or not
	 */
	public static boolean isPrime(int number) {
		 boolean prime = true;
		 for (int j=2;j<number;j++) {
			 if (number%j==0) {
				 prime = false;
			 }
		 }
		return prime;
	}
	
}

