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
	
	
	  @Test public void verifywhetherToGetRandomNames() 
	  { 
		  loginpage=new Loginpage(driver); 
		  homepage=new HomePage(driver); 
		  loginpage.login(); 
		  String s=GeneralUtility.getRandomName(); 
		  System.out.println(s);
	  
	  }
	 
}
