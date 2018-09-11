package pom;

import org.openqa.selenium.Keys;
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
	@FindBy(xpath="//a[.='Occasions']")private WebElement occasions;
	public void moveToOccassion()
	{
		verifyElement(occasions);
		mouseHover(occasions);
	}
	
	@FindBy(xpath="//a[.='Birthday']")private WebElement birthday;
	public void clickBirthday()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(birthday));
			birthday.click();
		} catch (Exception e)
		{
			Reporter.log("birthday is not clickable "+e,true);
		}
	}
	@FindBy(xpath="//div[@class='site-nav']/following-sibling::div[1]//input[@id='search-input']")
	private WebElement searchtbox;
	public void sendValue(String value)
	{
		verifyElement(searchtbox);
		searchtbox.sendKeys(value);
		searchtbox.sendKeys(Keys.ENTER);
	}
	
}
