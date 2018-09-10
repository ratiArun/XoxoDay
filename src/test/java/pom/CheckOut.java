package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Generic_Page;

public class CheckOut extends Generic_Page
{
	public CheckOut(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//strong[.='Rooftop Dinner Date']")private WebElement rooftop;
	public String text()
	{
		String txt="";
		WebDriverWait wait=new WebDriverWait(driver, 25);
		try {
			wait.until(ExpectedConditions.visibilityOf(rooftop));
			txt=rooftop.getText();
		} catch (Exception e) 
		{
			Reporter.log("added element is not visible "+e,true);
			Assert.fail();
		}
		return txt;
	}

}
