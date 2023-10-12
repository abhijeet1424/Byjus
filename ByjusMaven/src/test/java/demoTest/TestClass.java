package demoTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ByjusOnlineLearningProgramPage;

public class TestClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().window().maximize();
		
		ByjusOnlineLearningProgramPage byjusOnlineLearningProgramPage=new ByjusOnlineLearningProgramPage(driver);
		byjusOnlineLearningProgramPage.clickOnlineRadioButton();
		byjusOnlineLearningProgramPage.sendChildName();
		byjusOnlineLearningProgramPage.sendMobileNumber();
		byjusOnlineLearningProgramPage.sendEmailAddress();
		byjusOnlineLearningProgramPage.selectState();
		byjusOnlineLearningProgramPage.clickContinueToScheduleButton();
		boolean result=byjusOnlineLearningProgramPage.validateYourMobileNumberWarningMessage();
		if(result==true)
		{
			System.out.println("mobile number is not valide");
		}
		else
		{
			System.out.println("mobile number is valide");
		}
		
		
		

	}

}
