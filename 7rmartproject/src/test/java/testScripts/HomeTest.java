package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Baseclass;
import pages.HomePage;
import pages.Loginpage;
import utilities.GeneralUtility;

public class HomeTest extends Baseclass
{
	Loginpage loginpage;
	HomePage homepage;
	
	@Test
	  public void verifywhetherToGetRandomNames() 
	  { 
		  loginpage=new Loginpage(driver); 
		  homepage=new HomePage(driver); 
		  loginpage.login(); 
		  String s=GeneralUtility.getRandomName(); 
		  System.out.println(s);
	  
	  }
	
	@Test
	public void validateWhetherImageIsDisplayed() 
	{
		homepage = new HomePage(driver);
		loginpage=new Loginpage(driver); 
		loginpage.login();
		Assert.assertTrue(homepage.isImageDisplayed());

	}
	@Test
	public void verifyWhetherTitleNameIsCorrect()
	{
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		String actualResult=homepage.getTitleName();
		String expectedResult="7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);

	 
}
}
