package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	HomePage home;
	@Test(priority = 1,description = "verify login with valid credentials",retryAnalyzer = retry.Retry.class,groups= {"smoke"} )
	//retry mechnaisn run avan helpcheyunu
	public void verifyvalidusernamevalidpassword() throws IOException {
//		String usernameValue =ExcelUtility.getStringData(1, 0, "LoginPage");
//		String passwordValue =ExcelUtility.getStringData(1, 1, "LoginPage");
//		LoginPaginu we have created a constant in constants class that we are caliing below
		//We have to replace every "LoginPage"with the constant we have created in every test cases.
		
		String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		
		String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
	//System.out.println(driver.getCurrentUrl());

		LoginPage login = new LoginPage(driver);
		
		login.enterusername(usernameValue).enterpassword(passwordValue);
//		login.enterpassword(passwordValue);
		home = login.clicksignin();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		String actual = driver.getCurrentUrl();
//		Assert.assertEquals(actual, expected,"Login is not successfull with valid credentials");
		Assert.assertEquals(actual, expected,Messages.VALIDLOGIN_ASSERT);
	}
	@Test(priority = 2, description = "verify login with validusername and invalidpw")
	public void verifyvalidusernameinvalidpassword() throws IOException{
		String usernameValue =ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue).clicksignin();
		//login.enterpassword(passwordValue);
		//login.clicksignin();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
		//Assert.assertEquals(actual, expected,"Login was successfull with validusername and invalidpassword");
		Assert.assertEquals(actual, expected,Messages.INVALIDPASSWORD_ASSERT);
		}

	@Test(priority = 3, description = "verify login with invalid usename and valid pw")
	public void verifyinvalidusernamevalidpassword() throws IOException{
		String usernameValue =ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		LoginPage login = new LoginPage(driver);
		
		login.enterusername(usernameValue).enterpassword(passwordValue).clicksignin();
//		login.enterpassword(passwordValue);
//		login.clicksignin();
		
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
//		Assert.assertEquals(actual, expected,"Login was successfull with invalidusername validpassword");
		Assert.assertEquals(actual, expected,Messages.INVALIDUSERNAME_ASSERT);
	}
	@Test(priority = 4,description = "verify login with invalid credentials",dataProvider = "loginProvider")
	public void verifyinvalidusernameinvalidpassword(String usernameValue,String passwordValue ) throws IOException{
//		String usernameValue =ExcelUtility.getStringData(4, 0, "LoginPage");
//		String passwordValue =ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue).clicksignin();
//		login.enterpassword(passwordValue);
//		login.clicksignin();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = driver.getCurrentUrl();
//		Assert.assertEquals(actual, expected,"Login was successfull with invalidusername invalidpassword");
		Assert.assertEquals(actual, expected,Messages.INVALIDLOGIN_ASSERT);
		
	}
	@DataProvider(name="loginProvider")//to test 3 set of data, set ana name for dataprovided
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] {//2 dimentional adday anu return cheyune
			new Object[] {"user","password"},//2 dimentional adday anu return cheyune
			new Object[] {"username","pass"},
			new Object[] {"user1","password1"}
		};
	}
	}