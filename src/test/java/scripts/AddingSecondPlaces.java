package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Base_Test;
import pom.CheckOut;
import pom.HomePage;
import pom.PlacesToVisit;
import pom.SecondOptions;

public class AddingSecondPlaces extends Base_Test
{
	@Test
	public void testAddingSecondPlaces()
	{
		driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS);
		HomePage hp=new HomePage(driver);
		hp.clickCity();
		hp.sendValue("places to visit");
		
		PlacesToVisit pv=new PlacesToVisit(driver);
		int count=pv.getCount();
		Reporter.log("total options are="+count,true);
		String value=pv.gettext();
		pv.clickSecondOption();
		
		String parent=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		all.remove(parent);
		for(String w:all)
		{
			driver.switchTo().window(w);
		}
		SecondOptions so=new SecondOptions(driver);
		so.clickDateDropdown();
		so.clickDay();
		so.selectTime("12:00 PM");
		so.clickBuynow();
		
		CheckOut ck=new CheckOut(driver);
		String txt=ck.text();
		Assert.assertEquals(value, txt);
		Reporter.log("added product is same",true);
	}

}
