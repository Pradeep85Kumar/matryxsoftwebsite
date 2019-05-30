package com.matryxsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.WrapperActionFunction;

public class MatryxsoftHomePage

   {	WebDriver driver;
	
   public MatryxsoftHomePage( WebDriver ldriver)
   {
	 		
	   this.driver= ldriver;
   }
   
	@FindBy(name="your-firstname") 
	WebElement firstname;
	
	@FindBy(name="your-lastname")
	WebElement lastname;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/main/div/section/div/div/div/div/div/div/div[2]/div/code/form/p[1]/label[3]/span/input")
	WebElement email;
	
	@FindBy(name="your-contact")
	WebElement contact;
	
	@FindBy(name="your-company")
	WebElement company;
	
	@FindBy(name="your-message")
	WebElement message;

	@FindBy(how=How.XPATH,using="/html/body/div[1]/main/div/section/div/div/div/div/div/div/div[2]/div/code/form/p[2]/input")
	WebElement submitBtn;
	
	public void adddetails(String fname, String lname, String mail, String scontact, String companyname, String smessage)
	
	{
		  
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		contact.sendKeys(scontact);
		company.sendKeys(companyname);
		message.sendKeys(smessage);
		submitBtn.click();
		
			
		
	}
	
}
