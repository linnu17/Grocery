package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	HomePage home;
	@Test(description = "verify Logout")
	public void verifyLogout() throws IOException {
//	String usernameValue =ExcelUtility.getStringData(1, 0, "LoginPage");
//	String passwordValue =ExcelUtility.getStringData(1, 1, "LoginPage");
//	LoginPaginu we have created a constant in constants class that we are caliing below
	//We have to replace every "LoginPage"with the constant we have created in every test cases.
		String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
//		login.enterpassword(passwordValue);
	    home =	login.clicksignin();
	//	HomePage home = new HomePage(driver);
		home.adminclicks();
	    login=home.logoutclicks();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
	//	Assert.assertEquals(actual, expected,"Logout is not successfull");
		Assert.assertEquals(actual, expected,Messages.LOGOUT_ASSERT);
		
	}
}


