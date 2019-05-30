package com.matryxsoft.website.matryxsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.matryxsoft.MatryxsoftHomePage;

import Utility.WrapperActionFunction;
import Utility.browserhelper;

public class VerifyAddDetails
{

	@Test
	public void checkfirstname()
	{
		WrapperActionFunction wo = new WrapperActionFunction();
		
		//This will launch browser and specific url
		WebDriver driver= browserhelper.InvokeBrowser("firefox", "https://matryxsoft.com");
		
		//This will click on Contact
		wo.waitInSeconds(10);
		WebElement element = driver.findElement(By.linkText("Contact"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		driver.findElement(By.id("menu-item-440")).click();
		wo.waitInSeconds(10);
		
		
		//Created page object using page factory
		MatryxsoftHomePage HomePage= PageFactory.initElements(driver, MatryxsoftHomePage.class);
		
		//call the method
		HomePage.adddetails("Pradeep", "Kumar","pradeep@matryxsoft.com", "9886770376", "Matryxsoft Tech", "test123");
	}
	
	
}	
