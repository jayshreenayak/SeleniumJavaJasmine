package GenericMethods;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import DriverScript.Driver;
import GenericMethods.Generic;
import ObjectRepository.GetObjects;


public class Generic 
{
	public WebDriver driver;
	public String url;
	public boolean bFlag;
	
	Driver dr = new Driver();
	GetObjects getobj = new GetObjects();
	
	public Generic(WebDriver driver)
	{
		this.driver = driver;
	}
	//opens browser
	public void OpenBrowser()
	{
		//try
		//{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		bFlag = true;
	}
	//go to url
	public void AccessSite(String URL) throws Exception
	{
		driver.get(URL);
	
		Thread.sleep(50);
		bFlag=false;
	}
	
	//clicks on webelement
	
	public void clickElement(String ElementName) throws IOException
	{
		try{
			driver.findElement(getobj.getObject(Driver.para)).click();
			bFlag=true;
			Thread.sleep(20);
		}
		catch(Exception e)
		{System.out.println(e);}
	}
	
	//enter value in text box
	public void setValue(String ElementName,String EnterText) throws Exception
	{
		driver.findElement(getobj.getObject(Driver.para1)).sendKeys(Driver.para2);
		bFlag=true;

	}
	//find out links in my orders drop down
	
	public void checkLinksInMyOrders(String ListItem, String ElementName) throws Exception
	{
		try{
		List<WebElement> list = driver.findElements(getobj.getObject(Driver.para1));
		for(int i=0;i<list.size();i++)
		{
			
			System.out.println(list.get(i).getText());
			if (Driver.para2.equalsIgnoreCase(list.get(i).getAttribute("text").trim()))
			{
				bFlag=true;
				
			}
			break;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	//click item in list
	public void clickListItem(String ListItem, String ElementName) throws Exception
	{
		try{
		List<WebElement> list = driver.findElements(getobj.getObject(Driver.para1));
		for(WebElement items:list)
		{
			if (Driver.para2.equalsIgnoreCase(items.getAttribute("text").trim()))
			{
				items.click();
				bFlag=true;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//hover mouse on required element
	public void mouseHover(String ElementName) throws Exception
	{
		try{
			Thread.sleep(30);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(getobj.getObject(Driver.para));
		action.moveToElement(element).perform();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void enterTextInEditBox()
	{
		try{
			driver.findElement(getobj.getObject(Driver.para1)).sendKeys(Driver.para2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
//################################################################################################################
	public void fillForm() throws Exception
	{ try
	{
		driver.findElement(By.name("name")).sendKeys("Jayshree");
		driver.findElement(By.name("phone")).sendKeys("9100874625");
		driver.findElement(By.name("email")).sendKeys("jayshreenayak550@gmail.com");
		//WebElement element = driver.findElement(By.name("//*[@name='country']"));
		//Select sel = new Select(element);
		//sel.selectByVisibleText("India");
		//Thread.sleep(3000);
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		
		driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[6]/input")).sendKeys("jasmine");
		
		driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[7]/input")).sendKeys("jasminesitu");
		
		driver.findElement(By.xpath("//input[@class='button' or @ value='Submit']/ancestor::*[@id='wrapper']")).isDisplayed();
		driver.findElement(By.xpath("//input[@value='Submit']/ancestor::*[@id='wrapper']")).click();
		}
	catch(Exception e)
	{
		
	}
		
	}

}
