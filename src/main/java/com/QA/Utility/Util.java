	package com.QA.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Base.BaseClass;


public class Util extends BaseClass {
	
	private static final String Test_data_path = null;
	private static final String projectpath = null;
	public static void WaitForElement(WebElement element)
	{
		WebDriverWait webdriverwait=new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void Elementtobeclickable(WebElement element) {
		WebDriverWait webdriverwait=new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void WaitForElements(List<WebElement> element)
	{
		WebDriverWait webdriverwait=new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public static void click(WebElement element)
	{
		element.click();
		
	}
	public static void sendkeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	public static void MoveToElement(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public static void ClickAndHold(WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		}
	public static Object[][] getTestData(String Sheetname)
	{
	FileInputStream file=null;
	Workbook book=null;
	try{
	file=new FileInputStream(Test_data_path);
	}catch(FileNotFoundException e)
	{
	e.printStackTrace();
	}
	try{
	book=WorkbookFactory.create(file);
	}catch(EncryptedDocumentException e)
	{
	e.printStackTrace();
	}catch(IOException e)
	{
	e.printStackTrace();
	}
	Sheet sh=book.getSheet(Sheetname);
	Object [][]data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0;i<sh.getLastRowNum();i++)
	{
	for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
	{
	data[i][j]=sh.getRow(i+1).getCell(j).toString();
	}
	}
	return data;
	}
	public static ArrayList<Object> ReadAllOption(String Sheetname) throws EncryptedDocumentException,IOException
	{
	FileInputStream file=new FileInputStream(projectpath+"Testdata\\Testdata.xlsx");//launch workbook
	Workbook book=WorkbookFactory.create(file);//file create
	Sheet sheet=book.getSheet(Sheetname);
	int rows=sheet.getLastRowNum();
	System.out.println("no.of rows" +rows);
	ArrayList<Object> data =new ArrayList<Object>();
	for(int i=1;i<sheet.getLastRowNum();i++)//for rows
	{
	data.add(sheet.getRow(i).getCell(0).getStringCellValue());
	}return data;

	}
	//JavascriptExecutor
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	public static void Jsclick(WebElement element)//click
	{
	js.executeScript("argument[0].click();",element);
	}
	public static void JSsendkeys(WebElement element,String str)
	{
	js.executeScript("argument[0].value=arguments[1];",element,str);
	}
	public static void scrollWindow()
	{

	



}
}
