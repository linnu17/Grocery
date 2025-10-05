package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.TestNG;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {

	
	private static final boolean isalertdisplayed = false;
	public NewsTest(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void verifyaddnews() throws IOException{
		String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage login=new LoginPage(driver);
		login.enterusername(usernameValue);
		login.enterpassword(passwordValue);
		login.clicksignin();
		
		
		NewsPage news =new NewsPage(driver);
		news.newsMoreInfo();
		news.newsManageInfo();
		news.textArea();
		news.saveManage();
	
		//News alert - isdisplayed method 
		boolean isalertdisplayed = news.newsAlert();
		Assert.assertTrue(isalertdisplayed, Messages.ADDNEWS_ASSERT);
		 
		}
	@Test(description= "click to homebutton and back to home page")
	public void verifyreturntohome() throws IOException {
		String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage login=new LoginPage(driver);
		login.enterusername(usernameValue);
		login.enterpassword(passwordValue);
		login.clicksignin();
		NewsPage news = new NewsPage(driver);
		news.newsMoreInfo();
		news.clickHome();
//		WebElement newsmoreinfo = driver.findElement(By.xpath("//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']"));
//		newsmoreinfo.click();
	//
//		WebElement homeclick =driver.findElement(By.xpath("//a[text()='Home']"));
//		homeclick.click();
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.RETURNHOME_ASSERT);
	   
	}
	
}





