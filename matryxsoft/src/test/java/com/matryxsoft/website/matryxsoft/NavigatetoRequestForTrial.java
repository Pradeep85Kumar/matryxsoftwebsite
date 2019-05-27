package com.matryxsoft.website.matryxsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Utility.WrapperActionFunction;


public class NavigatetoRequestForTrial extends WrapperActionFunction {
	@Test
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
		wo.waitInSeconds(10);
		
	}
	
	public void verifyAddDetailsToRFT()

	{
		AddDetailsToRequestForTrial AddDetails = new AddDetailsToRequestForTrial(driver);
		AddDetails.typefirstname("pradeep");
		AddDetails.typelastname("kumar");
		AddDetails.typeemail("pradeep@matryxsoft.com");
		AddDetails.typecontact("9886770376");
		AddDetails.typecompany("matryxsofttechllp");
		AddDetails.typemessage("This is for testing");

	}

}
