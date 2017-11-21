package ObjectRepository;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import DriverScript.Driver;

public class GetObjects extends LoadProperty {
	public Properties prop;
	public String locator;
	

	public By getObject(String para1) throws IOException
	{
		LoadProperty loadprop = new LoadProperty();
		if(Driver.para.contains(">"))
		{
			 locator = loadrepository(loadprop.fpath).getProperty(Driver.para1);
		}
		else
		{
			 locator = loadrepository(loadprop.fpath).getProperty(Driver.para);
		}

		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		if(locatorType.equals("id"))
			return By.id(locatorValue);
		else if(locatorType.equals("xpath"))
			return By.xpath(locatorValue);
		else if(locatorType.equals("name"))
			return By.id(locatorValue);
		return null;
		}
}
