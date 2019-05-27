package irctc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.WrapperActionFunction;

public class InvokeAllBrowsers extends WrapperActionFunction {
	public static void main(String[] args) throws Exception {
		WrapperActionFunction wo = new WrapperActionFunction();

		WebDriver driver = wo.InvokeBrowser("firefox");
		wo.waitInSeconds(10);
		driver.manage().window().maximize();
		wo.navigateToURL(driver, "https://www.matryxsoft.com");
		wo.waitInSeconds(10);
		WebElement element = driver.findElement(By.linkText("Contact"));
		
		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		driver.findElement(By.id("menu-item-440")).click();
				
		
	}

}
