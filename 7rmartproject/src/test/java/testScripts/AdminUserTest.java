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
		adminuserpage = homepage.navigateToadminUsers(); // object chaining(mandatory)
		adminuserpage.clickOnNewButton().enterUsernameField("Aishu").enterPasswordField("aishu123")
				.selectUserType("Staff").clickOnSaveButton(); // method chaining(optional)
	}

	@Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void verifyWhetherAdminisAbletoAddUsers(String userName, String passWord, String userType) {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickOnNewButton();
		adminuserpage.enterUsernameField(userName);
		adminuserpage.enterPasswordField(passWord);
		adminuserpage.selectUserType(userType);
		adminuserpage.clickOnSaveButton();
		String actualalertmessage = adminuserpage.getAlertMessage();
		Assert.assertEquals(actualalertmessage, "User Created Successfully","Username already exists");
	}

	@Test
	public void verifyWhetherAdminisAbleToResetAdminUsersInformation() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new Loginpage(driver);
		loginpage.login();
		homepage.navigateToadminUsers();
		adminuserpage.clickOnNewButton();
		adminuserpage.clickOnNewFormResetButton();
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
