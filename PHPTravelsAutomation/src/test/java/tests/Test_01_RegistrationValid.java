package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class Test_01_RegistrationValid extends Base {
	RegistrationPage registrationPage;
	JavascriptExecutor jse; 

	public Test_01_RegistrationValid() throws Exception {
		super();
	}

	@Test
	public void registration_vallid() throws Exception {

		registrationPage = new RegistrationPage(driver);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 600)");

		LoginPage loginPage = registrationPage.registration(testData.getValue("REGISTRATION.FIRSTNAME"),
				testData.getValue("REGISTRATION.LASTNAME"), testData.getValue("REGISTRATION.PHONE"),
				testData.getValue("REGISTRATION.EMAIL"), testData.getValue("REGISTRATION.PASSWORD"),
				testData.getValue("REGISTRATION.AGENTTYPE"));
		loginPage.verifyLoginPage();

	}

}
