package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import constants.Constants;

public class ScreenshotCapture 
{

	TakesScreenshot takesscreenshot;//interface
	
	public void takeScreenShot(WebDriver driver, String imageName) { 
		try {
			takesscreenshot=((TakesScreenshot) driver);
			File screenShot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//to get time
			File destination = new File(Constants.SCREENSHOT_FILE_PATH+imageName+"_"+timeStamp+".png");
			FileHandler.copy(screenShot, destination);
		} catch (Exception e) {
			e.printStackTrace();
	}
}
	
}
