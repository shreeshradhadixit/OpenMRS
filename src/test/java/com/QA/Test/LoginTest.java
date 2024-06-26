package com.QA.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.Base.BaseClass;
import com.QA.Pages.LoginPage;


public class LoginTest extends BaseClass {
	LoginPage login;
	public LoginTest()
	{
		super();
	}
	@BeforeMethod
	public void prerequisite()
	{
	initializeBrowser();
	login=new LoginPage(driver);
	}
	@Test(priority=2)
	public void successfulLogin()
	{
		login.username(property.getProperty("UserIdopenmrs"));
		login.password(property.getProperty("passwordopenmrs"));
		login.SelectOption("Impatient ward");
		login.Login_button();
		String Title=login.GetTitle();
		System.out.println(Title);
	}
	@Test(priority=1)
	public void Invalid_username_password()
	{
		login.username("Qwerty");
		login.password("Qwerty");
		login.SelectOption("ImpatientWard");
		login.Login_button();
		String Title=login.GetTitle();
		System.out.println(Title);
	}
	@Test(enabled=false,priority=1)
	public void Invalid_UsrnamePassword(String Username,String Password,String option)
	{
	login.username("Qwerty");
	login.password("Qwerty");
	login.SelectOption("Impatient ward");
	login.Login_button();
	String Title=login.GetTitle();
	System.out.println(Title);
	}
	public void teardown()
	{
	driver.quit();
	}
	
	



}
