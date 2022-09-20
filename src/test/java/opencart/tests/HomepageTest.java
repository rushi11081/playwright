package opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import opencart.factory.PlaywrightFactory;
import opencart.pages.HomePage;

public class HomepageTest extends BaseTest {

	
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homepage.getHomePageURL();
		Assert.assertEquals(actualURL,prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getProductData() {
	return new Object[][]
			{
			{ "Macbook" }, 
			{ "iMac" }, 
			{ "Samsung" }
	};
}

	@Test(dataProvider = "getProductData")
	public void searchTest(String productname) {
		String actualSearchHeader = homepage.doSearch(productname);
		Assert.assertEquals(actualSearchHeader, "Search - " +productname);
	}

}
