package com.sample.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAirAsiaGoDatePicker {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
		// WebDriver driver = new HtmlUnitDriver();
		// System.out.println("Browser: " + driver.getBrowserVersion());
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://thailand.airasiago.com/Hotels");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Current URL: " + driver.getCurrentUrl());

		WebElement fromBookingDatePickerInput = driver.findElement(By.cssSelector("#hotel-checkin"));
		WebElement toBookingDatePickerInput = driver.findElement(By.cssSelector("#hotel-checkout"));

		System.out.println("Start from process");
		fromBookingDatePickerInput.click();

		WebElement fromBookingDatePicker = driver.findElement(By.cssSelector("#hotel-checkin-wrapper .datepicker-dropdown"));
		List<WebElement> targetFromDatePickers = fromBookingDatePicker.findElements(By.cssSelector(".datepicker-cal-date"));
		
		for (WebElement datePicker : targetFromDatePickers) {
			if ("12".equals(datePicker.getText())) {
				System.out.println("Date: " + datePicker.getText());
				datePicker.click();
				break;
			}
		}
		
		System.out.println("Start to process");
		toBookingDatePickerInput.click();
		
		WebElement toBookingDatePicker = driver.findElement(By.cssSelector("#hotel-checkout-wrapper .datepicker-dropdown"));
		List<WebElement> targetToDatePickers = toBookingDatePicker.findElements(By.cssSelector(".datepicker-cal-date"));
		
		for (WebElement datePicker : targetToDatePickers) {
			if ("14".equals(datePicker.getText())) {
				System.out.println("Date: " + datePicker.getText());
				datePicker.click();
				break;
			}
		}
		
		driver.close();
		System.out.println("Finish!");
	}

}
