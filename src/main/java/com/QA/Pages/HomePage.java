package com.QA.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.Base.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;
	@FindBy(xpath="//div[@class='logo']/a/img")
	private WebElement logo;
	
	@FindBy(xpath="//li[@style='cursor: pointer;']")
	private WebElement Admin;
	
	@FindBy(id="selected-location")
	private WebElement Top_Location;

	@FindBy(xpath="//ul[@class='select']")
	private List<WebElement> chg_location;
	
	@FindBy(partialLinkText="Logout")
	private WebElement logout;
	
	@FindBy(id="apps")
	private List<WebElement>dept;
	@FindBy(xpath="//h4[contains(text(),'Logged in as Super User (admin) at Registration Desk.')]")
	private WebElement heading;
	@FindBy(xpath="//a[contains(@id,'coreapps-activeVisitsHomepageLink-core']")
	private WebElement Find_Patient_Record;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-coreapps')]")
	private WebElement Active_visits;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-vitals-referenceapplication-vitals-extension')]")
	private WebElement Capture_Vitals;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension')]")
	private WebElement Register_Patient;
	@FindBy(xpath="//a[contains(@id,'appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension')]")
	private WebElement Appointment_scheduling;
	@FindBy(xpath="//a[contains(@id,'reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension')]")
	private WebElement Reports;
	@FindBy(xpath="//a[contains(@id,'coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension')]")
	private WebElement Data_Management;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension')]")
	private WebElement Configure_metadata;
	@FindBy(xpath="//a[contains(@id,'coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension')]")
	private WebElement System_Administration;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean logodisplay()
	{
		boolean logo1=logo.isDisplayed();
		return logo1;
	}
	public void User()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Admin).perform();
	}
	
	public void Top_Location()
	{
		Top_Location.click();
	}
	public void FindPatientRecord()
	{
		Find_Patient_Record.click();
	}

	public void ActiveVisits()
	{
		Active_visits.click();
	}

	public void CaptureVitals()
	{
		Capture_Vitals.click();
	}

	public void RegisterAPatient()
	{
		Register_Patient.click();
	}

	public void ApointmentScheduling()
	{
		Appointment_scheduling.click();
	}

	public void Reports()
	{
		Reports.click();
	}

	public void DataManagement()
	{
		Data_Management.click();
	}
	public void ConfigureMetadata()
	{
		Configure_metadata.click();
	}

	public void SystemAdministration()
	{
		System_Administration.click();
	}


	
	
	public void Change_Location(String option)
	{
		for(WebElement wb: chg_location)
		{
			if(wb.getText().equals(option))
			{
				wb.click();
			}
		}
	}
public void Logout()
{
	logout.click();
}

public void select_dept(String opt)
{
	for(WebElement wb:dept)
	{
		if(wb.getText().equals(opt))
		{
			wb.click();
		}
	}
}

	
	

}
