package generic;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Generic_Page
{
	public WebDriver driver;
	
	public Generic_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void verifyElement(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
		}
	}
	public void mouseHover(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void dropdown(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	public static void getPhoto(String path,WebDriver driver)
	{
		try 
		{
			Date d=new Date();
			String s=d.toString();
			String date=s.replaceAll(":", "-");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(path+date+".jpeg");
			FileUtils.copyFile(src, dst);
			
		} catch (Exception e)
		{
			Reporter.log("photo path is invalid "+e,true);
		}
	}
	public void scroll(WebElement ele)
	{
		WebDriverWait wait =new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			Point p=ele.getLocation();
			int x=p.getX();
			int y=p.getY();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+x+","+y+")");
			
		} catch (Exception e)
		{
			Reporter.log("element to scroll is not present "+e,true);
		}
	}
}
