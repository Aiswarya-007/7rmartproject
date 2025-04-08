package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.PageUtility;

public class AdminUserPage 
{
	public WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement save;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement search;
	@FindBy(xpath="//input[@id='un']")
	private WebElement searchusername;
	@FindBy(xpath="//select[@id='ut']")
	private WebElement searchusertype;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchbutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	private WebElement reset;
	@FindBy(xpath="(//a[@class='btn btn-default btn-fix'])[2]")
	private WebElement newresetbutton;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/user/status?id=13198&st=inactive&page_ad=1'])[2]")
	private WebElement status;
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	private WebElement edit;
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getButtonColor()
	{
		return generalutility.getCssValue(newButton,"background-color"); // call utility class only in page cls
	}
	public AdminUserPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public AdminUserPage enterUsernameField(String userName)
	{
		username.sendKeys(userName);
		return this;
	}
	public String getUserName()
	{
		return username.getText();
	}
	public AdminUserPage enterPasswordField(String passWord)
	{
		password.sendKeys(passWord);
		return this;
	}
	public void addNewUser(String userName,String passWord,String userType)
	{
		clickOnNewButton();
		enterUsernameField(userName);
		enterPasswordField(passWord);
		selectUserType(userType);
		clickOnSaveButton();
	}
	public AdminUserPage selectUserType(String userType)
	{
		PageUtility pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText(usertype, userType);
		return this;
	}
	public AdminUserPage clickOnSaveButton()
	{
		save.click();
		return this;	
	}
	public String getAlertMessage()
	{
		Alert alert = driver.switchTo().alert();  // Switch to the alert
	    String alertText = alert.getText();  // Get alert message
	    alert.accept();  // Click OK to close the alert
	    return alertText;
	}
	public void clickOnNewFormResetButton()
	{
		newresetbutton.click();
		edit.click();
	}
	public void ClickOnEditButton()
	{
		edit.click();
	}
	public void clickSearchButton()
	{
		search.click();
	}
	public void searchUserName(String userName)
	{
		searchusername.sendKeys(userName);
	}
	public void searchUserType(String userType)
	{
		PageUtility pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText(searchusertype, userType);
	}
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	public void clickOnResetButton()
	{
		reset.click();
	}
	public void clickOnStatusButton()
	{
		status.click();
	}
	
}
