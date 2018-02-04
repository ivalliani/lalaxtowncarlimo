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
		home.Clickroundlocal();
		
		
		String text = home.pagetext();
		
		if (text.contains("Round trip local only"))
		{
			System.out.println("Round Trip Local Only has been verified");
			logger.log(LogStatus.PASS, "Round Trip Local Only has been Verified");
		}
		
		else
		{
			System.out.println("The Round Trip Local Only is  Not Verified");
			logger.log(LogStatus.FAIL, "Round Trip Local Only is Note Verified");
			logger.log(LogStatus.INFO, "Round Trip Local Only is Not Verified");
		}
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Round Trip Local Only")));
		
		
		driver.findElement(By.xpath(".//*[@id='wrap']/nav/ul/li[1]/a")).click();
		
		home.onewaytoairport(DataProviderFactory.getExcel().getData(0, 0, 1));
		
		String toairporttext = home.pagetext();
		
		if (toairporttext.contains("One way trip to Airport"))
		{
			System.out.println("One Way Trip to Airport has been verified");
			logger.log(LogStatus.PASS, "One Way Trip to Airport has been Verified");
		}
		
		else
		{
			System.out.println("One Way Trip to Airport is  Not Verified");
			logger.log(LogStatus.FAIL, "One Way Trip to Airport is Note Verified");
			logger.log(LogStatus.INFO, "One Way Trip to Airport is Not Verified");
		}
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "One Way Trip to Airport")));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.findElement(By.xpath(".//*[@id='wrap']/nav/ul/li[1]/a")).click();
		
		home.onewayfromairport(DataProviderFactory.getExcel().getData(0, 0, 2));
		
		String fromairporttext = home.pagetext();
		
		if (fromairporttext.contains("One way trip from Airport"))
		{
			System.out.println("One Way Trip from Airport has been verified");
			logger.log(LogStatus.PASS, "One Way Trip from Airport has been Verified");
		}
		
		else
		{
			System.out.println("One Way Trip from Airport is  Not Verified");
			logger.log(LogStatus.FAIL, "One Way Trip from Airport is Note Verified");
			logger.log(LogStatus.INFO, "One Way Trip from Airport is Not Verified");
		}
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "One Way Trip from Airport")));
		
		
		
		
		
		
		
		report.endTest(logger);
		report.flush();
		
		BrowserFactory.closeBrowser(driver);
	}
}
