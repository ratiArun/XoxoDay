package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class EnjoyGoKarting extends Generic_Page
{

	public EnjoyGoKarting(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="///div[contains(@class,'DateInput')]/ancestor::div/i")private WebElement datedropdown;
	public void clickDate()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(datedropdown));
			datedropdown.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//table//tr[4]/td[7]//button[.='22']") private WebElement day;
	public void clickDay()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(day));
			day.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	}

	@FindBy(xpath="//select[@id='time_selector']")private WebElement timedropdown;
	public void selectTimeDropdown()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(timedropdown));
			timedropdown.click();
			 dropdown(timedropdown, "12:00 PM");
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	   
	}
	@FindBy(xpath="//input[@class='count']") private WebElement persons;
	public int verifyPesrons()
	{
		verifyElement(persons);
		int v;
		String adult = persons.getAttribute("value");
		v=Integer.parseInt(adult);
		return v;
	}
	
	@FindBy(xpath="//button[.='+']")private WebElement addPerson;
	public void clickAddPerson()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(addPerson));
			addPerson.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//div[@class='buynow-button']/button")private WebElement buynow;
	public void clickBuynow()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(buynow));
			buynow.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	}
}
