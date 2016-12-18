
package com.everydayon;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/**
* 570.	Write a simple selenium test to check the facebook login.
* @author Jagadesh Babu Munta
*/

public class SampleFBLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSampleFBLogin() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(“youremailid”);
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys(“xxxx”);
    driver.findElement(By.id("u_0_n")).click();
    assertEquals("Update Status", driver.findElement(By.cssSelector("span.uiIconText._51z7")).getText());
    assertEquals("Trending", driver.findElement(By.id("u_0_1r")).getText());
    assertEquals(“Name”, driver.findElement(By.cssSelector("span._2dpb")).getText());
    driver.findElement(By.cssSelector("div.linkWrap.hasCount > span")).click();
    driver.findElement(By.id("userNavigationLabel")).click();
    driver.findElement(By.cssSelector("input.uiLinkButtonInput")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

