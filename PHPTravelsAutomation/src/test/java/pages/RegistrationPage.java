package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.PropertiesUtil;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstNameWE;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastNameWE;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	private WebElement phoneNumberWE;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailWE;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordWE;

	@FindBy(xpath = "//span[@id='select2-account_type-container']") 
	private WebElement accountTypeWE;

	@FindBy(xpath = "//ul[@class='select2-results__options']") 																	
	private WebElement accountType2WE;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement accountTypeInputWE;

	@FindBy(xpath = "//li[@id='select2-account_type-result-oppx-agent']")
	private WebElement accountAgentWE;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private WebElement iFrameWE;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	private WebElement reCaptchaWE;

	@FindBy(xpath = "//div[@class='form-group mt-3']")
	private WebElement signUpBtnWE;

	@FindBy(xpath = "//div[@class='alert alert-success signup']")
	private WebElement errorMsgWE;


	public RegistrationPage(WebDriver driver) throws IOException, FileNotFoundException {
		this.driver = driver;
		driver.get(new PropertiesUtil("test_data.properties").getValue("URL.REGISTRATION"));
		PageFactory.initElements(driver, this);
	}

	public LoginPage registration(String firstName, String lastName, String phoneNum, String userEmail, String userPassword,
			String accountType) throws FileNotFoundException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		firstNameWE.clear();
		firstNameWE.sendKeys(firstName);
		lastNameWE.clear();
		lastNameWE.sendKeys(lastName);
		phoneNumberWE.clear();
		phoneNumberWE.sendKeys(phoneNum);
		emailWE.clear();
		emailWE.sendKeys(userEmail);
		passwordWE.clear();
		passwordWE.sendKeys(userPassword);
		accountTypeWE.click();
		accountTypeInputWE.sendKeys(accountType);
		accountTypeWE.submit();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameWE));
//		wait.until(ExpectedConditions.elementToBeClickable(reCaptchaWE)).click();
//		driver.switchTo().defaultContent();
//		signUpBtnWE.click();
		return new LoginPage(driver);

	}

	public void verifyInvalidPasswordMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(this.errorMsgWE));
		Assert.assertTrue(this.errorMsgWE.getText().trim().equals("Pasword mora sadrzati najmanje 6 karaktera"),
				"Registration page - invalid password message is not correct");
	}
}