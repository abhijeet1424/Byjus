package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.This;

public class BestTutionCenterNearMeInMumbaiPage {
	
	@FindBy (xpath = "(//button[@class='close'])[2]")
	private WebElement closeButton;
	
	private WebDriver driver;
	
	public BestTutionCenterNearMeInMumbaiPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickCloseButton()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}

}
