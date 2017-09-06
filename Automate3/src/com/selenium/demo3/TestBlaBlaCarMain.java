package com.selenium.demo3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBlaBlaCarMain {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.blablacar.co.uk");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println("Current URL: " + driver.getCurrentUrl());

		BlaBlaCarRidePage ridePage = new BlaBlaCarRidePage(driver);
		PageFactory.initElements(driver, ridePage);
		
		String result1 = ridePage.ride("Manchester", "London");
		System.out.println(result1);

		Thread.sleep(2000);
		String result2 = ridePage.ride("London", "Manchester");
		System.out.println(result2);
		
		driver.close();
	}
}
