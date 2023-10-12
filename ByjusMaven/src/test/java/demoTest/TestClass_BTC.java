package demoTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BestTutionCenterNearMeInMumbaiPage;
import pages.ByjusOnlineLearningProgramPage;

public class TestClass_BTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		ByjusOnlineLearningProgramPage byjusOnlineLearningProgramPage=new ByjusOnlineLearningProgramPage(driver);
		byjusOnlineLearningProgramPage.clickBTC();
		byjusOnlineLearningProgramPage.clickWesternZone();
		byjusOnlineLearningProgramPage.clickMaharashtra();
		byjusOnlineLearningProgramPage.clickNaviMumbai();
		
		BestTutionCenterNearMeInMumbaiPage bestTutionCenterNearMeInMumbaiPage=new BestTutionCenterNearMeInMumbaiPage(driver);
		bestTutionCenterNearMeInMumbaiPage.clickCloseButton();

	}

}
