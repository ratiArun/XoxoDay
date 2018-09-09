package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class HomePage extends Generic_Page
{
   
	public HomePage( WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h4[.='Bangalore']") private WebElement city;
	public void clickCity()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(city));
			city.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	
	}
	
	@FindBy(xpath="//a[.='Trips']") private WebElement trips;
	public void moveToTrips()
	{
		verifyElement(trips);
		mouseHover(trips);
	}
	@FindBy(xpath="//a[.='Place within 100km']") private WebElement places;
	public void clickPlaces()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(places));
			places.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	}

}
