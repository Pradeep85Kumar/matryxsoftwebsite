package com.matryxsoft;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MatryxsoftHomePage {
	
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

	@FindBy(how=How.XPATH,using="/html/body/div[1]/main/div/section/div/div/div/div/div/div/div[2]/div/code/form/p[3]/input")
	WebElement submit_btn;
}
