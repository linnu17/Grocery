package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
    PageUtility page =new PageUtility(); 
    WaitUtility wait =new WaitUtility(); 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	@FindBy(xpath ="//input[@class='form-control' and @name='username']")WebElement username;
		public void enterusername(String usernamevalue) {
		//WebElement username = driver.findElement(By.xpath("//input[@class='form-control' and @name='username']"));
		//username.sendKeys(usernamevalue);
	    page.sendDataToElement(username, usernamevalue);
	}
	@FindBy(xpath ="//input[@class='form-control' and @name='password']")WebElement password;	
      public void enterpassword(String passwordValue) {
			//WebElement password = driver.findElement(By.xpath("//input[@class='form-control' and @name='password']"));
			//password.sendKeys(passwordValue);
    	  page.sendDataToElement(password, passwordValue);
		
		}
      @FindBy(xpath ="signin")WebElement signin;
		public void clicksignin() {
			//WebElement signin = driver.findElement(By.xpath("//button[text() ='Sign In']"));
			//signin.click();
			wait.waitUntilClickable(driver, signin);
			page.clickOnElement(signin);
		}
	
		
}


