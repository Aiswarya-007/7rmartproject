package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath="//p[text()='Admin Users']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminUserLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public String getProfileName()
	{
		return profileName.getText();
	}
	public AdminUserPage navigateToadminUsers()
	{
		adminUserLink.click();
		return new AdminUserPage(driver);
	}
}
