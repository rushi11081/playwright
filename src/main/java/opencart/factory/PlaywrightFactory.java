package opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	static Page page;
	Properties prop;

	
	

	public Page initBrowser(Properties prop)
	{
		String browserName=prop.getProperty("browser").trim();
		
            System.out.println("browser name is: "+browserName);
            
          playwright=Playwright.create();
          
		switch (browserName.toLowerCase()) 
		{
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		
			break;

		default:
			System.out.println("please pass the right browser name......");
			break;
		}

		browserContext=browser.newContext();
		page=browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
		
	}

	
	public Properties init_prop()
	{
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\Rushikesh Patil\\eclipse-workspace2\\PlaywrightFramewotk\\src\\test\\resources\\config\\config.properties");
		      prop=new Properties();
		      try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
}
	
