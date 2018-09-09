package scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import generic.Base_Test;
import pom.EnjoyGoKarting;
import pom.HomePage;
import pom.PlacesNear;

public class GoKarting extends Base_Test
{
	@Test
	public void testGoKarting()
	{
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		HomePage hp=new HomePage(driver);
		hp.clickCity();
		hp.moveToTrips();
		hp.clickPlaces();
		
		PlacesNear pn=new PlacesNear(driver);
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
	}

}
