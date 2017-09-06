package com.sample.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSample2 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://www.calculator.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCalculator() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Gas Mileage Calculator")).click();
		driver.findElement(By.id("uscodreading")).clear();
		driver.findElement(By.id("uscodreading")).sendKeys("12000");
		driver.findElement(By.id("uspodreading")).clear();
		driver.findElement(By.id("uspodreading")).sendKeys("10000");
		driver.findElement(By.id("usgasputin")).clear();
		driver.findElement(By.id("usgasputin")).sendKeys("40");
		driver.findElement(By.id("usgasprice")).clear();
		driver.findElement(By.id("usgasprice")).sendKeys("4.5");
		driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
		try {
			String result = driver.findElement(By.xpath(".//*[@id='content']/font/b")).getText();
			assertEquals("50.00 miles per gallon", result);
//			assertEquals("50.00 miles per gallon", driver.findElement(By.cssSelector("b")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
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
