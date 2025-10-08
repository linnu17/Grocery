package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
public WebDriver driver;
PageUtility page = new PageUtility();
WaitUtility wait = new WaitUtility();
public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
  @FindBy(xpath ="//input[@class='form-control' and @name='username']")WebElement username;
	public LoginPage enterusername(String usernameValue ) {
	//	WebElement username = driver.findElement(By.xpath("//input[@class='form-control' and @name='username']"));
	//	username.sendKeys(usernameValue);
		page.sendDataToElement(username, usernameValue);
		return this;
	}
	
	@FindBy(xpath ="//input[@class='form-control' and @name='password']")WebElement password;
	public LoginPage enterpassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@class='form-control' and @name='password']"));
		page.sendDataToElement(password, passwordValue);
		return this;
	}
	@FindBy(xpath ="//button[text() ='Sign In']")WebElement signin;
	public HomePage clicksignin() {
		//WebElement signin = driver.findElement(By.xpath("//button[text() ='Sign In']"));
	//	signin.click();
		wait.waitUntilClickable(driver, signin);
		page.clickOnElement(signin);
		return new HomePage(driver);
		
	}
}

