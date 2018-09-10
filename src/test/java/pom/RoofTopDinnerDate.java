package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class RoofTopDinnerDate extends Generic_Page
{
	public RoofTopDinnerDate(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//div[contains(@class,'DateInput')]/ancestor::div/i")private WebElement datedropdown;
	public void clickDateDropdown()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
		  wait.until(ExpectedConditions.elementToBeClickable(datedropdown));
		  datedropdown.click();
		} catch (Exception e) 
		{
			Reporter.log("datedropdown is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//tbody[@class='js-CalendarMonth__grid']/tr[5]/td[5][.='27']")private WebElement date27;
	public void clickDate27()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
		  wait.until(ExpectedConditions.elementToBeClickable(date27));
		  date27.click();
		} catch (Exception e) {
			Reporter.log("date 27 is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//button[.='Customize Addons']")private WebElement addon;
	public void clickAddon()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(addon));
			addon.click();
		} catch (Exception e)
		{
			Reporter.log("addon is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//strong[.='Half Kg Cake']/..//button[.='+']")private WebElement addcake;
	public void clickAddCake()
	{
		WebDriverWait wait =new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addcake));
			addcake.click();
		} catch (Exception e)
		{
			Reporter.log("add cake is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//strong[.='Blooming Bouquet']/..//button[.='+']")private WebElement addbouquet;
	public void clickAddBouquet()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addbouquet));
			addbouquet.click();
		} catch (Exception e) 
		{
			Reporter.log("add bouquet is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//button[@class='btn btn-primary btn-block btn-lg' and .='Submit']")
	private WebElement submit;
	public void clickSubmit()
	{
		WebDriverWait wait =new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();
		} catch (Exception e)
		{
			Reporter.log("submit is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//button[.='Book Now' and @type='button']")private WebElement buynow;
	public void clickBuynow()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(buynow));
			buynow.click();
		} catch (Exception e)
		{
			Reporter.log("buynow is not clickable "+e,true);
			Assert.fail();
		}
	}
}

