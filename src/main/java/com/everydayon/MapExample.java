package com.everydayon;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
* 564.	Write a program to declare a map, add entries and print the entries.
* @author: jagadesh.munta
*/
public class MapExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		map1();
	}
	public static void map1() {
		System.out.println("*** Hash Map Example ***");
		Map<String, Integer> population = new HashMap<String, Integer>();
		updateMap(population);
		System.out.println("*** Tree Map Example ***");
		Map<String, Integer> population1 = new TreeMap<String, Integer>();
		updateMap(population1);
		System.out.println("*** LinkedHash Map Example ***");
		Map<String, Integer> population2 = new LinkedHashMap<String, Integer>();
		updateMap(population2);				
	}
	
	public static void updateMap(Map<String,Integer> population) {

		population.put("Fremont", 20);
		population.put("San Francisco", 100);
		population.put("Sunnyvale", 10);

		System.out.println(population); // debugging
		Int fremontPop = population.get("Fremont").intValue();
		System.out.println("Fremont population=" + fremontPop);

		Map<String, Integer> calPop = new HashMap<String, Integer>();
		calPop.putAll(population);
		System.out.println(calPop); // debugging


		Set<String> cities = population.keySet();
		Collection<Integer> vals = population.values();

		for (String city : cities) {
			System.out.println(city + "=" + population.get(city));
		}

		long totalPop = 0;
		for (Integer val : vals) {
			totalPop = totalPop + val;
		}
		System.out.println("Total population="+totalPop);
		population.clear();
		System.out.println(population); // debugging
	}
}

