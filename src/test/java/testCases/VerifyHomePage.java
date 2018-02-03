package testCases;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import utility.Helper;

public class VerifyHomePage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		report = new ExtentReports("./Reports/homepage.html");
		logger=report.startTest("Home Page Report");
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//home.selectServicetype("Round trip local only");
		
		String title = driver.getTitle();
		
		if(title.contains("LAX Town Car Service"))
		{
			logger.log(LogStatus.PASS, "The Title has been verified");
			System.out.println("The Homepage title is "+title);
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "The Home Page")));
			
		}
		else
		{
			logger.log(LogStatus.FAIL, "The title is not verified");
			
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "The Home Page")));
			//logger.addScreenCapture(Helper.captureScreenShots(driver, "The Home page"));
			System.out.println("The title for Homepage is Not Matching");
		}
		
		
		home.selectServicetype(DataProviderFactory.getExcel().getData(0, 0, 0));
		
		home.PickupCity(DataProviderFactory.getExcel().getData(0, 0, 1));
		
		home.dropoffCity(DataProviderFactory.getExcel().getData(0, 0, 2));
		
		home.ClickonNext();
		
		home.selectPassengers(DataProviderFactory.getExcel().getData(0, 1, 0));
		
		
		home.clickDate();
		home.chooseDate();
		
		home.selectPickupHour(DataProviderFactory.getExcel().getData(0, 1, 0));
		
		home.selectPickupMin(DataProviderFactory.getExcel().getData(0, 1, 1));
		
		home.selectPickupAP(DataProviderFactory.getExcel().getData(0, 1, 2));
		
		String RequestTitle = driver.getTitle();
		
		System.out.println("Request a Page Title "+RequestTitle);
		
		logger.log(LogStatus.INFO, "Round Local Trip");
		
		String text = home.pagetext();
		
		if (text.contains("Round trip local only"))
		{
			System.out.println("The Request a Page has been Verified");
			logger.log(LogStatus.PASS, "The Request a Page has been Verified");
		}
		
		else
		{
			System.out.println("The Request page is Not Verified");
			logger.log(LogStatus.FAIL, "The Page is Note Verified");
			logger.log(LogStatus.INFO, "The Request a Page is Not Verified");
		}
		
		
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Round Trip Local")));
		
		report.endTest(logger);
		report.flush();
		
		BrowserFactory.closeBrowser(driver);
	}
}
