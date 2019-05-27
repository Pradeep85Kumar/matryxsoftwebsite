package com.matryxsoft.website.matryxsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddDetailsToRequestForTrial

{
	WebDriver driver;

	By firstname = By.name("your-firstname");
	By lastname = By.name("your-lastname");
	By email = By.name("your-email");
	By contact = By.name("your-contact");
	By company = By.name("your-company");
	By message = By.name("your-message");
	By submitBtn = By
			.xpath("/html/body/div[1]/main/div/section/div/div/div/div/div/div/div[2]/div/code/form/p[3]/input");

	public AddDetailsToRequestForTrial(WebDriver driver) {
		this.driver = driver;
	}

	public void typefirstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}

	public void typelastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}

	public void typeemail(String smail) {
		driver.findElement(email).sendKeys(smail);
	}

	public void typecontact(String mobileno) {
		driver.findElement(contact).sendKeys(mobileno);
	}

	public void typecompany(String scompany) {
		driver.findElement(company).sendKeys(scompany);
	}

	public void typemessage(String smessage) {
		driver.findElement(message).sendKeys(smessage);
	}

}
