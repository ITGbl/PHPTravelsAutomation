package pageObjects;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountPage {
	
	private WebDriver driver;
  
	
	@FindBy(xpath="//img[@alt='user']")
	WebElement avatarWE;
	
	@FindBy(xpath="//strong[normalize-space()='Super']")
	WebElement nameWE;
	
	@FindBy(xpath="//div[@class='sidebar-menu-wrap']")
	WebElement accountMenuWE;
	
	@FindBy(xpath="//ul[@class='sidebar-menu list-items']//a[contains(@class,'waves-effect')][normalize-space()='Logout']")
	WebElement logOutWE;
	
	@FindBy(xpath="//ul[@class='sidebar-menu list-items']//a[contains(@class,'waves-effect')][normalize-space()='My Profile']")
	WebElement MyProfileWE;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	public void verifyAccountPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(avatarWE));

		} catch (TimeoutException e) {
			Assert.assertTrue(false, "Account page is not displayed");
		}
	}
	
	public void verifyUserName(String firstName) {
		this.verifyAccountPage();
		Assert.assertTrue(nameWE.getText().contains(firstName), "Accoun name is incorect");
	}
	
	public LoginPage logout() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(accountMenuWE));
		accountMenuWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(logOutWE));
		logOutWE.click();
		
		
		return null;
		

	}
}
