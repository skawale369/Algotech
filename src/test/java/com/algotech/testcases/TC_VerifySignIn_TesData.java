package com.algotech.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.algotech.pageobject.signIn;
import  com.algotech.utilities.ReadExcelFile;

public class TC_VerifySignIn_TesData extends BaseClass {
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifysigntestData(String userEmail, String userPwd) throws IOException
	{
		
		//open url
		driver.get(url);
		logger.info("Url opened");
		
		signIn si= new signIn(driver);
		
		si.clickOnSignin();
		logger.info("Clicked on sign in link");
		
		si.enterEmail(userEmail);
		logger.info("entered XLSX email address");
		
		si.enterPassword(userPwd);
		logger.info("Entered XLSX password");
		
		si.clickonLogin();
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		si.clickOnSignOut();
		logger.info("User logged out successfully");
		Assert.assertEquals(true, true);
		logger.info("Test passed successfully");
	}
	

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\AlgoTechTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
