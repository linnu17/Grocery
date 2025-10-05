package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait =new WaitUtility(); 
	PageUtility page =new PageUtility(); 
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath ="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']" )WebElement loginclick;
	public void loginclick() {
		//WebElement loginclick= driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//loginclick.click();
		page.clickOnElement(loginclick);
	}
	@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']")WebElement logoutclick;
	public void logoutclick() {
		//WebElement logoutclick = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		//logoutclick.click();
		wait.waitUntilClickable(driver, logoutclick);
		page.clickOnElement(logoutclick);
	}

}


