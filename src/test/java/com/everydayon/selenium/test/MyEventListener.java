/**
 * File: MyEventListener.java
 */
package com.everydayon.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Event listener - selenium
 * @author Jagadesh Babu Munta
 *
 */
public class MyEventListener implements WebDriverEventListener{

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigation to "+url);
		if (url.contains("youtube.com")) {
			System.out.println("WARNING::No youtube please! redirecting to seleniumhq.org");
			driver.navigate().to("http://www.seleniumhq.org");
		} else if (url.contains("facebook.com")) {
			System.out.println("WARNING::No facebook allowed! Redirecting to linkedin.com");
			driver.navigate().to("http://www.linkedin.com");
		} 
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigation to "+url);				
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before navigation back...");		
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After navigation back...");				
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before navigation forward...");		
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After navigation forward...");		
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		//element.xxx()
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception raised..."+throwable.getMessage());		
		
	}


}

