package com.sample.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlaBlaCarRidePage {

	private WebDriver driver;
//	private WebDriverWait wait;
	private Wait<WebDriver> fluentWait;
	
	@FindBy(id="search_from_name")
	private WebElement rideFromInputElement;
	
	@FindBy(id="search_to_name")
	private WebElement rideToInputElement;
	
	@FindBy(css=".js-trip-search-submit[type='submit']")
	private WebElement rideButtonElement;
	
	@FindBy(css=".trip-search-title-count")
	private WebElement resultElement;
	
	public BlaBlaCarRidePage(WebDriver driver) {
		this.driver = driver;
//		this.wait = new WebDriverWait(this.driver, 10);

		fluentWait = new FluentWait<WebDriver>(driver) .withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		
		PageFactory.initElements(driver, this);
	}
	
	public String ride(String from, String to) {
		String result = "";
		rideFromInputElement.clear();
		rideFromInputElement.sendKeys(from);
		
		rideToInputElement.clear();
		rideToInputElement.sendKeys(to);
		rideButtonElement.click();
		
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(resultElement));
		result = resultElement.getText();
		
		System.out.println("Ride Done");
		return result;
	}
}
