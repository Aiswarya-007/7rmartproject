package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Baseclass;
import pages.HomePage;
import pages.Loginpage;
import utilities.GeneralUtility;
import utilities.ScreenshotCapture;

public class Logintest extends Baseclass
{
	Loginpage loginpage;
	HomePage homepage;
	
	//@Test(groups={"smoke","regression"})
	public void verifywhetheruserisabletologinwithvalidcredentials()
	{
		//ScreenshotCapture screenshotcapture=new ScreenshotCapture(); // delete this
		//screenshotcapture.takeScreenShot(driver, "Aiswarya"); // Aiswarya- Image name, always call screenshot utility in test cls
		 loginpage=new Loginpage(driver);
		 homepage=new HomePage(driver);
		 loginpage.login("admin", "admin");
		 //loginpage.login();
		 String expectedProfileName="Admin";
		 String actualProfileName=homepage.getProfileName();
		 Assert.assertEquals(actualProfileName, expectedProfileName);
		 
	}
	
	
	
	
	
	
}
