package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	public WebDriver driver;
	WaitUtility wait =new WaitUtility();
	PageUtility page =new PageUtility(); 
	public NewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath ="//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement newsmoreinfo;
	public void newsMoreInfo() {
		//WebElement newsmoreinfo = driver.findElement(By.xpath("//a[@class='small-box-footer'and @href ='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		//newsmoreinfo.click();
		wait.waitUntilClickable(driver, newsmoreinfo);
		page.clickOnElement(newsmoreinfo);
	}
	@FindBy(xpath ="//a[text()='Home']")WebElement homeclick;
	public void clickHome() {
//		WebElement homeclick =driver.findElement(By.xpath("//a[text()='Home']"));
		//homeclick.click();
		wait.waitUntilClickable(driver, homeclick);
		page.clickOnElement(homeclick);
	}
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newsmanageinfo;
	public void newsManageInfo() {
		//WebElement newsmanageinfo = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newsmanageinfo.click();
		page.clickOnElement(newsmanageinfo);
	}
	@FindBy(xpath ="//textarea[@id='news']")WebElement textarea;
	public void textArea() {
		//WebElement textarea = driver.findElement(By.xpath("//textarea[@id='news']"));
		//textarea.click();
		page.clickOnElement(textarea);
	}
	@FindBy(xpath ="//button[@name='create']")WebElement savemanage;
	public void saveManage() {
		//WebElement savemanage = driver.findElement(By.xpath("//button[@name='create']"));
		//savemanage.click();
		page.clickOnElement(savemanage);
	}
	@FindBy(xpath ="//div[@classalert alert-success alert-dismissible]")WebElement newsalert;
	public boolean newsAlert() {
		//WebElement newsalert=driver.findElement(By.xpath("//div[@classalert alert-success alert-dismissible]"));
		return newsalert.isDisplayed();
	}

}


