package opencart.pages;


import com.microsoft.playwright.Page;

public class LoginPage
{

	private Page page;

	private String emailId = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	public LoginPage(Page page) 
	{
		this.page = page;
	}
	
	public String getLoginPageTitle()
	{
		return page.title();
	}
	
	public boolean doLogin(String appUserName, String appPassword)
	{
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		page.locator(logoutLink).waitFor();
		if(page.locator(logoutLink).isVisible()) {
			System.out.println("user is logged in successfully....");
			return true;
		}else {
			System.out.println("user is not logged in successfully....");
			return false;
		}
	}
}
