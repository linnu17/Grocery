package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase {
	HomePage home;
	NewsPage news;

	@Test(description = "verify adding new data in manaage news")
	public void veriftAddnews() throws IOException {
		String usernameValue =ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue =ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
	LoginPage login = new LoginPage(driver);
		
		login.enterusername(usernameValue).enterpassword(passwordValue);
		//login.enterpassword(passwordValue);
		home=login.clicksignin();
		
		//NewsPage news = new NewsPage(driver);
		news =home.newsMoreInfo();
		news.clicknewnews().textareafield().clickSave();
//		WebElement textarea = driver.findElement(By.xpath("//textarea[@id='news']"));
//		textarea.sendKeys("This is a sample news");
		//news.textareafield();
//		WebElement savemanage = driver.findElement(By.xpath("//button[@name='create']"));
//		savemanage.click();
		//news.clickSave();

		//WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		boolean isalertdisplayed = news.newsAlert();
//		Assert.assertTrue(isalertdisplayed, "News is not added");
		Assert.assertTrue(isalertdisplayed, Messages.ADDNEWS_ASSERT);
	}
	@Test(description ="verify return to home from managenews")
	public void verifyreturntohome() throws IOException {
		String usernameValue =ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue =ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
		
		login.enterusername(usernameValue).enterpassword(passwordValue);
		//login.enterpassword(passwordValue);
		home =login.clicksignin();
//		NewsPage news = new NewsPage(driver);
		news= home.newsMoreInfo();
		home = news.clickHome();
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