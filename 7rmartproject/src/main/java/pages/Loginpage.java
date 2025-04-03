package pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

public class Loginpage 
{
	public WebDriver driver;
	Properties properties=new Properties();
	
	@FindBy(xpath="//input[@name='username']") private WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']") private WebElement signinbutton;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {			
			FileInputStream ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void enterusernameonusernamefield(String userName)
	{
		usernamefield.sendKeys(userName);
	}
	public void enterpasswordonpasswordfield(String password)
	{
		passwordfield.sendKeys(password);
	}
	public void clickonsigninbutton()
	{
		signinbutton.click();
	}
	public HomePage login(String userName,String password)
	{
		enterusernameonusernamefield(userName);
		enterpasswordonpasswordfield(password);
		clickonsigninbutton();
		return new HomePage(driver);
	}
	public HomePage login()
	{
		String userName=properties.getProperty("userName");
		String passWord=properties.getProperty("password");
		enterusernameonusernamefield(userName);
		enterpasswordonpasswordfield(passWord);
		clickonsigninbutton();
		return new HomePage(driver);
	}
}
