package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		public static Properties property;
		public static WebDriver driver;
		public static EdgeOptions option;
		public static String Projectpath=System.getProperty("user.dir");
		
		public static void initializebrowser(String browser)throws IOException
		{
			FileInputStream fis=new FileInputStream(Projectpath+".\\src\\main\\java\\com\\QA\\Properties\\config.properties");

		}
		
		public BaseClass() 	{
			//String path=System.setProperty("webdriver.Edge.driver","C:\\Users\\shree\\OneDrive\\Desktop\\edgedriver_win64 (4)\\msedgedriver.exe");
			System.out.println(System.getProperty("user.dir"));
			String path=System.getProperty("user.dir")+"src\\main\\java\\com\\QA\\Properties\\config.properties";
			try {
				FileInputStream fis=new FileInputStream(path);
				property=new Properties();
				property.load(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 public static void initializeBrowser()
		 {
			 String browsername=property.getProperty("browser");
			 if(browsername.equals("edge"))
			 {
				 WebDriverManager.edgedriver().setup();
				 //WebDriverManager.chromedriver().setup();
				 option=new EdgeOptions();
				 
				 //option=new ChromeOptions();
				 option.addArguments("--disable-notifications");
				 driver=new EdgeDriver();		 
			 }
			 /*else if(browsername.equals("edge"))
					 {
				 
				 
					 }
			 else if(browsername.equals("firefox"))
			 {
		
		 
			 }*/
			 driver.manage().deleteAllCookies();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.get(property.getProperty("OpenMrs"));
			 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			 
			 
			
		}


}
