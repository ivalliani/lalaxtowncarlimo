package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
	
	@FindBy (xpath="//input[contains(@id,'qPickupFive')]") WebElement PickupCity;
	
	@FindBy (id="qDropoffFive") WebElement dropoffCity;
	
	@FindBy (xpath=".//*[@id='Submit5']") WebElement clickNext;
	
@FindBy (xpath=".//*[@id='qPassengerQty']") WebElement selectPassenger;
	
	@FindBy (xpath=".//*[@id='sprytextfield9']/a") WebElement clickDateLink;
	
	@FindBy (xpath=".//*[@id='dp-popup']/div[3]/table/tbody/tr[3]/td[4]") WebElement clickonDate;
	
	@FindBy (xpath=".//*[@id='qPickupHour']") WebElement pickupHour;
	
	@FindBy (xpath=".//*[@id='qPickupMint']") WebElement pickupMinute;
	
	@FindBy (xpath=".//*[@id='qPickupAP']") WebElement pickupAP;
	
	@FindBy (tagName="body") WebElement pagetext;
	
	public void selectServicetype(String servicetype)
	{
		 Select selectservice = new Select (selectService);
			selectservice.selectByValue(servicetype);
	}
	
	public void PickupCity(String Pickup)
	{
		PickupCity.clear();
		PickupCity.sendKeys(Pickup);
	}
	
	public void dropoffCity(String Dropoff)
	{
		dropoffCity.clear();
		dropoffCity.sendKeys(Dropoff);
	}
	
	public void ClickonNext()
	{
		clickNext.click();
	}
	
	public void selectPassengers(String passengers)
	{
		Select passenger = new Select (selectPassenger);
		passenger.selectByValue(passengers);
	}
	
	public void clickDate()
	{
		clickDateLink.click();
	}
	
	public void chooseDate()
	{
		clickonDate.click();
	}
	
	public void selectPickupHour(String Hour)
	{
		pickupHour.sendKeys(Hour);
	}
	
	public void selectPickupMin(String Minute)
	{
		pickupMinute.sendKeys(Minute);
	}

	public void selectPickupAP(String AMPM)
	{
		pickupAP.sendKeys(AMPM);
		
		
	}
	
	public String pagetext() {
		
		String text = driver.findElement(By.tagName("body")).getText();
		return text;
		
		
	}
	
	
	
	
	

	
}


