package testNG_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BestTutionCenterNearMeInMumbaiPage;
import pages.ByjusOnlineLearningProgramPage;
import utils.Utility;

public class VarifyBookYourFreeSessionField extends Browser{
	
	private WebDriver driver;
	private ByjusOnlineLearningProgramPage byjusOnlineLearningProgramPage;
	private String testID;
	//private BestTutionCenterNearMeInMumbaiPage bestTutionCenterNearMeInMumbaiPage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.contains("Chrome"))
		{
			driver=launchChrome();
		}
		if(browserName.contains("Edge"))
		{
			driver=launchEdge();
		}
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		 byjusOnlineLearningProgramPage=new ByjusOnlineLearningProgramPage(driver);
		// bestTutionCenterNearMeInMumbaiPage=new BestTutionCenterNearMeInMumbaiPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://byjus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}
	
	@Test
	public void varifyBookYourFreeSessionField_T101() throws EncryptedDocumentException, IOException
	{
		testID="T101";
		byjusOnlineLearningProgramPage.clickOnlineRadioButton();
		byjusOnlineLearningProgramPage.sendChildName();
		byjusOnlineLearningProgramPage.sendMobileNumber();
		byjusOnlineLearningProgramPage.sendEmailAddress();
		byjusOnlineLearningProgramPage.selectState();
		byjusOnlineLearningProgramPage.clickContinueToScheduleButton();
		boolean result=byjusOnlineLearningProgramPage.validateYourMobileNumberWarningMessage();
		if(result==true)
		{
			Assert.fail();
		}
		else
		{
			System.out.println("mobile number is valide");
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.getScreenshot(driver, "T101");
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		byjusOnlineLearningProgramPage=null;
		// bestTutionCenterNearMeInMumbaiPage=null;
	}
	
	@AfterTest
	public void AfterTest()
	{
		driver.quit();
		driver=null;
		System.gc();
	}

}
