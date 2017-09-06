package com.sample.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestKaideeTagElement {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
//		WebDriver driver = new HtmlUnitDriver();
//		System.out.println("Browser: " + driver.getBrowserVersion());
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.kaidee.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Current URL: " + driver.getCurrentUrl());

		driver.findElement(By.cssSelector(".home-buy-button")).click();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		// find element that id = main
		WebElement mainElement = driver.findElement(By.cssSelector("#main"));
		// find li element in element before (id = main)
		List<WebElement> liElements = mainElement.findElements(By.cssSelector("li"));
		
		for (WebElement li : liElements) {
			if ("การศึกษา".equals(li.getText())) {
				String href = li.findElement(By.cssSelector("a")).getAttribute("href");
				System.out.println("click href: " + href);
				li.click();
				break;
			}
		}

		System.out.println("=================");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		WebElement contentElement = driver.findElement(By.cssSelector("#endless-container"));
		List<WebElement> aElements = contentElement.findElements(By.cssSelector("a"));
		
		aElements.forEach(a -> {
			// display text & href
			System.out.println("Text: " + a.getText());
			System.out.println("Href: " + a.getAttribute("href"));
		});

		driver.close();
		System.out.println("=================");
		System.out.println("Finish!");
	}
}
