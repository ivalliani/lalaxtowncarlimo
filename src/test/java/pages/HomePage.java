package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import junit.framework.Assert;

public class HomePage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	public HomePage(WebDriver Idriver)
	{
		this.driver=Idriver;
		report = new ExtentReports("./Reports/homepage.html");
		logger = report.startTest("My Homepage Application");
	}
	
	
	
	
	@FindBy (xpath=".//*[@id='qServiceType']") WebElement selectService;
	
	@FindBy (xpath=".//*[@id='Submit5']") WebElement clickroundLocal;
	
	@FindBy (tagName="body") WebElement pagetext;
	
	@FindBy (xpath=".//*[@id='qServiceType']") WebElement selectonewaytoairport;
	
	@FindBy (xpath=".//*[@id='Submit1']") WebElement clickononewayaiprot;
	
	@FindBy (xpath=".//*[@id='Submit2']") WebElement clickononewayfromairport;
	
	@FindBy (xpath="//input[contains(@value,'FromAirport')]") WebElement twowayfromairport;
	
	@FindBy (xpath="//input[contains(@value,'ToAirport')]")WebElement twowaytoairport;
	
	@FindBy (id="qSubmitStep1") WebElement twowayfromAirportclick;
	
	@FindBy (id="Submit6") WebElement hourlyclick;
	
	@FindBy (id="Submit4") WebElement onewaylocalclick;


	
	
	
	
	
	
	
	
	
	
	public void selectServicetype(String servicetype)
	{
		 Select selectservice = new Select (selectService);
			selectservice.selectByValue(servicetype);
	}
	
	
	public void Clickroundlocal()
	{
		clickroundLocal.click();
	}
	
	
	
	public String pagetext() {
		
		String text = driver.findElement(By.tagName("body")).getText();
		return text;
		
		
	}
	
	public void onewaytoairport(String onewayairprot)
	{
		Select onewayaiport = new Select (selectonewaytoairport);
		onewayaiport.selectByValue(onewayairprot);
		clickononewayaiprot.click();
	}
	
	
	public void onewayfromairport(String onewayfromairprot)
	{
		Select onewayaiport = new Select (selectService);
		onewayaiport.selectByValue(onewayfromairprot);
		clickononewayfromairport.click();
		
		
	}
	
	
	public void twowaytoairport(String twowaytoairprot)
	{
		Select twowaytoairports = new Select (selectService);
		twowaytoairports.selectByValue(twowaytoairprot);
		twowaytoairport.click();
		twowayfromAirportclick.click();
	}
	
	
	public void twowayfromairport(String twowayfromairprot)
	{
		Select twowayfromairports = new Select (selectService);
		twowayfromairports.selectByValue(twowayfromairprot);
		twowayfromairport.click();
		twowayfromAirportclick.click();
	}
	
	
	
	public void Hourly(String hourly)
	{
		Select hourlytour = new Select (selectService);
		hourlytour.selectByValue(hourly);
		hourlyclick.click();
	
	}
	
	public void OneWayLocal(String onewaylocal)
	{
		Select OneWayLocal = new Select (selectService);
		OneWayLocal.selectByValue(onewaylocal);
		onewaylocalclick.click();
	
	}
	
	
	
	

	
}


