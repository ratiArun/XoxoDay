package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class SecondOptions extends Generic_Page {

	public SecondOptions(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath="//div[@class='SingleDatePickerInput']/ancestor::div/i")private WebElement datedropdown;
	public void clickDateDropdown()
	{
		WebDriverWait wait=new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(datedropdown));
			datedropdown.click();
		} catch (Exception e) 
		{
			Reporter.log("datedropdown is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//tbody[@class='js-CalendarMonth__grid']/tr[5]//button[.='23']")private WebElement day23;
	public void clickDay()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(day23));
			day23.click();
		} catch (Exception e) 
		{
			Reporter.log("day23 is not clickable "+e,true);
			Assert.fail();
		}
	}
	@FindBy(xpath="//select[@id='time_selector']")private WebElement timeDropdown;
	public void selectTime(String time)
	{
		dropdown(timeDropdown, time);
	}
	@FindBy(xpath="//div[@class='buynow-button']/button")private WebElement buynow;
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
