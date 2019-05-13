package irctc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.WrapperActionFunction;

public class InvokeAllBrowsers extends WrapperActionFunction{
	public static void main(String[] args) throws Exception {
		WrapperActionFunction wo = new WrapperActionFunction();
	
		WebDriver driver = wo.InvokeBrowser ("firefox");
		wo.waitInSeconds(10);
		wo.navigateToURL(driver, "https://www.irctc.co.in/nget/train-search");
		wo.enterText(driver, "name==q", "India");
		wo.click(driver, "id==lga");
		WebElement webelem = wo.findElement(wo.driver, "xpath==//input[@value='Google Search']");
		wo.clickOnWebElement(webelem);
	}
		
	}
