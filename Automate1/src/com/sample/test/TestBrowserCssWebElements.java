package com.sample.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestBrowserCssWebElements {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		System.out.println("Browser: " + driver.getBrowserVersion());

		driver.navigate().to("https://www.bbc.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Current URL: " + driver.getCurrentUrl());

		List<WebElement> sportContentElements = driver
				.findElements(By.cssSelector(".module--sport li.media-list__item .media__title a"));

		IntStream.range(0, sportContentElements.size()).forEach(index -> {
			WebElement element = sportContentElements.get(index);
			System.out.println("No: " + (index + 1));
			System.out.println("Text: " + element.getText());
			System.out.println("Link: " + element.getAttribute("href"));
			System.out.println("==================");
		});

		driver.close();
		System.out.println("Finish!");
	}
}
