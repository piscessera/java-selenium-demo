package com.sample.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestWongnaiSelectWindows {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
//		WebDriver driver = new HtmlUnitDriver();
//		System.out.println("Browser: " + driver.getBrowserVersion());
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.wongnai.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println("Current URL: " + driver.getCurrentUrl());

		// close login modal
		try {
			WebElement loginModal = driver.findElement(By.cssSelector("#normal-priority-modal .ReactModalPortal [aria-label='LogInModal']"));
			if (loginModal.isDisplayed()) {
				System.out.println("close login dialog");
				loginModal.findElement(By.cssSelector("span[icon='close']")).click();
			} else {
				System.out.println("login dialog is not displayed");
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element not found: login dialog");
		}
		
		try {
			// close login footer
			WebElement footerLoginModal = driver.findElement(By.cssSelector("div > div > span[icon='gray-close']"));
			if (footerLoginModal.isDisplayed()) {
				System.out.println("close footer login dialog");
				footerLoginModal.click();
			} else {
				System.out.println("footer login dialog is not displayed");
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element not found: footer login");
		}		
		
		// click target city
		List<WebElement> targetCity = driver.findElements(By.cssSelector("[data-reactid='101'] a"));
		for (WebElement a : targetCity) {
			if ("เชียงใหม่".equals(a.getText())) {
				System.out.println(a.getText());
				a.click();
				break;
			}
		}
		
		// click target category
		WebElement categoryContent = driver.findElement(By.cssSelector(".content[data-reactid='92']"));
		List<WebElement> categoryItem = categoryContent.findElements(By.cssSelector("[data-reactid='291'] li"));
		for (WebElement li : categoryItem) {
			if ("ร้านกาแฟ/ชา".equals(li.getText())) {
				System.out.println(li.getText());
				li.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		try {
			WebElement loginModal = driver.findElement(By.cssSelector("#normal-priority-modal .ReactModalPortal [aria-label='LogInModal']"));
			if (loginModal.isDisplayed()) {
				System.out.println("close login dialog");
				loginModal.findElement(By.cssSelector("span[icon='close']")).click();
			} else {
				System.out.println("login dialog is not displayed");
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element not found: login dialog");
		}
		
		WebElement targetContent = driver.findElement(By.cssSelector(".container-fluid > div:nth-child(3) a:first-child"));
		targetContent.click();
		
		Set<String> ids = driver.getWindowHandles();
		
		for(String id : ids) {
			System.out.println(id);
			driver.switchTo().window(id);
		}
		
		driver.close();
		System.out.println("=================");
		System.out.println("Finish!");
	}
}
