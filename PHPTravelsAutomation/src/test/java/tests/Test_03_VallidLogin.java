package tests;

import org.testng.annotations.Test;

import base.Base;
import pageObjects.AccountPage;
import pageObjects.LoginPage;



public class Test_03_VallidLogin extends Base {
	LoginPage loginPage;

	public Test_03_VallidLogin() throws Exception {
		super();
	}

	@Test
	public void login_vallid() throws Exception {
		
		loginPage = new LoginPage(driver);
		String userEmail = testData.getValue("REGISTRATION.EMAIL");
		String userPassword = testData.getValue("REGISTRATION.PASSWORD");
		
		AccountPage accountPage = loginPage.login(userEmail, userPassword);
		accountPage.verifyAccountPage();
		

	

	}

}