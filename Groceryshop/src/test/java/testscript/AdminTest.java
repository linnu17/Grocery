package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
@Test
	public void verifyadduser() throws IOException {
	String usernameValue =ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordValue =ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterusername(usernameValue);
	login.enterpassword(passwordValue);
	login.clicksignin();
	
	FakerUtility fakerUtility = new FakerUtility();
	String randomname=fakerUtility.createRandomUserName();
	String randompassword=fakerUtility.createRandomPassword();
//	String usertype = ExcelUtility.getStringData(1, 2, "HomePage");
	
	AdminPage admin = new AdminPage(driver);
	admin.clickMoreInfo();
	admin.addnewuser();
	admin.addNewUsername(randomname);
	admin.enterNewPassword(randompassword);
	admin.newUserType();
	admin.userSave();
	
	boolean isalertdisplayed = admin.newAlert();
	//Assert.assertTrue(isalertdisplayed, "New item is not added");
    Assert.assertTrue(isalertdisplayed,Messages.ADDUSER_ASSERT);
}
@Test

public void verifysearch() throws IOException {
	String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
	String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
	LoginPage login = new LoginPage(driver);
	login.enterusername(usernameValue);
	login.enterpassword(passwordValue);
	login.clicksignin();
	FakerUtility fakerUtility = new FakerUtility();
	String randomname=fakerUtility.createRandomUserName();
	AdminPage admin = new AdminPage(driver);
	admin.clickMoreInfo();
	admin.userSearch();
admin.searchByName(randomname);
admin.searchUserType();
admin.searchUser();

	boolean isalertdisplayed= admin.searchAlert();
	//Assert.assertTrue(isalertdisplayed, "Search button is not displayed");
	Assert.assertTrue(isalertdisplayed, Messages.SEARCH_ASSERT);
	
}
@Test
public void verifyreset() throws IOException {
//	String usernameValue =ExcelUtility.getStringData(1, 0, "LoginPage");
//	String passwordValue =ExcelUtility.getStringData(1, 1, "LoginPage");
//	LoginPaginu we have created a constant in constants class that we are caliing below
	//We have to replace every "LoginPage"with the constant we have created in every test cases.
	String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
	String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
//	WebElement username = driver.findElement(By.xpath("//input[@class='form-control' and @name='username']"));
//	username.sendKeys(usernameValue);
//	WebElement password = driver.findElement(By.xpath("//input[@class='form-control' and @name='password']"));
//	password.sendKeys(passwordValue);
//	WebElement signin = driver.findElement(By.xpath("//button[text() ='Sign In']"));
//	signin.click();
	LoginPage login = new LoginPage(driver);
	login.enterusername(usernameValue);
	login.enterpassword(passwordValue);
	login.clicksignin();
	FakerUtility fakerUtility = new FakerUtility();
	String randomname=fakerUtility.createRandomUserName();
	String randompassword=fakerUtility.createRandomPassword();
//	String usertype = ExcelUtility.getStringData(1, 2, "HomePage");
//	WebElement adminmoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer'] "));
//	adminmoreInfo.click();
//	WebElement newuser =driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
//	newuser.click();
	AdminPage admin = new AdminPage(driver);
	admin.clickMoreInfo();
	admin.addnewuser();
	
	admin.reset();
	WebElement resetassert = driver.findElement(By.xpath("//h4[@class='card-title' and text() ='Admin Users']"));

	boolean isalertdisplayed = admin.resetAlert();
	Assert.assertTrue(isalertdisplayed, "Admin User header is not displayed");

Assert.assertTrue(isalertdisplayed, Messages.RESET_ASSERT);

}
}



	
	


