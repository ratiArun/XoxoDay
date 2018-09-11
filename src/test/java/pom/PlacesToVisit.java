package pom;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class PlacesToVisit extends Generic_Page
{
	public PlacesToVisit(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//section[@id='product_section']//img")private List<WebElement> products;
	public int getCount()
	{
		int count;
		count=products.size();
		return count;
	}
	public String gettext()
	{
		String v="";
		verifyElement(products.get(1));
		v=products.get(1).getText();
		return v;
	}
	public void clickSecondOption()
	{
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(products.get(1)));
			products.get(1).click();;
		} catch (Exception e)
		{
			Reporter.log("second product is not clickable "+e,true);
			Assert.fail();
		}
	}

}
