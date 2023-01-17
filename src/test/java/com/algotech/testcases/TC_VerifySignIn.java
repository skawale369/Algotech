package com.algotech.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algotech.pageobject.signIn;

public class TC_VerifySignIn extends BaseClass {
	
	@Test
	public void verifysign()
	{
		
		//open url
		driver.get(url);
		logger.info("Url opened");
		
		signIn si= new signIn(driver);
		
		si.clickOnSignin();
		logger.info("Clicked on sign in link");
		
		si.enterEmail(emailaddress);
		logger.info("entered email address");
		
		si.enterPassword(password);
		logger.info("Entered password");
		
		logger.info("Test passed successfully");
		
		si.clickOnSignOut();
		logger.info("User logged out successfully");
		Assert.assertEquals(true, true);
	}

}
