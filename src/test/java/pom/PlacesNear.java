package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class PlacesNear extends Generic_Page 
{
	public PlacesNear(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//label[@for='max-amt']/..//input") private WebElement maxamt;
	public void setMaxAmt(String amount)
	{
		verifyElement(maxamt);
		maxamt.clear();
		maxamt.sendKeys(amount);
	}
	@FindBy(xpath="//button[@id='addPriceRange']") private WebElement apply;
	public void clickApply()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(apply));
			apply.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
		
	}
	
	@FindBy(xpath="//div[@title='Enjoy Go-karting 12 Laps']") private WebElement gokarting;
	public void clickGOKArting()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(gokarting));
			gokarting.click();
		} catch (Exception e) 
		{
			Reporter.log("element is not present"+e,true);
			Assert.fail();
		}
	}

}
