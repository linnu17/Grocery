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
	@Test (description="verify logout")
	public void verifylogout() throws IOException {
			String usernameValue =ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET);
			String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
			// click window+v
			LoginPage login=new LoginPage(driver);
			login.enterusername(usernameValue);
			login.enterpassword(passwordValue);
			login.clicksignin();
			
			HomePage page=new HomePage(driver);
			page.loginclick();
			page.logoutclick();
			
			
			String expected="https://groceryapp.uniqassosiates.com/admin";
		    String actual=driver.getCurrentUrl();
//			Assert.assertEquals(actual, expected,"Logout is not successfull");
			Assert.assertEquals(actual, expected,Messages.LOGOUT_ASSERT);
		}
	}




