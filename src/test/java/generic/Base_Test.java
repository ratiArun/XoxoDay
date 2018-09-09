package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test implements Constants
{
	public WebDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();
		driver.get("https://www.xoxoday.com/");
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void close(ITestResult r)
	{
		int status=r.getStatus();
		if(status==2)
		{
			
		}
		driver.quit();
	}

}
