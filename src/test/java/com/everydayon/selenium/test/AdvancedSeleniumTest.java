package com.everydayon.selenium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;
import com.thoughtworks.selenium.DefaultSelenium;

/**
 * 571.	Write sample code for advanced UI Elements using Selenium WebDriver such as Select, Drag-and-drop, Auto suggestion or complete. Also, take the screenshots for failed tests.
 * Description: Advanced UI Elements using Selenium WebDriver
 *   Select, Drag-and-drop, Auto suggestion or complete
 *    
 * @author Jagadesh Babu Munta
 *
 */
public class AdvancedSeleniumTest {

	private WebDriver driver = null;
	private String url1 = "http://html5demos.com/drag";
	private String url2 = "http://jqueryui.com/draggable";
	private String url3 = "http://www.theautomatedtester.co.uk/demo2.html";
	private String url4 = "http://localhost:8000/docs/selenium/dragdrop.html"; //"http://jqueryui.com/droppable";
	private String url5 = "http://localhost:8000/docs/selenium/select.html"; //"http://jqueryui.com/droppable";
	private String url6 = "http://localhost:8000/docs/selenium/autocomplete.html"; 
	private String url7 = "http://www.google.com"; 
	private String url8 = "http://www.monster.com"; 
	private String url9 = "http://www.bing.com"; 

	//private String url = "http://jqueryui.com/draggable"; //"http://html5demos.com/drag";
	private String browser = null;
	private static final String BROWSER_PROPERTIES = "browsertesting.properties";
	private static final int WAIT_TIME = 10;
	
	@Factory(dataProviderClass=com.everydayon.selenium.test.TestDataProvider.class,
			dataProvider="testDataProvider")
	public AdvancedSeleniumTest(String browser) {
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

	@Test(dataProvider="testData1", enabled=false)
	public void dragTest1(String src) {
		//Load the URL
		driver.navigate().to(url1);
		// Get the source element
		WebElement target = driver.findElement(By.id("bin"));
		WebElement source = driver.findElement(By.id(src));
		Actions actions = new Actions(driver);
		Action action = actions.clickAndHold(source).moveToElement(target).release(source).build();
		action.perform();
		//actions.clickAndHold().dragAndDrop(source, target);
		//actions.dragAndDrop(source, target);
		//actions.perform();		
	}

	//@Test(dataProvider="testData2", enabled=true)
	@Test(dataProvider="testData2", enabled=false)
	public void dragTest2(int x, int y) {
		//Load the URL
		driver.navigate().to(url2);
		driver.navigate().to(url1);
		driver.navigate().back();
		System.out.println("Locate element");
		// Get the source element
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement source = 
				new WebDriverWait(driver,WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='draggable']")));
		
		System.out.println("Moving to "+x+","+y);
		Actions actions = new Actions(driver);
		//actions.clickAndHold(source);
		//actions.moveByOffset(x,y);
		//actions.release(source);
		actions.dragAndDropBy(source,x,y);
		actions.build().perform();
		//actions.clickAndHold().dragAndDrop(source, target);
		//actions.dragAndDrop(source, target);
		//actions.perform();		
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	}
	
	@Test (enabled=false)
	public void dragTest3() {
		driver.navigate().to(url3);
		
		WebElement source = driver.findElement(By.className("draggable"));
		WebElement target = driver.findElement(By.className("droppable"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(source)
									.moveToElement(target)
									.release(source)
									.build();
		dragAndDrop.perform();
		
	}

	/*
	 * Test drag and drop
	 */
	@Test (enabled=false)
	public void dragTest4() {
		driver.navigate().to(url4);
		
		//driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		//builder.clickAndHold(source).build().perform();
		Action dragAndDrop = builder.clickAndHold(source)
									.moveToElement(target)
									.release(target)
									.build();
		dragAndDrop.perform();
		builder.dragAndDrop(source, target).build().perform();
				
	}
	
	/*
	 * Test Select
	 */

	@Test (enabled=false)
	public void autoTest5() {
		driver.navigate().to(url5);
		
		//driver.switchTo().frame(0);
		/*WebElement source = driver.findElement(By.id("city"));
		source.click();
		Actions actions = new Actions(driver);
		actions.click(source).keyDown(Keys.ENTER).click().keyDown(Keys.ARROW_DOWN).build().perform();
		*/
        Select selectBox = new Select(driver.findElement(By
                .cssSelector("select#city")));
        // Select 2nd option and select
        selectBox.selectByIndex(2);
        String optionValue = selectBox.getFirstSelectedOption().getText();
        assertEquals("Santa Clara", optionValue);
        // Check all options
        List<String> cityOptions = new ArrayList<String>();
        cityOptions = Arrays.asList("Fremont","Sunnyvale","Santa Clara","Cupertino","Newark");
        List<WebElement> options = selectBox.getOptions();
        for (WebElement option: options ) {
        	System.out.println(option.getText());
        	assertEquals(true,cityOptions.contains(option.getText()),"Expected City");
        }
	}
	
	/*
	 * Test autocomplete
	 */
	@Test (enabled=false)
	public void autoTest6() throws Exception{
		driver.navigate().to(url6);
		
        WebElement tags = driver.findElement(By.cssSelector("#tags"));
        tags.sendKeys("b");
        //Thread.sleep(1000); //wait for 

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> newtags = 
				new WebDriverWait(driver,WAIT_TIME).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[id*=\"ui\"]")));		
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        Thread.sleep(1000); //wait for 1 sec to see on the screen 
        
        newtags = driver.findElements(By.cssSelector("[id*=\"ui\"]"));        
        System.out.println("Size="+newtags.size());
        assertEquals(4, newtags.size());
        for (WebElement newtag: newtags ) {
        	System.out.println("Auto value="+newtag.getText()+";");
        }
		Actions actions = new Actions(driver);
		actions.moveToElement(newtags.get(2)).click().build().perform();
		Thread.sleep(500);
        String sValue = driver.findElement(By.cssSelector("#tags")).getText();
        System.out.println("Selected value="+sValue);
        
        // RC style
		/*DefaultSelenium sel = 
				new WebDriverBackedSelenium(driver,url6);
	    sel.type("//*[@id='tags']", "a");
	    sel.fireEvent("//*[@id='tags']", "keydown");
		*/
	}
	/*
	 * Test autocomplete using google search
	 */
	@Test (enabled=true)
	public void autoTest7() throws Exception{
		driver.navigate().to(url7);
		
        WebElement tags = driver.findElement(By.cssSelector("#gs_htif0.gbqfif"));
        tags = driver.findElement(By.xpath("//*[@id='gs_htif0']|//*[@class='gbqfif']"));
        //tags.sendKeys("selenium");
        tags.sendKeys("Java Jobs in US");
        
        //Thread.sleep(1000); //wait for 

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> newtags = 
				new WebDriverWait(driver,WAIT_TIME).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[id*=\"gsr\"]")));		
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        Thread.sleep(1000); //wait for 1 sec to see on the screen 
        //.//*[@id='gsr']/table/tbody/tr/td[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[1]/span        
        //newtags = driver.findElements(By.cssSelector("[id*=\"gsr\"]"));        
        newtags = driver.findElements(By.xpath("//*[@id='gsr']/table/tbody/tr/td[2]/table/tbody/tr"));        
        System.out.println("Size="+newtags.size());
        for (WebElement newtag: newtags ) {
        	System.out.println("Auto value="+newtag.getText()+";");
        }
		Actions actions = new Actions(driver);
		actions.moveToElement(newtags.get(2)).click().build().perform();
		Thread.sleep(500);
        String sValue = driver.findElement(By.cssSelector("#gs_tti0.gsib_a")).getText();
        System.out.println("Selected value="+sValue);
        
	}

	/*
	 * Test autocomplete using google search
	 */
	@Test (enabled=false)
	public void autoTest8() throws Exception{
		driver.navigate().to(url8);
		
		
        WebElement joinelement = driver.findElement(By.xpath("//*[@id='StaticNav']/li[1]/a"));
		joinelement.click();

        WebElement ziplabel = driver.findElement(By.xpath("//*[@id='form0']/fieldset[1]/fieldset[1]/label"));
        ziplabel.click();
        WebElement zip = driver.findElement(By.cssSelector("#UserEnteredZipName"));
        zip.sendKeys("9453");
        
        //Thread.sleep(1000); //wait for 

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> newtags = 
				new WebDriverWait(driver,WAIT_TIME).until(
						ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@data-id]")));		
		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        Thread.sleep(1000); //wait for 1 sec to see on the screen 
        newtags = driver.findElements(By.xpath("//*[@data-id]"));        
        System.out.println("Size="+newtags.size());
        for (WebElement newtag: newtags ) {
        	System.out.println("Auto value="+newtag.getText()+";");
        }
		Actions actions = new Actions(driver);
		actions.moveToElement(newtags.get(2)).click().build().perform();
		Thread.sleep(500);
        String sValue = driver.findElement(By.cssSelector("#gs_tti0.gsib_a")).getText();
        System.out.println("Selected value="+sValue);
        
	}
	
	@Test(dataProvider="testData3", enabled=false)
	public void navigateUrls(String url) {
		driver.navigate().to(url);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.navigate().back();
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

	@DataProvider
	public Object[][] testData3() {
		return new Object[][]{ {"http://www.google.com"},{"http://www.yahoo.com"},{"http://www.linkedin.com"}, {url8}, {url9}};
		
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

