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
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();
	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clickknews;
	public NewsPage  clicknewnews() {
		wait.waitUntilClickable(driver, clickknews);
		clickknews.click();
		return this;
	}
	@FindBy(xpath ="//a[text()='Home']")WebElement homeclick;
	public HomePage clickHome() {
//		WebElement homeclick =driver.findElement(By.xpath("//a[text()='Home']"));
		//homeclick.click();
//		wait.waitUntilClickable(driver, homeclick);
		page.clickOnElement(homeclick);
		return new HomePage(driver);
	}
	@FindBy(xpath ="//textarea[@id='news']")WebElement textarea;
	public NewsPage textareafield() {
		//WebElement textarea = driver.findElement(By.xpath("//textarea[@id='news']"));
		//textarea.sendKeys("This is a sample news");
		page.sendDataToElement(textarea, "This is a sample news");
		return this;
		
	}
	@FindBy(xpath ="//button[@name='create']")WebElement savemanage;
	public NewsPage clickSave() {
		//WebElement savemanage = driver.findElement(By.xpath("//button[@name='create']"));
		//savemanage.click();
		page.clickOnElement(savemanage);
		return this;
	}
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
	public boolean newsAlert() {
		//WebElement newsalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return newsalert.isDisplayed();
	}
	}