package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import generic.Base_Test;
import pom.CelebrateBirthday;
import pom.CheckOut;
import pom.HomePage;
import pom.RoofTopDinnerDate;

public class BookingTableForBirthday extends Base_Test
{
	@Test@Ignore
	public void testBookingTableForBirthday()
	{
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		HomePage hp=new HomePage(driver);
		hp.clickCity();
		hp.moveToOccassion();
		hp.clickBirthday();
		
		CelebrateBirthday cb=new CelebrateBirthday(driver);
		cb.setMaxAmt("10000");
		cb.clickApply();
		String v=cb.getVal();
		cb.clickRoofTopDinner();
		
		String parent=driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		all.remove(parent);
		for(String w:all)
		{
			driver.switchTo().window(w);
		}
		
		RoofTopDinnerDate rf=new RoofTopDinnerDate(driver);
		rf.clickDateDropdown();
		rf.clickDate27();
		rf.clickAddon();
		rf.clickAddCake();
		rf.clickAddBouquet();
		rf.clickSubmit();
		rf.clickBuynow();
		
		CheckOut ck=new CheckOut(driver);
		String text=ck.text();
		Assert.assertEquals(v, text);
		Reporter.log("booked hotel is matching",true);
	}

}
