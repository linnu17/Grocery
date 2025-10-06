package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait =new WaitUtility(); 
	PageUtility page =new PageUtility(); 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminclick;
	public HomePage adminclicks() {
		//WebElement loginclick= driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//loginclick.click();
		//wait.waitUntilClickable(driver, adminclick);
		page.clickOnElement(adminclick);
		return this;
	}
	@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']")WebElement logoutclick;

	public LoginPage logoutclicks() {
		//WebElement logoutclick = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
//		logoutclick.click();
		wait.waitUntilClickable(driver, logoutclick);
		page.clickOnElement(logoutclick);
		return new LoginPage(driver);
	}
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreInfo;
	public AdminPage clickMoreInfo() {
//		WebElement adminmoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer'] "));
		//adminmoreInfo.click();
		 
		page.clickOnElement(adminmoreInfo);
		return new AdminPage(driver);
	}
	@FindBy(xpath ="//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement newsmoreinfo;
	public NewsPage newsMoreInfo() {
		//WebElement newsmoreinfo = driver.findElement(By.xpath("//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		//newsmoreinfo.click();
	//	wait.waitUntilClickable(driver, newsmoreinfo);
		page.clickOnElement(newsmoreinfo);
		return new NewsPage(driver);
	}

}


