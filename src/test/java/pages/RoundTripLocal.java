package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class RoundTripLocal {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void startBrowser(WebDriver Idriver)
	{
		this.driver=Idriver;
		report = new ExtentReports("./Reports/RoundTripLocal.html");
		logger = report.startTest("Round Trip Local ");
		
	}
	
	@FindBy (xpath=".//*[@id='qPassengerQty']") WebElement selectPassenger;
	
	@FindBy (xpath=".//*[@id='sprytextfield9']/a") WebElement clickDateLink;
	
	@FindBy (xpath=".//*[@id='dp-popup']/div[3]/table/tbody/tr[3]/td[4]") WebElement clickonDate;
	
	@FindBy (xpath=".//*[@id='qPickupHour']") WebElement pickupHour;
	
	@FindBy (xpath=".//*[@id='qPickupMint']") WebElement pickupMinute;
	
	@FindBy (xpath=".//*[@id='qPickupAP']") WebElement pickupAP;
	
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
	

}
