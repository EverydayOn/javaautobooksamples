/**
●	File: AllLinks.java
*/
package com.everydayon.selenium.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

/**
 * 573.	Write a sample code to show navigation of different links using the selenium webdriver.
 * Description: Find all links
 *    
 * @author Jagadesh Babu Munta
 *
 */
public class AllLinks {

	private WebDriver driver = null;

	private String browser = null;
	private static final String BROWSER_PROPERTIES = "browsertesting.properties";
	private static final int WAIT_TIME = 10;
	
	@Factory(dataProviderClass=com.everydayon.selenium.test.TestDataProvider.class,
			dataProvider="testDataProvider")
	public AllLinks(String browser) {
		this.browser = browser;
		System.out.println("Running with browser="+browser);
	}

	
	@BeforeClass
	public void beforeClass() throws Exception{
		// Create the driver
		if ("firefox".equals(browser)) {			
			driver = new FirefoxDriver();
			// Read properties			
			/*Properties p = new Properties();
			//p.load(new FileReader(new File(BROWSER_PROPERTIES)));
			p.load(this.getClass().getResourceAsStream(BROWSER_PROPERTIES));
			String pName = p.getProperty("firefox.profile", "default");
			System.out.println("Using the profile = "+pName);
			
			// Use the profile
			ProfilesIni profilesIni = new ProfilesIni();			
			FirefoxProfile profile = profilesIni.getProfile(pName);						
			driver = new FirefoxDriver(profile);			
			*/
		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\seleniumdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("ie".equals(browser)) {
			System.setProperty("webdriver.ie.driver", 
					"C:\\seleniumdrivers\\IEDriverServer.exe");
			DesiredCapabilities caps = new DesiredCapabilities().internetExplorer();
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("draggable", true);
			caps.setCapability("requireWindowFocus", true);			
			driver = new InternetExplorerDriver(caps);
		} else if ("safari".equals(browser)) {
			driver = new SafariDriver();
		} else if ("opera".equals(browser)) {
			driver = new OperaDriver();
		} else if ("htmlunit".equals(browser)) {
			driver = new HtmlUnitDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		//Add implicitly wait
		System.out.println("Wait time (implicit wait) ="+WAIT_TIME);
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); //maximize the window
		
		//Load the URL
		//driver.navigate().to(url);
		//driver.get(url);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test(dataProvider="testData1", enabled=true)
	public void test1(String url1) {
		//Load the URL
		driver.navigate().to(url1);
		// Find <a> elements
		
		List<WebElement> links = driver.findElements(By.cssSelector("* [href]"));
		System.out.println(driver.getCurrentUrl()+"-->"+links.size());
		
		Iterator<WebElement> link = links.iterator();
		int totalLinks = links.size();
		for(WebElement e: links) {
			
			System.out.println("<"+e.getTagName()+">:"+e.getText()+"("+e.getAttribute("href")+")");
			visitLink(e);
			/*
			if (! "".equals(e.getText())) {
				try {
					e.click();
					links = driver.findElements(By.cssSelector("* [href]"));
				}catch (StaleElementReferenceException sre) {
					links = driver.findElements(By.cssSelector("* [href]"));
				}
				totalLinks+= links.size();
				System.out.println(driver.getCurrentUrl()+"-->"+links.size());
			}
			
			try {
				links = driver.findElements(By.cssSelector("* [href]"));
			}catch (StaleElementReferenceException sre) {
				links = driver.findElements(By.cssSelector("* [href]"));
			}*/
		}
		System.out.println("Grand Total #of Links="+totalLinks);
	}

	/*
	 * Visit a link
	 */
	private void visitLink(WebElement e) {
		if ("".equals(e.getText())) {
			return;
		}
		List<WebElement> links;
		try {
			System.out.println("Before click(): <"+e.getTagName()+">: LinkText="+e.getText()+"; Link="+e.getAttribute("href"));
			if (e.getAttribute("href").contains("#")) {
				System.out.println("Skip # link");
				return;
			} else {
				System.out.println("Clicking link");
				e.click();
			}
		}catch (StaleElementReferenceException sre) {
			System.out.println("Statelement at "+e.getText());
			links = driver.findElements(By.cssSelector("* [href]"));
		}
		
		 links = driver.findElements(By.cssSelector("* [href]"));
		System.out.println(driver.getCurrentUrl()+"-->"+links.size());
		for (WebElement e1: links) {
			visitLink(e1);
		}
		
	}
	
	@DataProvider
	public Object[][] testData1() {
		//return new Object[][]{ {"http://www.nlsinc.com"},{"http://www.sjsu.edu"},{"http://www.yahoo.com"},{"http://www.google.com"},{"http://www.monster.com"}};
		return new Object[][]{ {"http://www.stanford.edu"}};
		
	}

	@DataProvider
	public Object[][] testData2() {
		//return new Object[][]{ {200, 10},{300,50},{100,500}};
		return new Object[][]{ {200, 10}};
	}
	
	/* Take snapshot 
	 */
	@AfterMethod (alwaysRun=true)
	public void catchFailure(ITestResult result) {
		String dateSuffix = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(
				Calendar.getInstance().getTime()).toString();
		String methodName = result.getName();
		if (!result.isSuccess()) {
			System.out.println("Taking screentshot.../failed_screens"+File.separator+methodName+"-"+dateSuffix+".png");

			TakesScreenshot screenshot = (TakesScreenshot)driver;
			//assertNotNull(screenshot,"Can't get TakesScreenshot object from driver!"+screenshot);
			if (screenshot==null) {
				return;
			}
			File srcFile = 
					screenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("failed_screens"+File.separator+methodName+"-"+dateSuffix+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
				org.testng.Reporter.log(destFile.getCanonicalPath(),true);
			} catch (IOException ioe) {
				System.out.println("Exception while creating the snapshot file!");
			}
			
					
		}
	}

}


