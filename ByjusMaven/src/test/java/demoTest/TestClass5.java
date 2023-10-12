package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ByjusOnlineLearningProgramPage;

public class TestClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://byjus.com/");
		driver.manage().window().maximize();
		
		ByjusOnlineLearningProgramPage byjusOnlineLearningProgramPage=new ByjusOnlineLearningProgramPage(driver);
	
		byjusOnlineLearningProgramPage.selectState();

	}

}
