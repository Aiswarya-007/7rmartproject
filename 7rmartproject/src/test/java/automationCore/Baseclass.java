package automationCore;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotCapture;
import utilities.Waitutility;

public class Baseclass {
	public WebDriver driver;
	
	Properties properties=new Properties();
	ScreenshotCapture screenshotcapture=new ScreenshotCapture();
	
	public Baseclass()
	{
		try {
			
			FileInputStream ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public void initialize(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}	
		
		driver.get(url);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waitutility.IMPLICIT_WAIT));
	}
	
	@Parameters("browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser)
	{
		//String browser=properties.getProperty("browser"); //delete this
		String url=properties.getProperty("url");
		initialize(browser,url);
	}
	
	@BeforeMethod(enabled=true,alwaysRun = true)
	public void launchBrowser()
	{
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		initialize(browser,url);
	}
	@AfterMethod(alwaysRun = true)
	public void terminateSession(ITestResult itestresult)//listener interface is used to know the status of a test case whether it is pass or fail
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			screenshotcapture.takeScreenShot(driver, itestresult.getName());
		}
	}

}
