package com.algotech.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.algotech.utilities.ReadConfig;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	public String emailaddress = readconfig.getEmail() ;
	String password = readconfig.getPassword();
	
	@BeforeClass
	public void setup()
	{
		
		String browser="chrome";
		
		switch(browser)
		{
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
			default:
				driver=null;
				break;
		}
		
		//implicit wait of 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		//for logging
				logger = LogManager.getLogger("AlgoTech");
	}
	
	
	@AfterClass
	public void teardown() 
	{
	   driver.close();
	   driver.quit();
	}

	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
	
	
}
