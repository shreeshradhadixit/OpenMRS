package com.QA.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QA.Base.BaseClass;
import com.QA.Pages.LoginPage;

public class HomePageTest extends BaseClass{
	@BeforeClass()
	public void setup()
	{
		initializeBrowser();
		LoginPage login=new LoginPage();
		login.Home_Page();
	}
	@Test(priority=1)
	public void VerifyHeading()
	{
		String actual="Logged in as Super User (admin) at Registration Desk.";
		String expected=prop.getProperty("HomePageHeading");
	}
	

}
