package opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import opencart.factory.PlaywrightFactory;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;


public class LoginPageTest extends BaseTest {


	
	@Test(priority = 1)
	public void loginPageNavigationTest()
	{
		loginPage = homepage.navigatetologinpage();
		String actLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, "Account Login");
	}

	
	@Test(priority = 2)
	public void appLoginTest() 
	{
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
	
	
	// new test added
	@Test(priority = 3)
	public void loginPageNavigationURL()
	{
		Assert.assertFalse(3==5);
		System.out.println("added");
       
	}
	@Test(priority =4)
	public void newtest()
	{
		System.out.println("new function added");
		
	}
}
