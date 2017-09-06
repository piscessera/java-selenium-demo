package com.selenium.demo4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class AutomateSample1 {
	public static void main(String[] args) throws Exception {
		System.out.println("Start..");
		WebDriver driver = new HtmlUnitDriver();
		
		driver.navigate().to("http://www.mortgagecalculator.org");
		
		MortgagecalculatorPage page = new MortgagecalculatorPage(driver);
		PageFactory.initElements(driver, page);
		
		// Automate with sample data
		String excelReadPath = "data/mc-TestPlan.xlsx";
		String excelWritePath = "data/mc-TestPlan-Result.xlsx";

		ReadWriteExcel g = new ReadWriteExcel();
		g.xlRead(excelReadPath, 0);

		for (int i = 1; i < g.xRows; i++) {
			String homeValue = "";
			String loadValue = "";
			String interestRate = "";
			String expectedResult = "";
			
			for (int j = 0; j < g.xCols; j++) {
				switch (j) {
				case 0: // home value
					homeValue = g.xData[i][j];
					break;
				case 1: // load value
					loadValue = g.xData[i][j];
					break;
				case 2: // interest rate
					interestRate = g.xData[i][j];
					break;
				case 3: // expected result
					// clean text
					expectedResult = g.xData[i][j].replaceAll(",", "").trim();
					break;
				}
			}
			
			// get actual result with substring 1
			// substring 1 = get text from index = 1
			// eg: $1234.12
			// -> substring(1) then result = 1234.12
			String actualResult = page.calculate(homeValue, loadValue, interestRate).substring(1);
			String verify = "";
			
			// clean text
			actualResult = actualResult.replaceAll(",", "").trim();
			
			verify = verify(expectedResult, actualResult);
			
			g.xData[i][4] = verify;
		}		
		
		g.xlwrite(excelWritePath, g.xData);
		
		driver.close();
		System.out.println("Done..");
	}

	private static String verify(String expectedResult, String actualResult) {
		System.out.println("Verify: " + expectedResult + "," + actualResult);
		String verify;
		if (expectedResult.equals(actualResult)) {
			verify = "Pass";
		} else {
			verify = "Fail";
		}
		return verify;
	}
}
