package com.selenium.demo4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MortgagecalculatorPage {

	private WebDriver driver;
	private Wait<WebDriver> fluentWait;
	
	@FindBy(css=".cal-left-box input[tabindex='1']")
	private WebElement homeValueInput;
	
	@FindBy(css=".cal-left-box input[tabindex='2']")
	private WebElement loanAmountInput;
	
	@FindBy(css=".cal-left-box input[tabindex='3']")
	private WebElement interestRateInput;
	
	@FindBy(css=".cal-left-box input[type='submit']")
	private WebElement submitButton;
	
	@FindBy(css=".repayment-block.biweekly-outer > div.rw-box:nth-child(1) > div.left-cell > h3")
	private WebElement monthlyPaymentText;

	public MortgagecalculatorPage(WebDriver driver) {
		this.driver = driver;		
		
		fluentWait = new FluentWait<WebDriver>(driver) .withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS) .ignoring(NoSuchElementException.class);
		
		PageFactory.initElements(driver, this);
	}
	
	public String calculate(String homeValue, String loadAmountValue, String interestRateValue) {
		String result = "";
		
		homeValueInput.clear();
		homeValueInput.sendKeys(homeValue);
		
		loanAmountInput.clear();
		loanAmountInput.sendKeys(loadAmountValue);
		
		interestRateInput.clear();
		interestRateInput.sendKeys(interestRateValue);
		
		submitButton.click();
		
		result = monthlyPaymentText.getText();
		
		return result;
	}
}
