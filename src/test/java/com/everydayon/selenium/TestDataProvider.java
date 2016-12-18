/**
 * File: TestDataProvider.java
 */
package com.everydayon.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * @author Jagadesh Babu Munta
 *
 */
public class TestDataProvider {

	@DataProvider
	public static Iterator<Object[]> testDataProvider(ITestContext context) {
		List<Object[]> data = new ArrayList<Object[]>();
		//data.add(new Object[]{"firefox"});
		data.add(new Object[]{"chrome"});
		//data.add(new Object[]{"ie"});
		//data.add(new Object[]{"opera"});
		//data.add(new Object[]{"safari"});
		//data.add(new Object[]{"htmlunit"});
		return data.iterator();
	}

}
