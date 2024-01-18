package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {

public static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}

	@Before
	public static void getBrowser()
	{
	    driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");	
	}
	
	@After
	public static void teardown()
	{
		driver.close();
	}
	

}
