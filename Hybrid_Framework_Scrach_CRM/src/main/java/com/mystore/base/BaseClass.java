package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeTest
	public void loadConfig()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\Selenium_Practice\\Hybrid_Framework_Scrach_CRM\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp() {
		//WebDriverManager.chromedriver().setup();
		 String browserName = prop.getProperty("browser");
		 
		 System.out.println("browser names is.."+browserName);
		 
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","F:\\Selenium_Practice\\SampleProject_Test\\Drivers\\chromedriver.exe");  
		      
		       // Instantiate a ChromeDriver class.       
		   
		    
			//WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		Action.implicitWait(driver,10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
	}
}

