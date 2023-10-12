package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.This;
import utils.Utility;

public class ByjusOnlineLearningProgramPage {
	
	@FindBy (xpath = "(//input[@type='radio'])[1]")
	private WebElement online;
	
	@FindBy (xpath = "//input[@name='name']")
	private WebElement enterNameOfYourChild;
	
	@FindBy (xpath = "//input[@name='mobile']")
	private WebElement enterYourMobileNumber;

	@FindBy (xpath = "//input[@name='email']")
	private WebElement enterYourEmailAddress;
	
	@FindBy (xpath = "//select[@name='state']")
	private WebElement state;
	
	@FindBy (xpath = "//button[text()='Schedule a Free Class']")
	private WebElement continueToSchedule;
	
	@FindBy (xpath = "//a[text()='BTC']")
	private WebElement btc;
	
	@FindBy (xpath = "//a[text()='Tuition in West Zone']")
	private WebElement westZone;
	
	@FindBy (xpath = "//a[text()='Tuition in Maharashtra']")
	private WebElement maharashtra;
	
	@FindBy (xpath = "//a[text()='Tuition in Navi Mumbai']")
	private WebElement naviMumbai;
	
	@FindBy (xpath = "//div[text()='Validate your mobile number']")
	private WebElement mobileNumberValidationWarningMessage;
	
	
	
	
	
	private WebDriver driver;
	
	public ByjusOnlineLearningProgramPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnlineRadioButton()
	{
		online.click();
	}
	
	public void sendChildName() throws EncryptedDocumentException, IOException
	{
		String enterNameOfYourChildData=Utility.getDataFromExcelsheet("Sheet1", 2, 0);
		enterNameOfYourChild.sendKeys(enterNameOfYourChildData);
	}
	
	public void sendMobileNumber() throws EncryptedDocumentException, IOException
	{
		String enterYourMobileNumberData=Utility.getDataFromExcelsheet("Sheet1", 2, 1);
		enterYourMobileNumber.sendKeys(enterYourMobileNumberData);
	}
	
	public void sendEmailAddress() throws EncryptedDocumentException, IOException
	{
		String enterYourEmailAddressData=Utility.getDataFromExcelsheet("Sheet1", 2, 2);
		enterYourEmailAddress.sendKeys(enterYourEmailAddressData);
	}
	
	public void selectState()
	{
		Select select=new Select(state);
		select.selectByVisibleText("Maharashtra");
	}
	
	public void clickContinueToScheduleButton()
	{
		continueToSchedule.click();
	}
	
	public void clickBTC()
	{
		Actions act=new Actions(driver);
		act.moveToElement(btc).perform();
	}
	
	public void clickWesternZone()
	{
		Actions act=new Actions(driver);
		act.moveToElement(westZone).perform();
	}
	
	public void clickMaharashtra()
	{
		Actions act=new Actions(driver);
		act.moveToElement(maharashtra).perform();
	}
	
	public void clickNaviMumbai()
	{
		Actions act=new Actions(driver);
		act.moveToElement(naviMumbai).click().perform();
	}
	
	public boolean validateYourMobileNumberWarningMessage()
	{
		boolean result=mobileNumberValidationWarningMessage.isDisplayed();
		return result;
		
	}
	
	
	
	
	
	
}
