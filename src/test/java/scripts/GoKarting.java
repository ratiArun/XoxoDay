package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.Excel;
import pom.EnjoyGoKarting;
import pom.HomePage;
import pom.PlacesNear;

public class GoKarting extends Base_Test
{
	@Test @Ignore
	public void testGoKarting()
	{
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		String HomePageTitle=Excel.getData(Property_Path, "HomepageTitle");
		//String PlacesNearTitle=Excel.getData(Property_Path, "PlacesnearTitle");
		String EnjoygoKartingTitle=Excel.getData(Property_Path,"EnjoyGoKartingTitle");
		String CheckOutTitle=Excel.getData(Property_Path, "CheckoutTitle");
		
		HomePage hp=new HomePage(driver);
		String hptitle=driver.getTitle();
		Assert.assertEquals(HomePageTitle, hptitle);
		hp.clickCity();
		hp.moveToTrips();
		hp.clickPlaces();
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		PlacesNear pn=new PlacesNear(driver);
		System.out.println(driver.getTitle());
		//Assert.assertEquals(PlacesNearTitle, placetitle);
		pn.setMaxAmt("2500");
		pn.clickApply();
		pn.clickGOKArting();
		
		String parent=driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		all.remove(parent);
		for(String w: all)
		{
			driver.switchTo().window(w);
		}
		EnjoyGoKarting egk=new EnjoyGoKarting(driver);
		String gokarttitle=driver.getTitle();
		Assert.assertEquals(EnjoygoKartingTitle, gokarttitle);
		egk.clickDate();
		egk.clickDay();
		egk.selectTimeDropdown();
		int adults = egk.verifyPesrons();
		while(adults<=3)
		{
			egk.clickAddPerson();
			adults = egk.verifyPesrons();
		}
		egk.clickBuynow();
		String checkouttitle=driver.getTitle();
		Assert.assertEquals(CheckOutTitle, checkouttitle);
	}

}
