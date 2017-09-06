package com.sample.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestThaiTicketMouseEvent {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
//		WebDriver driver = new HtmlUnitDriver();
//		System.out.println("Browser: " + driver.getBrowserVersion());
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.thaiticketmajor.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Current URL: " + driver.getCurrentUrl());

//		WebElement buyTicket = driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));
//		buyTicket.click();
		
		WebElement buyTicket = driver.findElement(By.cssSelector(".btn-container-white li:first-child a"));
		buyTicket.click();
		Thread.sleep(2000);
		
		WebElement mainMenu = driver.findElement(By.cssSelector("#menu-th li:first-child"));
		WebElement concertMenu = driver.findElement(By.cssSelector("#menu-th li:nth-child(3)"));

//		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"menu-th\"]/li[1]"));
//		WebElement concertMenu = driver.findElement(By.xpath("//*[@id=\"menu-th\"]/li[3]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).perform();
		Thread.sleep(2000);
		
		act.moveToElement(concertMenu).perform();
		Thread.sleep(2000);
		
		act.moveByOffset(0, 200).perform();
//		act.moveToElement(concertSubMenu).perform();
		Thread.sleep(2000);
		
		act.click().perform();;
		Thread.sleep(2000);
		
		driver.close();
		System.out.println("=================");
		System.out.println("Finish!");
	}
}
