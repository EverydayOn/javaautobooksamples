package com.everydayon.selenium;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;

/**
 * 572.	Write a selenium program to show remote grid testing. Also, capture the events.
 * Description: Listeners
 *   
 *    
 * @author Jagadesh Babu Munta
 *
 */
public class RemoteTest {

	private WebDriver driver = null;
	private DesiredCapabilities caps = null;
	private EventFiringWebDriver  efdriver = null;
	private String url1 = "http://www.facebook.com"; 
	private String url2 = "http://www.youtube.com"; 
	private String url3 = "http://www.google.com"; 

	//private String url = "http://jqueryui.com/draggable"; //"http://html5demos.com/drag";
	private String browser = null;
	private static final String BROWSER_PROPERTIES = "browsertesting.properties";
	private static final int WAIT_TIME = 10;
	private static final String HUB_URL = "http://localhost:4444/wd/hub";
	
	@Factory(dataProviderClass=com.everydayon.selenium.test.TestDataProvider.class,
			dataProvider="testDataProvider")
	public RemoteTest(String browser) {
		this.browser = browser;
		System.out.println("Running with browser="+browser);
	}

	
	@BeforeClass
	public void beforeClass() throws Exception{
		// Create the driver
		if ("firefox".equals(browser)) {	
			caps = new DesiredCapabilities().firefox();
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
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
			caps = new DesiredCapabilities().chrome();
			caps.setCapability("chrome.binary", 
					"C:\\seleniumdrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", 
					"C:\\seleniumdrivers\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		} else if ("ie".equals(browser)) {
			caps = new DesiredCapabilities().internetExplorer();
			System.setProperty("webdriver.ie.driver", 
					"C:\\seleniumdrivers\\IEDriverServer.exe");
			caps.setCapability("ie.binary", 
					"C:\\seleniumdrivers\\IEDriverServer.exe");
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("draggable", true);
			caps.setCapability("requireWindowFocus", true);			
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		} else if ("safari".equals(browser)) {
			caps = new DesiredCapabilities().safari();
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		} else if ("opera".equals(browser)) {
			//driver = new OperaDriver();
			caps = new DesiredCapabilities().opera();
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		} else if ("htmlunit".equals(browser)) {
			//driver = new HtmlUnitDriver();
			caps = new DesiredCapabilities().htmlUnit();
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		} else {
			caps = new DesiredCapabilities().firefox();
			driver = new RemoteWebDriver(new URL(HUB_URL),caps);
		}
		
		//Add implicitly wait
		System.out.println("Wait time (implicit wait) ="+WAIT_TIME);
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); //maximize the window

		// Register events
		efdriver = new EventFiringWebDriver(driver);
		WebDriverEventListener eventListener = new MyEventListener();
		efdriver.register(eventListener);
		
		//Load the URL
		//driver.navigate().to(url);
		//driver.get(url);
	}

	@AfterClass
	public void afterClass() {
		efdriver.quit();		
	}

	@Test(enabled=true)
	public void navigateTest1() throws Exception {
		//Load the URL
		efdriver.navigate().to(url1);
		Thread.sleep(100); // to see the screen instead of flash
		efdriver.navigate().to(url2);
		Thread.sleep(100);
		efdriver.navigate().to(url3);
		Thread.sleep(100);
		efdriver.navigate().back(); //to url2
		Thread.sleep(100);
		efdriver.navigate().back(); // to url1
		Thread.sleep(100);
		efdriver.navigate().forward(); // to url2
		Thread.sleep(100);
		efdriver.navigate().forward(); // to url3
		
	}
	
	@DataProvider
	public Object[][] testData1() {
		return new Object[][]{ {"one"},{"two"},{"three"},{"four"},{"five"}};
		
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

