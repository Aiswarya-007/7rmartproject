package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility 
{
	public String getAttribute(WebElement element,String attribute)
	{
		return element.getDomAttribute(attribute);
	}
	
	public String getCssValue(WebElement element,String cssproperty)
	{
		return element.getCssValue(cssproperty);
	}
	
	public List<String> getTextofElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
				
		for(WebElement element:elements)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getRandomName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
}
