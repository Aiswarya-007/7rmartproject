package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Baseclass;
import dataproviders.DataProviders;
import listeners.RetryAnalyzer;
import pages.AdminUserPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelReader;
import utilities.GeneralUtility;

public class AdminUserTest extends Baseclass {
	AdminUserPage adminuserpage;
	HomePage homepage;
	Loginpage loginpage;

	@Test
	public void verifyWhetherAdminisabletoCreateNewUser() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyNewButtonColor() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		String expectedButtonColor = "rgba(220, 53, 69, 1)";
		String actualButtonColor = adminuserpage.getButtonColor();
		System.out.println(actualButtonColor);
		Assert.assertEquals(actualButtonColor, expectedButtonColor);
	}

	@Test(groups = "smoke")
	public void verifyWhetherNewButtonIsClickable() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickOnNewButton();
	}

	@Test(groups = "smoke")
	public void ExcelCheck() {
		ExcelReader excelreader = new ExcelReader();
		excelreader.setExcelFile("LoginData");
		System.out.println(excelreader.getCellData(0, 0));
	}

	@Test(groups = "smoke")
	public void verifyWhetherAdminisAbleToAddNewUser() {
		loginpage = new Loginpage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.navigateToadminUsers(); 
		adminuserpage.clickOnNewButton().enterUsernameField("Aishu").enterPasswordField("aishu123")
				.selectUserType("Staff").clickOnSaveButton(); 
		String actualalertmessage = adminuserpage.getAlertMessage();
		Assert.assertEquals(actualalertmessage, "User Created Successfully","Username already exists");
	}
	
	@Test
	public void verifywhetherAdminisAbletoAddSingleUser()
	{
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		String randomname=GeneralUtility.getRandomName(); 
		adminuserpage.addNewUser(randomname+"LN", randomname+"@123", "Staff");
		String actualalertmessage = adminuserpage.getAlertMessage();
		Assert.assertEquals(actualalertmessage, "User Created Successfully","Username already exists");
	}

	@Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void verifyWhetherAdminisAbletoAddMultipleUsers(String userName, String passWord, String userType) {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.addNewUser(userName+"cooper", passWord+userName, userType);
		String actualalertmessage = adminuserpage.getAlertMessage();
		Assert.assertEquals(actualalertmessage, "Users Created Successfully","Username already exists");
	}

	@Test
	public void verifyWhetherAdminisAbleToResetUsersInformation() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.ClickOnEditButton();
	}

	@Test
	public void verifyWhetherAdminisAbleToSearchUsers() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickSearchButton();
		adminuserpage.searchUserName("Aishu");
		adminuserpage.searchUserType("Staff");
		adminuserpage.clickOnSearchButton(); // add assert
	}

	@Test
	public void verifyWhetherAdminisAbleToClickResetButton() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickOnResetButton();
	}

	@Test
	public void verifyWhetherUserIsAbleToClickonStatusButton() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickOnNewButton();
		adminuserpage.clickOnNewFormResetButton();
		adminuserpage.clickOnStatusButton();
	}

}
