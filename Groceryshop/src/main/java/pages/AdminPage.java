package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
public WebDriver driver;
WaitUtility wait =new WaitUtility(); 
PageUtility page =new PageUtility(); 
public AdminPage(WebDriver driver) {
	this.driver=driver;
	
	
} 
//page factory cheyan paranjal @findby xpath edukanm, not findelement(it is reusable code)

@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreInfo;
public void clickMoreInfo() {
//	WebElement adminmoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer'] "));
	//adminmoreInfo.click();
	 
	page.clickOnElement(adminmoreInfo);
}
@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newuser;
public void addnewuser() {
//	WebElement newuser =driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
//	newuser.click();
	page.clickOnElement(newuser);
}
@FindBy(xpath ="//input[@id='username']")WebElement newusername;
public void addNewUsername(String randomname) {
//	WebElement newusername = driver.findElement(By.xpath("//input[@id='username']"));
//	newusername.sendKeys(randomname);
	
	page.sendDataToElement(newusername, randomname);
	
}
@FindBy(xpath ="//input[@id='password']")WebElement newpassword;
public void enterNewPassword(String randompassword) {
	//WebElement newpassword = driver.findElement(By.xpath("//input[@id='password']"));
	//newpassword.sendKeys(randompassword);
	page.sendDataToElement(newpassword, randompassword);
}
@FindBy(xpath ="//select[@id='user_type']")WebElement newusertype;
public void newUserType() {
//	WebElement newusertype =driver.findElement(By.xpath("//select[@id='user_type']"));
//	Select select = new Select(newusertype);
//	select.selectByVisibleText("Admin");
//	page.selectDataWithVisibleText(newusertype,"Admin");
	page.selectDataWithVisibleText(newusertype,Constants.ADMINUSER);
}
@FindBy(xpath ="//button[@name='Create']")WebElement usersave;
public void userSave() {
	//WebElement usersave = driver.findElement(By.xpath("//button[@name='Create']"));
	//usersave.click();
	//wait kodukumbo webelement variable anu kodukendathu after driver
	wait.waitUntilClickable(driver, usersave);
	page.clickOnElement(usersave);
}
@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")WebElement newalert;
public boolean newAlert() {
	//WebElement newalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	return newalert.isDisplayed();
}
@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")WebElement usersearch;
public void  userSearch() {
	//WebElement usersearch = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
	//usersearch.click();
	page.clickOnElement(usersearch);
}
@FindBy(xpath ="//input[@id='un']")WebElement searchusername;
public void searchByName(String randomname) {
	//WebElement searchusername = driver.findElement(By.xpath("//input[@id='un']"));
//	searchusername.sendKeys(randomname);
	page.sendDataToElement(searchusername, randomname);
}
@FindBy(xpath ="//select[@name='ut']")WebElement searchusertype;
public void searchUserType() {
	//WebElement searchusertype = driver.findElement(By.xpath("//select[@name='ut']"));
//	Select select = new Select(searchusertype);
//	select.selectByVisibleText("Admin");
//	page.selectDataWithVisibleText(searchusertype, "Admin");
	page.selectDataWithVisibleText(searchusertype,Constants.ADMINUSER);
}
@FindBy(xpath ="//button[@name='Search']")WebElement searchuser;
public void searchUser() {
	//WebElement searchuser = driver.findElement(By.xpath("//button[@name='Search']"));
//	searchuser.click();
	
	page.clickOnElement(searchuser);
}
@FindBy(xpath ="//button[@class='btn btn-block-sm btn-danger' and @name = 'Search']")WebElement searchalert;
public boolean searchAlert() {
	//WebElement searchalert = driver.findElement(By.xpath("//button[@class='btn btn-block-sm btn-danger' and @name = 'Search']"));
	return searchalert.isDisplayed();
}
@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning']")WebElement reset;
public void reset() {
	//WebElement reset = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
	//reset.click();
	page.clickOnElement(reset);
}
@FindBy(xpath ="//h4[@class='card-title' and text() ='Admin Users']")WebElement resetassert;
public boolean resetAlert() {
	//WebElement resetassert = driver.findElement(By.xpath("//h4[@class='card-title' and text() ='Admin Users']"));
	return resetassert.isDisplayed();
}

}
