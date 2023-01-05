package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.PropertiesUtil;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailWE;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordWE;

	@FindBy(xpath = "//label[normalize-space()='Remember Me']]")
	private WebElement rememberMeWE;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
	private WebElement logInBtnWE;

	@FindBy(xpath = "//div[@class='alert alert-danger failed']")
	private WebElement errorMsgWE;

	public LoginPage(WebDriver driver) throws IOException, FileNotFoundException {
		this.driver = driver;
		driver.get(new PropertiesUtil("test_data.properties").getValue("URL.LOGIN"));
		PageFactory.initElements(driver, this);
		
	}

	public AccountPage login(String userEmail, String userPassword) {
		emailWE.clear();
		emailWE.sendKeys(userEmail);
		passwordWE.clear();
		passwordWE.sendKeys(userPassword);
		logInBtnWE.click();
		return new AccountPage(driver);

	}

	public void verifyErrorMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMsgWE));
		Assert.assertTrue(errorMsgWE.getText().trim().equals("Wrong credentials. try again!"),
				"Login Page - invalid credentialsmessage is not correct !");

	}

	public void verifyLoginPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(emailWE));
		} catch (TimeoutException e) {
			Assert.assertTrue(false, "Login page is not displayed.");
		}

	}

}