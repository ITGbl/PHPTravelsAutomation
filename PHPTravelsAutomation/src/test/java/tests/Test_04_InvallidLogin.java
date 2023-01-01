package tests;

import org.testng.annotations.Test;
import base.Base;
import pages.LoginPage;

public class Test_04_InvallidLogin extends Base {
	LoginPage loginPage;

	public Test_04_InvallidLogin() throws Exception {
		super();
	}

	@Test
	public void login_invallid() throws Exception {
		
		loginPage = new LoginPage(driver);
		String userEmail = testData.getValue("REGISTRATION.EMAIL");
		String userPassword = testData.getValue("REGISTRATION.INVALIDPASSWORD");

		loginPage.login(userEmail,userPassword);
		loginPage.verifyErrorMsg();
		

	

	}

}