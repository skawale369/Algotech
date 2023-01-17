package com.algotech.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class signIn {
//CCreate object of Webdriver
	WebDriver ldriver;

public signIn(WebDriver rdriver)
{
	ldriver=rdriver;
	
	PageFactory.initElements(rdriver, this);

}

//identify web elements
@FindBy(linkText = "Signup / Login")
WebElement signin;


@FindBy(xpath = "(//input[@placeholder=\"Email Address\"])[1]")
 WebElement EmailAddress;

@FindBy(xpath = "(//input[@placeholder=\"Password\"])[1]")
 WebElement password;

@FindBy(xpath = "(//button[@type=\"submit\"])[1]")
WebElement login;

@FindBy(xpath = "//a[text()=\" Logout\"]")
WebElement  Logout;

//identify action on web element

public void clickOnSignin()
{
	signin.click();
}

public void enterEmail(String emailaddress)
{
	 EmailAddress.click();
	 EmailAddress.sendKeys(emailaddress);
}

public void enterPassword(String Password)
{
	password.click();
	password.sendKeys(Password);
}

public void clickonLogin()
{
	login.click();
	
}

public void clickOnSignOut()
{
	
	Logout.click();
	
}

}
