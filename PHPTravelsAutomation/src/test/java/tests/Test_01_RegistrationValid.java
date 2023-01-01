package tests;

import org.testng.annotations.Test;
import base.Base;
import pages.LoginPage;
import pages.RegistrationPage;

public class Test_01_RegistrationValid extends Base {
	RegistrationPage registrationPage;

	public Test_01_RegistrationValid() throws Exception {
		super();
	}

	@Test
	public void registration_vallid() throws Exception {

		registrationPage = new RegistrationPage(driver);

		LoginPage loginPage = registrationPage.registration(testData.getValue("REGISTRATION.FIRSTNAME"),
				testData.getValue("REGISTRATION.LASTNAME"), testData.getValue("REGISTRATION.PHONE"),
				testData.getValue("REGISTRATION.EMAIL"), testData.getValue("REGISTRATION.PASSWORD"),
				testData.getValue("REGISTRATION.AGENTTYPE"));
		loginPage.verifyLoginPage();

	}

}
