package opencart.tests;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import opencart.factory.PlaywrightFactory;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;

public class BaseTest
{

PlaywrightFactory pf;
	
	Page page;
	protected HomePage homepage;
	protected LoginPage loginPage;
	protected Properties prop;
	
	@BeforeTest
	public void setup()
	{
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		homepage=new HomePage(page);
		//homepage.navigatetologinpage();
	//	loginPage.getLoginPageTitle();
	}
	
	
	@AfterTest
	public void end()
	{
		page.context().browser().close();
		
	}
	
}
